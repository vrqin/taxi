package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMarketingCdpAdvertiseReportModel extends AlipayObject {
    private static final long serialVersionUID = 4294786961415447487L;

    @ApiField("ad_id")
    private String adId;

    public String getAdId() {
        /* 23 */
        return this.adId;
    }

    public void setAdId(String adId) {
        /* 26 */
        this.adId = adId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayMarketingCdpAdvertiseReportModel
 * JD-Core Version:    0.6.0
 */