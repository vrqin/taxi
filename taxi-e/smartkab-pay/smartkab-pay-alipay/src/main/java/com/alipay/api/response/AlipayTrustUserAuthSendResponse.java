package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayTrustUserAuthSendResponse extends AlipayResponse {
    private static final long serialVersionUID = 4513176288977361591L;

    @ApiField("result")
    private String result;

    public String getResult() {
        /* 27 */
        return this.result;
    }

    public void setResult(String result) {
        /* 24 */
        this.result = result;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayTrustUserAuthSendResponse
 * JD-Core Version:    0.6.0
 */