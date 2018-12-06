package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMarketingCampaignPrizeAmountQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 2153651918764794727L;

    @ApiField("remain_amount")
    private String remainAmount;

    public String getRemainAmount() {
        /* 27 */
        return this.remainAmount;
    }

    public void setRemainAmount(String remainAmount) {
        /* 24 */
        this.remainAmount = remainAmount;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMarketingCampaignPrizeAmountQueryResponse
 * JD-Core Version:    0.6.0
 */