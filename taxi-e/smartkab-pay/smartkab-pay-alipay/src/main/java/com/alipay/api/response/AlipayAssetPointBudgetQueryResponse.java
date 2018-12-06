package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayAssetPointBudgetQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 6381159835198136254L;

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
 * Qualified Name:     com.alipay.api.response.AlipayAssetPointBudgetQueryResponse
 * JD-Core Version:    0.6.0
 */