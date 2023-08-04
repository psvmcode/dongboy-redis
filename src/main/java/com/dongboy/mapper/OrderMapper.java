package com.dongboy.mapper;

import com.dongboy.entity.SeckillOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    Long saveOrder(SeckillOrder order);
}
