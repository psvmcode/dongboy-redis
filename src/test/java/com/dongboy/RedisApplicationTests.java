package com.dongboy;

import cn.hutool.json.JSONUtil;
import com.dongboy.common.Result;
import com.dongboy.common.constants.RedisKeys;
import com.dongboy.entity.HTable;
import com.dongboy.entity.SeckillCommodity;
import com.dongboy.entity.query.CommodityQuery;
import com.dongboy.entity.vo.CommodityVo;
import com.dongboy.mapper.CommodityMapper;
import com.dongboy.mapper.HTableMapper;
import com.dongboy.service.CommodityService;
import com.dongboy.service.HTableService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class RedisApplicationTests {

    @Autowired
    private CommodityService commodityService;

    @Autowired
    private CommodityMapper commodityMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;


    @Test
    void contextLoads() {
    }

    @Test
    public void addMutilCommodity() {
        for (int i = 11; i <= 100000; i++) {
            SeckillCommodity commodity = new SeckillCommodity();
            commodity.setCdyName("第" + i + "个商品的名称");
            commodity.setCdyDescribe("the " + i + " description!");
            commodity.setCreateTime(LocalDateTime.now());
            commodity.setCdyStatus("1");
            commodity.setCdyPrice(new BigDecimal(0.2 + i));
            commodityMapper.addCommodity(commodity);
        }
    }

    @Resource
    private HTableService hTableService;
    @Resource
    private HTableMapper hTableMapper;

    @Test
    void Test2222() {
        HTable hTable = new HTable();
        hTable.sethId(1);
//        hTable.sethName("bbb");
//        hTable.sethAge(21);
//        hTable.sethBirthday(new Date());
//        Result insert = hTableService.insert(hTable);
//        System.out.println(insert);
//        hTableService.delete(2);
//        hTableService.update(hTable);
        List<HTable> search = hTableMapper.search();
        System.out.println(search);
    }


}
