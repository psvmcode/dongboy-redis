package com.dongboy.mapper;

import com.dongboy.entity.SeckillVoucher;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SeckillVoucherMapper {
    Long addSeckillVoucher(SeckillVoucher seckillVoucher);

    SeckillVoucher querySeckillVoucherById(Long vouchId);

    boolean updateByIdAndStock(Long voucherId,Integer stock);
    boolean updateById(Long voucherId);
}
