package com.dongboy.entity.vo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author dong boy
 * @date 2022年09月18日 19:29
 */
public class CommodityVo {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String cdyName;
    private String cdyDescribe;
    private LocalDateTime createTime;
    private String cdyStatus;
    private BigDecimal cdyPrice;

    public CommodityVo() {
    }

    public CommodityVo(Long id, String cdyName, String cdyDescribe, LocalDateTime createTime, String cdyStatus, BigDecimal cdyPrice) {
        this.id = id;
        this.cdyName = cdyName;
        this.cdyDescribe = cdyDescribe;
        this.createTime = createTime;
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
