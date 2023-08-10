package com.dongboy.service;

import com.dongboy.common.Result;
import com.dongboy.entity.SeckillVoucher;

/**
 * @author dong boy
 * @date 2022年09月13日 11:01
 */
public interface SeckillVoucherService {

    boolean addSeckillVoucher(SeckillVoucher seckillVoucher);

    Result querySeckillVoucherById(Long vouchId);

    Result setkillVoucher(Long voucherId);

}
