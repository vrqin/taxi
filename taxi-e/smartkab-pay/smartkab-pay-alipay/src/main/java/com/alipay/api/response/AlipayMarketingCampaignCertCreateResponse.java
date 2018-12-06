package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMarketingCampaignCertCreateResponse extends AlipayResponse {
    private static final long serialVersionUID = 1779875239527331546L;

    @ApiField("lot_number")
    private String lotNumber;

    public String getLotNumber() {
        /* 27 */
        return this.lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        /* 24 */
        this.lotNumber = lotNumber;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMarketingCampaignCertCreateResponse
 * JD-Core Version:    0.6.0
 */