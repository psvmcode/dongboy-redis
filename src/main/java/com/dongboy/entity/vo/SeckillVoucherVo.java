package com.dongboy.entity.vo;

/**
 * @author dong boy
 * @date 2022年09月14日 10:45
 */
public class SeckillVoucherVo {
    /**
     * 关联的优惠券的id
     */
    private Long voucherId;
    /**
     * 库存
     */
    private Integer stock;

    public SeckillVoucherVo() {
    }

    public SeckillVoucherVo(Long voucherId, Integer stock) {
        this.voucherId = voucherId;
        this.stock = stock;
    }

    public Long getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Long voucherId) {
        this.voucherId = voucherId;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
