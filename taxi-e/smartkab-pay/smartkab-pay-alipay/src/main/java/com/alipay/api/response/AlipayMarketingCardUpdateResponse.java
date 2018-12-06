package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMarketingCardUpdateResponse extends AlipayResponse {
    private static final long serialVersionUID = 6195413958753277755L;

    @ApiField("result_code")
    private String resultCode;

    public String getResultCode() {
        /* 27 */
        return this.resultCode;
    }

    public void setResultCode(String resultCode) {
        /* 24 */
        this.resultCode = resultCode;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMarketingCardUpdateResponse
 * JD-Core Version:    0.6.0
 */