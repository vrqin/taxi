package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayPointBudgetGetResponse extends AlipayResponse {
    private static final long serialVersionUID = 4564495549418847168L;

    @ApiField("budget_amount")
    private Long budgetAmount;

    public Long getBudgetAmount() {
        /* 27 */
        return this.budgetAmount;
    }

    public void setBudgetAmount(Long budgetAmount) {
        /* 24 */
        this.budgetAmount = budgetAmount;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayPointBudgetGetResponse
 * JD-Core Version:    0.6.0
 */