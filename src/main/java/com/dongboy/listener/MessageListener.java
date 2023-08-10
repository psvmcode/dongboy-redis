package com.dongboy.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Author dongboy
 * @what time    2023/1/13 14:13
 */
@Configuration
public class MessageListener {

    private RedisTemplate redisTemplate;

    @Autowired
    public MessageListener(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Bean
    public void sendMessage() {
        Long test = redisTemplate.opsForList().leftPush("test", 1);
        System.out.println("发送了消息：" + test);
    }

    @Bean
    public void receiveMessage() {
        Object test = redisTemplate.opsForList().rightPop("test");
        System.out.println("接受了消息：" + test);
    }

}
