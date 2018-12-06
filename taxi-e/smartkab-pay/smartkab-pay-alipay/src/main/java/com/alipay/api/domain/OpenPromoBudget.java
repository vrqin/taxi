package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class OpenPromoBudget extends AlipayObject {
    private static final long serialVersionUID = 6123445444269911652L;

    @ApiField("budget_total")
    private String budgetTotal;

    @ApiField("budget_type")
    private String budgetType;

    public String getBudgetTotal() {
        /* 29 */
        return this.budgetTotal;
    }

    public void setBudgetTotal(String budgetTotal) {
        /* 32 */
        this.budgetTotal = budgetTotal;
    }

    public String getBudgetType() {
        /* 36 */
        return this.budgetType;
    }

    public void setBudgetType(String budgetType) {
        /* 39 */
        this.budgetType = budgetType;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.OpenPromoBudget
 * JD-Core Version:    0.6.0
 */