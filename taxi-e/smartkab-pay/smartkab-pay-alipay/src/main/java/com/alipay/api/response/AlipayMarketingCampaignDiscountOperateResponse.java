package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMarketingCampaignDiscountOperateResponse extends AlipayResponse {
    private static final long serialVersionUID = 6743533837953688752L;

    @ApiField("camp_id")
    private String campId;

    public String getCampId() {
        /* 27 */
        return this.campId;
    }

    public void setCampId(String campId) {
        /* 24 */
        this.campId = campId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMarketingCampaignDiscountOperateResponse
 * JD-Core Version:    0.6.0
 */