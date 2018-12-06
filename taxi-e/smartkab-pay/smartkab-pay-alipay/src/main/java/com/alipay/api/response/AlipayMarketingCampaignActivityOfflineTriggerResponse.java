package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMarketingCampaignActivityOfflineTriggerResponse extends AlipayResponse {
    private static final long serialVersionUID = 5124344198518953157L;

    @ApiField("out_prize_id")
    private String outPrizeId;

    public String getOutPrizeId() {
        /* 27 */
        return this.outPrizeId;
    }

    public void setOutPrizeId(String outPrizeId) {
        /* 24 */
        this.outPrizeId = outPrizeId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMarketingCampaignActivityOfflineTriggerResponse
 * JD-Core Version:    0.6.0
 */