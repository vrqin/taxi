package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayTrustUserStandardVerifyGetResponse extends AlipayResponse {
    private static final long serialVersionUID = 4391517637568867952L;

    @ApiField("verify_info")
    private String verifyInfo;

    public String getVerifyInfo() {
        /* 27 */
        return this.verifyInfo;
    }

    public void setVerifyInfo(String verifyInfo) {
        /* 24 */
        this.verifyInfo = verifyInfo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayTrustUserStandardVerifyGetResponse
 * JD-Core Version:    0.6.0
 */