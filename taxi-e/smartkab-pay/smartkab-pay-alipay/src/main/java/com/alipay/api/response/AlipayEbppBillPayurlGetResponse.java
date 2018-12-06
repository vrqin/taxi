package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayEbppBillPayurlGetResponse extends AlipayResponse {
    private static final long serialVersionUID = 6147585384349236467L;

    @ApiField("pay_url")
    private String payUrl;

    public String getPayUrl() {
        /* 27 */
        return this.payUrl;
    }

    public void setPayUrl(String payUrl) {
        /* 24 */
        this.payUrl = payUrl;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayEbppBillPayurlGetResponse
 * JD-Core Version:    0.6.0
 */