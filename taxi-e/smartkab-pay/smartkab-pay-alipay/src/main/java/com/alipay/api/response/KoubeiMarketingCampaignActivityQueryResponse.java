package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.CampDetail;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiMarketingCampaignActivityQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 6461558478115398629L;

    @ApiField("camp_detail")
    private CampDetail campDetail;

    public CampDetail getCampDetail() {
        /* 28 */
        return this.campDetail;
    }

    public void setCampDetail(CampDetail campDetail) {
        /* 25 */
        this.campDetail = campDetail;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.KoubeiMarketingCampaignActivityQueryResponse
 * JD-Core Version:    0.6.0
 */