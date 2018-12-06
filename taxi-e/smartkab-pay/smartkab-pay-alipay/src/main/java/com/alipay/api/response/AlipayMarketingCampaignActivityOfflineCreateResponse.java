package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMarketingCampaignActivityOfflineCreateResponse extends AlipayResponse {
    private static final long serialVersionUID = 2833594371989342921L;

    @ApiField("camp_id")
    private String campId;

    @ApiField("prize_id")
    private String prizeId;

    public String getCampId() {
        /* 33 */
        return this.campId;
    }

    public void setCampId(String campId) {
        /* 30 */
        this.campId = campId;
    }

    public String getPrizeId() {
        /* 40 */
        return this.prizeId;
    }

    public void setPrizeId(String prizeId) {
        /* 37 */
        this.prizeId = prizeId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMarketingCampaignActivityOfflineCreateResponse
 * JD-Core Version:    0.6.0
 */