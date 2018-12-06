package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayDataItemSalesRule extends AlipayObject {
    private static final long serialVersionUID = 8817153852767722329L;

    @ApiField("buyer_crowd_limit")
    private String buyerCrowdLimit;

    @ApiField("daily_sales_limit")
    private Long dailySalesLimit;

    @ApiListField("user_sales_limit")
    @ApiField("string")
    private List<String> userSalesLimit;

    public String getBuyerCrowdLimit() {
        /* 41 */
        return this.buyerCrowdLimit;
    }

    public void setBuyerCrowdLimit(String buyerCrowdLimit) {
        /* 44 */
        this.buyerCrowdLimit = buyerCrowdLimit;
    }

    public Long getDailySalesLimit() {
        /* 48 */
        return this.dailySalesLimit;
    }

    public void setDailySalesLimit(Long dailySalesLimit) {
        /* 51 */
        this.dailySalesLimit = dailySalesLimit;
    }

    public List<String> getUserSalesLimit() {
        /* 55 */
        return this.userSalesLimit;
    }

    public void setUserSalesLimit(List<String> userSalesLimit) {
        /* 58 */
        this.userSalesLimit = userSalesLimit;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayDataItemSalesRule
 * JD-Core Version:    0.6.0
 */