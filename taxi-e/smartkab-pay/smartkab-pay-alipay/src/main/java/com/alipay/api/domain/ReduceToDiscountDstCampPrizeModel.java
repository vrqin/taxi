package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class ReduceToDiscountDstCampPrizeModel extends AlipayObject {
    private static final long serialVersionUID = 6386825733855487637L;

    @ApiField("budget_id")
    private String budgetId;

    @ApiField("id")
    private String id;

    @ApiField("max_discount_amt")
    private String maxDiscountAmt;

    @ApiField("reduce_to_discount_rate")
    private String reduceToDiscountRate;

    public String getBudgetId() {
        /* 41 */
        return this.budgetId;
    }

    public void setBudgetId(String budgetId) {
        /* 44 */
        this.budgetId = budgetId;
    }

    public String getId() {
        /* 48 */
        return this.id;
    }

    public void setId(String id) {
        /* 51 */
        this.id = id;
    }

    public String getMaxDiscountAmt() {
        /* 55 */
        return this.maxDiscountAmt;
    }

    public void setMaxDiscountAmt(String maxDiscountAmt) {
        /* 58 */
        this.maxDiscountAmt = maxDiscountAmt;
    }

    public String getReduceToDiscountRate() {
        /* 62 */
        return this.reduceToDiscountRate;
    }

    public void setReduceToDiscountRate(String reduceToDiscountRate) {
        /* 65 */
        this.reduceToDiscountRate = reduceToDiscountRate;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.ReduceToDiscountDstCampPrizeModel
 * JD-Core Version:    0.6.0
 */