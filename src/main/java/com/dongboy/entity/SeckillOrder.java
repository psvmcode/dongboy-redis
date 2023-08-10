package com.dongboy.entity;

import java.time.LocalDateTime;

/**
 * @author dong boy
 * @date 2022年09月13日 10:57
 * 订单表
 */
public class SeckillOrder {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 购买的代金券id
     */
    private Long voucherId;

    /**
     * 下单时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    public SeckillOrder() {
    }

    public SeckillOrder(Long id, Long voucherId, LocalDateTime createTime, LocalDateTime updateTime) {
        this.id = id;
        this.voucherId = voucherId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Long voucherId) {
        this.voucherId = voucherId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

}
