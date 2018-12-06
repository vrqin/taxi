package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMarketingCampaignDiscountBudgetAppendModel extends AlipayObject {
    private static final long serialVersionUID = 4567977331491785987L;

    @ApiField("budget_id")
    private String budgetId;

    @ApiField("total_amount")
    private String totalAmount;

    public String getBudgetId() {
        /* 29 */
        return this.budgetId;
    }

    public void setBudgetId(String budgetId) {
        /* 32 */
        this.budgetId = budgetId;
    }

    public String getTotalAmount() {
        /* 36 */
        return this.totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        /* 39 */
        this.totalAmount = totalAmount;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayMarketingCampaignDiscountBudgetAppendModel
 * JD-Core Version:    0.6.0
 */