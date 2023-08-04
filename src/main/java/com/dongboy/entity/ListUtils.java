package com.dongboy.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author dongboy
 * @what time    2023/1/16 16:16
 */
@Configuration
public class ListUtils {

    @Bean("myLog")
    public List<StationLog> list() {
        return new CopyOnWriteArrayList<>();
    }

}
