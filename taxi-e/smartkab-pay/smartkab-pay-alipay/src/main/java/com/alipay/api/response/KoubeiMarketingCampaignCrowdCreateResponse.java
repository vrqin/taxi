package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiMarketingCampaignCrowdCreateResponse extends AlipayResponse {
    private static final long serialVersionUID = 6738422743875575967L;

    @ApiField("crowd_group_id")
    private String crowdGroupId;

    public String getCrowdGroupId() {
        /* 27 */
        return this.crowdGroupId;
    }

    public void setCrowdGroupId(String crowdGroupId) {
        /* 24 */
        this.crowdGroupId = crowdGroupId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.KoubeiMarketingCampaignCrowdCreateResponse
 * JD-Core Version:    0.6.0
 */