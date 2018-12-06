package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMarketingCampaignDrawcampUpdateResponse extends AlipayResponse {
    private static final long serialVersionUID = 8611358254577381131L;

    @ApiField("camp_result")
    private Boolean campResult;

    public Boolean getCampResult() {
        /* 27 */
        return this.campResult;
    }

    public void setCampResult(Boolean campResult) {
        /* 24 */
        this.campResult = campResult;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMarketingCampaignDrawcampUpdateResponse
 * JD-Core Version:    0.6.0
 */