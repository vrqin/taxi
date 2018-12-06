package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;

public class SimpleMockModel extends AlipayObject {
    private static final long serialVersionUID = 1147366816583548819L;

    @ApiField("count_items")
    private Long countItems;

    @ApiField("happen_time")
    private Date happenTime;

    @ApiField("price_num")
    private String priceNum;

    @ApiField("right")
    private Boolean right;

    @ApiField("trade_no")
    private String tradeNo;

    public Long getCountItems() {
        /* 49 */
        return this.countItems;
    }

    public void setCountItems(Long countItems) {
        /* 52 */
        this.countItems = countItems;
    }

    public Date getHappenTime() {
        /* 56 */
        return this.happenTime;
    }

    public void setHappenTime(Date happenTime) {
        /* 59 */
        this.happenTime = happenTime;
    }

    public String getPriceNum() {
        /* 63 */
        return this.priceNum;
    }

    public void setPriceNum(String priceNum) {
        /* 66 */
        this.priceNum = priceNum;
    }

    public Boolean getRight() {
        /* 70 */
        return this.right;
    }

    public void setRight(Boolean right) {
        /* 73 */
        this.right = right;
    }

    public String getTradeNo() {
        /* 77 */
        return this.tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        /* 80 */
        this.tradeNo = tradeNo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.SimpleMockModel
 * JD-Core Version:    0.6.0
 */