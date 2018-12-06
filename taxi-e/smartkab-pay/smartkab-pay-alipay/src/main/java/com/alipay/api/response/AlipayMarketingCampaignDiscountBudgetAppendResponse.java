package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMarketingCampaignDiscountBudgetAppendResponse extends AlipayResponse {
    private static final long serialVersionUID = 1349329649376664554L;

    @ApiField("budget_id")
    private String budgetId;

    public String getBudgetId() {
        /* 27 */
        return this.budgetId;
    }

    public void setBudgetId(String budgetId) {
        /* 24 */
        this.budgetId = budgetId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMarketingCampaignDiscountBudgetAppendResponse
 * JD-Core Version:    0.6.0
 */