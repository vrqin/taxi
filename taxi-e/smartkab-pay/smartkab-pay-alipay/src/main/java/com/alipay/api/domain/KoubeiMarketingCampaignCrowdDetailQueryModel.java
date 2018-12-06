package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiMarketingCampaignCrowdDetailQueryModel extends AlipayObject {
    private static final long serialVersionUID = 1318631962528821127L;

    @ApiField("crowd_group_id")
    private String crowdGroupId;

    public String getCrowdGroupId() {
        /* 23 */
        return this.crowdGroupId;
    }

    public void setCrowdGroupId(String crowdGroupId) {
        /* 26 */
        this.crowdGroupId = crowdGroupId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMarketingCampaignCrowdDetailQueryModel
 * JD-Core Version:    0.6.0
 */