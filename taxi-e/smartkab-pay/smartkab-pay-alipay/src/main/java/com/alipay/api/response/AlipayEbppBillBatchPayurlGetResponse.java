package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayEbppBillBatchPayurlGetResponse extends AlipayResponse {
    private static final long serialVersionUID = 5356846782813933466L;

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
 * Qualified Name:     com.alipay.api.response.AlipayEbppBillBatchPayurlGetResponse
 * JD-Core Version:    0.6.0
 */