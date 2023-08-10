package com.dongboy.service.impl;

import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.dongboy.common.Result;
import com.dongboy.common.constants.RedisKeys;
import com.dongboy.common.utils.RedisLock;
import com.dongboy.common.utils.SnowflakeIdWorker;
import com.dongboy.entity.SeckillOrder;
import com.dongboy.entity.SeckillVoucher;
import com.dongboy.mapper.SeckillVoucherMapper;
import com.dongboy.service.OrderService;
import com.dongboy.service.SeckillVoucherService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @author dong boy
 * @date 2022年09月13日 13:26
 */
@Service
public class SeckillVoucherServiceImpl implements SeckillVoucherService {

    @Resource
    private OrderService orderService;

    @Resource
    private SeckillVoucherMapper seckillVoucherMapper;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean addSeckillVoucher(SeckillVoucher seckillVoucher) {
        seckillVoucher.setCreateTime(LocalDateTime.now());
        seckillVoucher.setBeginTime(LocalDateTime.now());
        seckillVoucher.setEndTime(LocalDateTime.now().plusDays(1L));
        Long vouchId = seckillVoucherMapper.addSeckillVoucher(seckillVoucher);
        return vouchId > 0;
    }

    @Override
    public Result querySeckillVoucherById(Long vouchId) {
        // 互斥锁解决缓存击穿
        SeckillVoucher voucher = queryWithMutex(vouchId);
        if (voucher == null) {
            return Result.failed("优惠券不存在！");
        }
        return Result.success(voucher);
    }

    // 互斥锁解决缓存击穿
    public SeckillVoucher queryWithMutex(Long voucherId) {
        String key = RedisKeys.VOUCHER_KEY + voucherId;
        // 从redis查询优惠券数据
        String voucher = stringRedisTemplate.opsForValue().get(key);
        // 判断店铺是否存在
        if (StrUtil.isNotBlank(voucher)) {
            // 存在则直接返回
            return JSONUtil.toBean(voucher, SeckillVoucher.class);
        }
        // 判断命中的是否是空值
        if (voucher != null) {
            return null;
        }
        // 实现缓存重建
        // 休眠200毫秒模拟缓存重建延迟
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SeckillVoucher seckillVoucher = null;
        // 获取互斥锁
        String lockKey = "lock:voucher:" + voucher;
        try {
            boolean isLock = tryLock(lockKey);
            // 判断是否获取成功
            if (!isLock) {
                // 获取锁失败，休眠后重新尝试获取
                Thread.sleep(50);
                // 循环查询
                return queryWithMutex(voucherId);
            }
            // 获取锁成功则重建缓存业务
            seckillVoucher = seckillVoucherMapper.querySeckillVoucherById(voucherId);
            // 不存在，返回空
            if (seckillVoucher == null) {
                // 将空值写入redis
                stringRedisTemplate.opsForValue().set(key, "", 1, TimeUnit.MINUTES);
                return null;
            }
            // 存在，写入redis
            cacheCommodityToRedis(voucherId, seckillVoucher, 1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 释放锁
            unlock(lockKey);
        }
        return seckillVoucher;
    }

    @Async
    public void cacheCommodityToRedis(Long voucherId, SeckillVoucher seckillVoucher, Long time) {
        stringRedisTemplate.opsForValue().set(RedisKeys.VOUCHER_KEY + voucherId, JSONUtil.toJsonStr(seckillVoucher), time, TimeUnit.MINUTES);
    }

    // 获取锁
    private boolean tryLock(String key) {
        Boolean aBoolean = stringRedisTemplate.opsForValue().setIfAbsent(key, "1", 10, TimeUnit.SECONDS);
        return BooleanUtil.isTrue(aBoolean);
    }

    // 删除锁
    private void unlock(String key) {
        stringRedisTemplate.delete(key);
    }

    @Override
    @Transactional
    public Result setkillVoucher(Long voucherId) {
        // 查询优惠券
        SeckillVoucher voucher = seckillVoucherMapper.querySeckillVoucherById(voucherId);
        // 查询秒杀是否开始
        if (voucher.getBeginTime().isAfter(LocalDateTime.now())) {
            // 尚未开始
            return Result.failed("秒杀尚未开始!");
        }
        // 判断秒杀是否已经结束
        if (voucher.getEndTime().isBefore(LocalDateTime.now())) {
            return Result.failed("秒杀已经结束！");
        }
        // 判断库存是否充足
        if (voucher.getStock() < 1) {
            // 库存不足
            return Result.failed("库存不足!");
        }
        // 返回订单id
//        return createVoucherOrderByOptimisticLocking(voucherId, voucher.getStock()); // 乐观锁减库存
        return createVoucherByRedisSetnxLock(voucherId); // 悲观锁减库存
    }

    @Transactional
    public Result createVoucherByRedisSetnxLock(Long voucherId) {
        // 创建锁对象,锁的范围是当前订单业务
        RedisLock lock = new RedisLock(RedisKeys.VOUCHER_KEY + voucherId, stringRedisTemplate);
        // 获取锁
        boolean isLock = lock.tryLock(2000);
        // 判断是否获取锁成功
        if (!isLock) {
            // 获取锁失败，这里测试采取沉默后重复下单
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                setkillVoucher(voucherId);
            }
//            return Result.failed("抢购失败");
        }
        try {
            // 扣减库存
            boolean success = seckillVoucherMapper.updateById(voucherId);
            if (!success) {
                return Result.failed("抢购失败");
            }
            // 创建订单
            SeckillOrder order = new SeckillOrder();
            // 雪花算法生成分布式ID
            SnowflakeIdWorker idWorker = new SnowflakeIdWorker();
            Long orderId = idWorker.nextId();
            order.setId(orderId);
            order.setVoucherId(voucherId);
            order.setCreateTime(LocalDateTime.now());
            orderService.saveOrder(order);
            return Result.success(order, "添加成功");
        } finally {
            // 释放锁
            lock.unlock();
        }
    }

    @Transactional
    public Result createVoucherOrderByOptimisticLocking(Long voucherId, Integer stock) {
        // 扣减库存
        boolean success = seckillVoucherMapper.updateByIdAndStock(voucherId, stock);
        if (!success) {
            return Result.failed("前后数据不一致，抢购失败");
        }
        // 创建订单
        SeckillOrder order = new SeckillOrder();
        // 雪花算法生成分布式ID
        SnowflakeIdWorker idWorker = new SnowflakeIdWorker();
        Long orderId = idWorker.nextId();
        order.setId(orderId);
        order.setVoucherId(voucherId);
        order.setCreateTime(LocalDateTime.now());
        orderService.saveOrder(order);
        return Result.success(order, "添加成功");
    }

}
