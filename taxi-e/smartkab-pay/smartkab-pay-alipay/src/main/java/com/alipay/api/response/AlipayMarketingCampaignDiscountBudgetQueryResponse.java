package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMarketingCampaignDiscountBudgetQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 2347145467244317887L;

    @ApiField("budget_id")
    private String budgetId;

    @ApiField("total_amount")
    private String totalAmount;

    @ApiField("used_amount")
    private String usedAmount;

    public String getBudgetId() {
        /* 39 */
        return this.budgetId;
    }

    public void setBudgetId(String budgetId) {
        /* 36 */
        this.budgetId = budgetId;
    }

    public String getTotalAmount() {
        /* 46 */
        return this.totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        /* 43 */
        this.totalAmount = totalAmount;
    }

    public String getUsedAmount() {
        /* 53 */
        return this.usedAmount;
    }

    public void setUsedAmount(String usedAmount) {
        /* 50 */
        this.usedAmount = usedAmount;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMarketingCampaignDiscountBudgetQueryResponse
 * JD-Core Version:    0.6.0
 */