package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMarketingCampaignDrawcampCreateResponse extends AlipayResponse {
    private static final long serialVersionUID = 2653226642857493537L;

    @ApiField("camp_id")
    private String campId;

    public String getCampId() {
        /* 27 */
        return this.campId;
    }

    public void setCampId(String campId) {
        /* 24 */
        this.campId = campId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMarketingCampaignDrawcampCreateResponse
 * JD-Core Version:    0.6.0
 */