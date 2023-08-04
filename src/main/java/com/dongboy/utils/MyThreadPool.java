package com.dongboy.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author dongboy
 * @what time    2023/3/30 11:03
 */
@Configuration
public class MyThreadPool {

    private static Logger logger = LoggerFactory.getLogger(MyThreadPool.class);

    private static int coreNums = Runtime.getRuntime().availableProcessors();

    @Bean(name = "forGXSZ")
    public ThreadPoolTaskExecutor forGXSZ() {
        System.out.println("初始化线程池:" + "forGXSZ");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 核心线程数
        executor.setCorePoolSize(4 * coreNums);
        // 最大线程数
        executor.setMaxPoolSize(8 * coreNums);
        // 核心线程数外的线程存活时间
        executor.setKeepAliveSeconds(0);
        // 任务队列大小
        executor.setQueueCapacity(4 * coreNums);
        // 线程名称前缀
        executor.setThreadNamePrefix("forGXSZ_");
        // 线程池拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        // 当前任务完成后，长时间无待处理任务时，销毁线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        logger.info("", Thread.currentThread().getId());
        return executor;
    }

}
