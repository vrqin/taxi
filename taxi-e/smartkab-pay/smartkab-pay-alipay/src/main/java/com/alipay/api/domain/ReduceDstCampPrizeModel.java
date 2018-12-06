package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class ReduceDstCampPrizeModel extends AlipayObject {
    private static final long serialVersionUID = 7423612333864155681L;

    @ApiField("budget_id")
    private String budgetId;

    @ApiField("id")
    private String id;

    @ApiField("max_discount_amt")
    private String maxDiscountAmt;

    @ApiField("reduce_amt_pre")
    private String reduceAmtPre;

    @ApiField("reduce_amt_suf")
    private String reduceAmtSuf;

    public String getBudgetId() {
        /* 47 */
        return this.budgetId;
    }

    public void setBudgetId(String budgetId) {
        /* 50 */
        this.budgetId = budgetId;
    }

    public String getId() {
        /* 54 */
        return this.id;
    }

    public void setId(String id) {
        /* 57 */
        this.id = id;
    }

    public String getMaxDiscountAmt() {
        /* 61 */
        return this.maxDiscountAmt;
    }

    public void setMaxDiscountAmt(String maxDiscountAmt) {
        /* 64 */
        this.maxDiscountAmt = maxDiscountAmt;
    }

    public String getReduceAmtPre() {
        /* 68 */
        return this.reduceAmtPre;
    }

    public void setReduceAmtPre(String reduceAmtPre) {
        /* 71 */
        this.reduceAmtPre = reduceAmtPre;
    }

    public String getReduceAmtSuf() {
        /* 75 */
        return this.reduceAmtSuf;
    }

    public void setReduceAmtSuf(String reduceAmtSuf) {
        /* 78 */
        this.reduceAmtSuf = reduceAmtSuf;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.ReduceDstCampPrizeModel
 * JD-Core Version:    0.6.0
 */