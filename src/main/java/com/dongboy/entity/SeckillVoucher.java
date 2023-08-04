package com.dongboy.entity;

import java.time.LocalDateTime;

/**
 * @author dong boy
 * @date 2022年09月13日 10:54
 * 秒杀优惠券表，与优惠券是一对一关系
 */
public class SeckillVoucher {
    private static final long serialVersionUID = 1L;
    /**
     * 关联的优惠券的id
     */
    private Long voucherId;
    /**
     * 库存
     */
    private Integer stock;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 生效时间
     */
    private LocalDateTime beginTime;

    /**
     * 失效时间
     */
    private LocalDateTime endTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    public SeckillVoucher() {
    }

    public SeckillVoucher(Long voucherId, Integer stock, LocalDateTime createTime, LocalDateTime beginTime, LocalDateTime endTime, LocalDateTime updateTime) {
        this.voucherId = voucherId;
        this.stock = stock;
        this.createTime = createTime;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.updateTime = updateTime;
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

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(LocalDateTime beginTime) {
        this.beginTime = beginTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
