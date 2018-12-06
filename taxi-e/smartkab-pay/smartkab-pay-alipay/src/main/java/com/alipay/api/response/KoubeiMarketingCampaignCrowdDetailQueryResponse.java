package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiMarketingCampaignCrowdDetailQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 3868666436262498751L;

    @ApiField("crowd_group_info")
    private String crowdGroupInfo;

    @ApiField("name")
    private String name;

    public String getCrowdGroupInfo() {
        /* 35 */
        return this.crowdGroupInfo;
    }

    public void setCrowdGroupInfo(String crowdGroupInfo) {
        /* 32 */
        this.crowdGroupInfo = crowdGroupInfo;
    }

    public String getName() {
        /* 42 */
        return this.name;
    }

    public void setName(String name) {
        /* 39 */
        this.name = name;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.KoubeiMarketingCampaignCrowdDetailQueryResponse
 * JD-Core Version:    0.6.0
 */