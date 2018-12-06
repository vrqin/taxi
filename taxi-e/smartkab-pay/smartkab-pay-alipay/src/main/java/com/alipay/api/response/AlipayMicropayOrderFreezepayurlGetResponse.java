package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMicropayOrderFreezepayurlGetResponse extends AlipayResponse {
    private static final long serialVersionUID = 2123147968451745996L;

    @ApiField("pay_freeze_url")
    private String payFreezeUrl;

    public String getPayFreezeUrl() {
        /* 27 */
        return this.payFreezeUrl;
    }

    public void setPayFreezeUrl(String payFreezeUrl) {
        /* 24 */
        this.payFreezeUrl = payFreezeUrl;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMicropayOrderFreezepayurlGetResponse
 * JD-Core Version:    0.6.0
 */