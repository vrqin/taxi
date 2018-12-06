package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMarketingCampaignDrawcampWhitelistCreateResponse extends AlipayResponse {
    private static final long serialVersionUID = 1639333332569198568L;

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
 * Qualified Name:     com.alipay.api.response.AlipayMarketingCampaignDrawcampWhitelistCreateResponse
 * JD-Core Version:    0.6.0
 */