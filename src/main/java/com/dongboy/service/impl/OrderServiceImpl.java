package com.dongboy.service.impl;

import com.dongboy.entity.SeckillOrder;
import com.dongboy.mapper.OrderMapper;
import com.dongboy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author dong boy
 * @date 2022年09月13日 13:25
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Long saveOrder(SeckillOrder order) {
        return orderMapper.saveOrder(order);
    }
}
