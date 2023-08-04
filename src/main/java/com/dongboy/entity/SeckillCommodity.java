package com.dongboy.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author dong boy
 * @date 2022年09月18日 19:18
 */
public class SeckillCommodity {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String cdyName;
    private String cdyDescribe;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String cdyStatus;
    private BigDecimal cdyPrice;

    public SeckillCommodity() {
    }

    public SeckillCommodity(Long id, String cdyName, String cdyDescribe, LocalDateTime createTime, LocalDateTime updateTime, String cdyStatus, BigDecimal cdyPrice) {
        this.id = id;
        this.cdyName = cdyName;
        this.cdyDescribe = cdyDescribe;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.cdyStatus = cdyStatus;
        this.cdyPrice = cdyPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCdyName() {
        return cdyName;
    }

    public void setCdyName(String cdyName) {
        this.cdyName = cdyName;
    }

    public String getCdyDescribe() {
        return cdyDescribe;
    }

    public void setCdyDescribe(String cdyDescribe) {
        this.cdyDescribe = cdyDescribe;
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

    public String getCdyStatus() {
        return cdyStatus;
    }

    public void setCdyStatus(String cdyStatus) {
        this.cdyStatus = cdyStatus;
    }

    public BigDecimal getCdyPrice() {
        return cdyPrice;
    }

    public void setCdyPrice(BigDecimal cdyPrice) {
        this.cdyPrice = cdyPrice;
    }
}
