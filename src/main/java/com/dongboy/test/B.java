package com.dongboy.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author dongboy
 * @what time    2023/1/12 22:19
 */
@Configuration
public class B {
    @Autowired
    private C c;


}
