package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class ResetZeroDstCampPrizeModel extends AlipayObject {
    private static final long serialVersionUID = 4632514143256273472L;

    @ApiField("budget_id")
    private String budgetId;

    @ApiField("id")
    private String id;

    @ApiField("max_discount_amt")
    private String maxDiscountAmt;

    @ApiField("reset_zero_amt")
    private String resetZeroAmt;

    public String getBudgetId() {
        /* 45 */
        return this.budgetId;
    }

    public void setBudgetId(String budgetId) {
        /* 48 */
        this.budgetId = budgetId;
    }

    public String getId() {
        /* 52 */
        return this.id;
    }

    public void setId(String id) {
        /* 55 */
        this.id = id;
    }

    public String getMaxDiscountAmt() {
        /* 59 */
        return this.maxDiscountAmt;
    }

    public void setMaxDiscountAmt(String maxDiscountAmt) {
        /* 62 */
        this.maxDiscountAmt = maxDiscountAmt;
    }

    public String getResetZeroAmt() {
        /* 66 */
        return this.resetZeroAmt;
    }

    public void setResetZeroAmt(String resetZeroAmt) {
        /* 69 */
        this.resetZeroAmt = resetZeroAmt;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.ResetZeroDstCampPrizeModel
 * JD-Core Version:    0.6.0
 */