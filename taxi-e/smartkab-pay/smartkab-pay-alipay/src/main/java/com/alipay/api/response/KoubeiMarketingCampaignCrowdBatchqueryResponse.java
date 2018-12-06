package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiMarketingCampaignCrowdBatchqueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 3437675354249616747L;

    @ApiField("crowd_group_sets")
    private String crowdGroupSets;

    @ApiField("total_number")
    private String totalNumber;

    public String getCrowdGroupSets() {
        /* 33 */
        return this.crowdGroupSets;
    }

    public void setCrowdGroupSets(String crowdGroupSets) {
        /* 30 */
        this.crowdGroupSets = crowdGroupSets;
    }

    public String getTotalNumber() {
        /* 40 */
        return this.totalNumber;
    }

    public void setTotalNumber(String totalNumber) {
        /* 37 */
        this.totalNumber = totalNumber;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.KoubeiMarketingCampaignCrowdBatchqueryResponse
 * JD-Core Version:    0.6.0
 */