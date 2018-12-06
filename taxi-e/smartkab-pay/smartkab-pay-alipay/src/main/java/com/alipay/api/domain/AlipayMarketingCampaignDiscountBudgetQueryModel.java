package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMarketingCampaignDiscountBudgetQueryModel extends AlipayObject {
    private static final long serialVersionUID = 5178634254471543713L;

    @ApiField("budget_id")
    private String budgetId;

    public String getBudgetId() {
        /* 23 */
        return this.budgetId;
    }

    public void setBudgetId(String budgetId) {
        /* 26 */
        this.budgetId = budgetId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayMarketingCampaignDiscountBudgetQueryModel
 * JD-Core Version:    0.6.0
 */