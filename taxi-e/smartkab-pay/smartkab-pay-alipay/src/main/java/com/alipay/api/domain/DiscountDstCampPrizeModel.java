package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class DiscountDstCampPrizeModel extends AlipayObject {
    private static final long serialVersionUID = 4385128984798959928L;

    @ApiField("budget_id")
    private String budgetId;

    @ApiField("discount_rate")
    private String discountRate;

    @ApiField("id")
    private String id;

    @ApiField("max_discount_amt")
    private String maxDiscountAmt;

    public String getBudgetId() {
        /* 41 */
        return this.budgetId;
    }

    public void setBudgetId(String budgetId) {
        /* 44 */
        this.budgetId = budgetId;
    }

    public String getDiscountRate() {
        /* 48 */
        return this.discountRate;
    }

    public void setDiscountRate(String discountRate) {
        /* 51 */
        this.discountRate = discountRate;
    }

    public String getId() {
        /* 55 */
        return this.id;
    }

    public void setId(String id) {
        /* 58 */
        this.id = id;
    }

    public String getMaxDiscountAmt() {
        /* 62 */
        return this.maxDiscountAmt;
    }

    public void setMaxDiscountAmt(String maxDiscountAmt) {
        /* 65 */
        this.maxDiscountAmt = maxDiscountAmt;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.DiscountDstCampPrizeModel
 * JD-Core Version:    0.6.0
 */