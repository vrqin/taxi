package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMarketingCdpAdvertiseCreateResponse extends AlipayResponse {
    private static final long serialVersionUID = 6497385925149189574L;

    @ApiField("ad_id")
    private String adId;

    public String getAdId() {
        /* 27 */
        return this.adId;
    }

    public void setAdId(String adId) {
        /* 24 */
        this.adId = adId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMarketingCdpAdvertiseCreateResponse
 * JD-Core Version:    0.6.0
 */