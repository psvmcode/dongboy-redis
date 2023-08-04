//package com.dongboy.test;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.task.TaskDecorator;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//
//import javax.annotation.PostConstruct;
//import java.util.List;
//import java.util.concurrent.Future;
//import java.util.concurrent.FutureTask;
//import java.util.concurrent.ThreadPoolExecutor;
//
//
///**
// * @Author dongboy
// * @what time    2023/1/14 16:04
// */
//@Configuration
//@EnableAsync
//public class MyThread {
//
//    private static Logger logger = LoggerFactory.getLogger(MyThread.class);
//
//    @Bean(value = "testOne")
//    public ThreadPoolTaskExecutor testOne() {
//        System.out.println("初始化Bean:" + "testOne");
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        // 核心线程数
//        executor.setCorePoolSize(4);
//        // 最大线程数
//        executor.setMaxPoolSize(8);
//        // 核心线程数外的线程存活时间
//        executor.setKeepAliveSeconds(0);
//        // 任务队列大小
//        executor.setQueueCapacity(8);
//        // 线程名称前缀
//        executor.setThreadNamePrefix("test_");
//        // 异步重算线程池修饰器
//        executor.setTaskDecorator(new AsyncExxcutorDecorator());
//        // 线程池拒绝策略
//        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
//        // 当前任务完成后，长时间无待处理任务时，销毁线程池
//        executor.setWaitForTasksToCompleteOnShutdown(true);
//        logger.info("", Thread.currentThread().getId());
//        return executor;
//    }
//
//    class AsyncExxcutorDecorator implements TaskDecorator {
//        @Override
//        public Runnable decorate(Runnable runnable) {
//            return () -> {
//                runnable.run();
//            };
//        }
//    }
//
//    @PostConstruct
//    @Bean
//    public String myString() {
//        String s = "加载自定义String";
//        System.out.println(s);
//        return s;
//    }
//}
