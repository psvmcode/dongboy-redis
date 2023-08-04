package com.dongboy.test;

import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * @Author dongboy
 * @what time    2023/1/12 22:19
 */
@Configuration
@DependsOn("b")
public class C {

    @Resource
    private B b;

    @Async
    @Transactional(rollbackFor = Exception.class)
    public void test() {
        AopUtils.isAopProxy(C.class);
    }

}
