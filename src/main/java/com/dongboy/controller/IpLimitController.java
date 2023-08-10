package com.dongboy.controller;

import com.dongboy.annotation.IpLimit;
import com.dongboy.enums.IpLimitType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author dongboy
 * @what time    2023/1/12 19:19
 */
@RestController
public class IpLimitController {

    private static final AtomicInteger ATOMIC_INTEGER_1 = new AtomicInteger();

    @IpLimit(key = "customer_limit_test", period = 10, count = 3, limitType = IpLimitType.CUSTOMER)
    @GetMapping("/ipLimitTest")
    public int testLimiter2() {
        return ATOMIC_INTEGER_1.incrementAndGet();
    }

}
