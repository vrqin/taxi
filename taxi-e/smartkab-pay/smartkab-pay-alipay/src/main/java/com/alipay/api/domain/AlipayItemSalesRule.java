package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayItemSalesRule extends AlipayObject {
    private static final long serialVersionUID = 4461745764264395874L;

    @ApiListField("buyer_crowd_limit")
    @ApiField("string")
    private List<String> buyerCrowdLimit;

    @ApiField("daily_sales_limit")
    private Long dailySalesLimit;

    @ApiField("user_sales_limit")
    private String userSalesLimit;

    public List<String> getBuyerCrowdLimit() {
        /* 41 */
        return this.buyerCrowdLimit;
    }

    public void setBuyerCrowdLimit(List<String> buyerCrowdLimit) {
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

    public String getUserSalesLimit() {
        /* 55 */
        return this.userSalesLimit;
    }

    public void setUserSalesLimit(String userSalesLimit) {
        /* 58 */
        this.userSalesLimit = userSalesLimit;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayItemSalesRule
 * JD-Core Version:    0.6.0
 */