package com.dongboy.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.dongboy.common.Result;
import com.dongboy.common.constants.RedisKeys;
import com.dongboy.entity.SeckillCommodity;
import com.dongboy.entity.query.CommodityQuery;
import com.dongboy.entity.vo.CommodityVo;
import com.dongboy.mapper.CommodityMapper;
import com.dongboy.service.CommodityService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

import static com.dongboy.common.constants.RedisKeys.COMMODITY_KEY;

/**
 * @author dong boy
 * @date 2022年09月18日 19:21
 */
@Service
public class CommodityServiceImpl implements CommodityService {

    @Resource
    private CommodityMapper commodityMapper;

    @Resource
    private StringRedisTemplate redisTemplate;

    // todo 用线程池给这个业务分配线程资源
    @Override
    public boolean addCommodity(SeckillCommodity seckillCommodity) {
        seckillCommodity.setCreateTime(LocalDateTime.now());
        Long commodityId = commodityMapper.addCommodity(seckillCommodity);
        return commodityId > 0;
    }

    @Override
    public List<CommodityVo> list(CommodityQuery query) {
        // 先从redis里查询数据
        List<String> stringList = redisTemplate.opsForList().range(RedisKeys.COMMODITY_LIST_KEY, 0, -1);
        // redis有就直接返回
        if (!CollectionUtils.isEmpty(stringList)) {
            List<CommodityVo> list = new ArrayList<>();
            List<CommodityVo> res = list;
            stringList.stream().forEach(e -> {
                list.add(JSONUtil.toBean(e, CommodityVo.class));
            });
            if (!StringUtils.isEmpty(query.getCdyName())) {
                res = list.stream().filter(e -> e.getCdyName().contains(query.getCdyName())).collect(Collectors.toList());
            }
            if (!StringUtils.isEmpty(query.getTopPrice())) {
                res = res.stream().filter(e -> e.getCdyPrice().compareTo(query.getTopPrice()) < 1).collect(Collectors.toList());
            }
            if (!StringUtils.isEmpty(query.getBotomPrice())) {
                res = res.stream().filter(e -> e.getCdyPrice().compareTo(query.getBotomPrice()) > -1).collect(Collectors.toList());
            }
            return res;
        }
        // redis没有就查询数据库
        List<CommodityVo> list = commodityMapper.list(query);
        // 然后存进redis
        saveCommodityToRredis();
        return list;
    }

    @Async
    public void saveCommodityToRredis() {
        List<CommodityVo> list = commodityMapper.list(new CommodityQuery());
        list.stream().forEach(e -> {
            redisTemplate.opsForList().rightPush(RedisKeys.COMMODITY_LIST_KEY, JSONUtil.toJsonStr(e));
            redisTemplate.expire(RedisKeys.COMMODITY_LIST_KEY, 30L, TimeUnit.MINUTES); // 设置30分钟过期时间
        });
    }

    @Override
    @Transactional
    public int update(CommodityVo commodityVo) {
        // 先修改数据库
        int res = commodityMapper.update(commodityVo);
        // 再删除缓存
        deleteCommodityCache();
        return res;
    }

    @Override
    public Result getCommodityById(Long commodityId) {
        // 先查缓存
        String commodityString = redisTemplate.opsForValue().get(COMMODITY_KEY + commodityId);
        // 缓存存在直接返回
        if (StrUtil.isNotBlank(commodityString)) {
            CommodityVo commodityVo = JSONUtil.toBean(commodityString, CommodityVo.class);
            return Result.success(commodityVo);
        }
        // 如果内容为空，说名不存在
        if (commodityString != null) {
            return Result.failed("商品信息不存在！");
        }
        // 查询数据库
        CommodityVo commodityVo = commodityMapper.getCommodityById(commodityId);
        // 数据库未命中则建立空缓存后返回错误信息
        if (commodityVo == null) {
            // 数据库不存在则存空值并建立TTL后返回
            //直接存空对象到redsi再返回
            redisTemplate.opsForValue().set(COMMODITY_KEY + commodityId, "", 100L, TimeUnit.SECONDS);
            return Result.failed("商品信息不存在！");
        }
        // 数据库命中则缓存并返回
        cacheCommodityToRedis(commodityId, commodityVo, 300L);
        return Result.success(commodityVo);
    }

    @Async
    public void cacheCommodityToRedis(Long commodityId, CommodityVo commodityVo, Long time) {
        redisTemplate.opsForValue().set(COMMODITY_KEY + commodityId, JSONUtil.toJsonStr(commodityVo), time, TimeUnit.SECONDS);
    }

    @Async
    public void deleteCommodityCache() {
        if (redisTemplate.hasKey(RedisKeys.COMMODITY_LIST_KEY)) {
            redisTemplate.delete(RedisKeys.COMMODITY_LIST_KEY);
        }
    }

}
