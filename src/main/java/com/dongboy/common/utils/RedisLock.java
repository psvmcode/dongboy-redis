package com.dongboy.common.utils;

import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author dong boy
 * @date 2022年09月13日 14:53
 * Redis锁实现
 */
public class RedisLock implements Lock {

    private StringRedisTemplate stringRedisTemplate;

    private String name; // 锁的名称，不用的业务有不同的锁

    public RedisLock(String name, StringRedisTemplate stringRedisTemplate) {
        this.name = name;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    /**
     * 获取锁
     *
     * @param timeoutSec
     * @return boolean
     * @author dong boy
     */
    @Override
    public boolean tryLock(long timeoutSec) {
        String key = name; // 锁名称设为业务名称
        // 获取锁
        Boolean success = stringRedisTemplate.opsForValue()
                .setIfAbsent(key, "1", timeoutSec, TimeUnit.SECONDS);
        return Boolean.TRUE.equals(success); // 避免空指针的风险 Boolean转化为boolean自动拆箱
    }

    /**
     * 释放锁
     *
     * @author dong boy
     */
    @Override
    public void unlock() {
        // 释放锁
        String key = name;
        stringRedisTemplate.delete(key);
    }

}
