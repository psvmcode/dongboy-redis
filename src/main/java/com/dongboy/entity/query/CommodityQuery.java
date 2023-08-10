package com.dongboy.entity.query;

import java.math.BigDecimal;

/**
 * @author dong boy
 * @date 2022年09月18日 19:25
 */
public class CommodityQuery {

    private String cdyName;

    private BigDecimal topPrice;

    private BigDecimal bottomPrice;

    public CommodityQuery() {
    }

    public CommodityQuery(String cdyName, BigDecimal topPrice, BigDecimal botomPrice) {
        this.cdyName = cdyName;
        this.topPrice = topPrice;
        this.bottomPrice = botomPrice;
    }

    public String getCdyName() {
        return cdyName;
    }

    public void setCdyName(String cdyName) {
        this.cdyName = cdyName;
    }

    public BigDecimal getTopPrice() {
        return topPrice;
    }

    public void setTopPrice(BigDecimal topPrice) {
        this.topPrice = topPrice;
    }

    public BigDecimal getBotomPrice() {
        return bottomPrice;
    }

    public void setBotomPrice(BigDecimal botomPrice) {
        this.bottomPrice = botomPrice;
    }

}
