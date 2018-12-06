package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class SingleDstCampPrizeModel extends AlipayObject {
    private static final long serialVersionUID = 3663728378995273355L;

    @ApiField("budget_id")
    private String budgetId;

    @ApiField("id")
    private String id;

    @ApiField("reduce_amt")
    private String reduceAmt;

    public String getBudgetId() {
        /* 35 */
        return this.budgetId;
    }

    public void setBudgetId(String budgetId) {
        /* 38 */
        this.budgetId = budgetId;
    }

    public String getId() {
        /* 42 */
        return this.id;
    }

    public void setId(String id) {
        /* 45 */
        this.id = id;
    }

    public String getReduceAmt() {
        /* 49 */
        return this.reduceAmt;
    }

    public void setReduceAmt(String reduceAmt) {
        /* 52 */
        this.reduceAmt = reduceAmt;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.SingleDstCampPrizeModel
 * JD-Core Version:    0.6.0
 */