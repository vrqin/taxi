package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayAppTokenGetResponse extends AlipayResponse {
    private static final long serialVersionUID = 7382181958151687886L;

    @ApiField("app_access_token")
    private String appAccessToken;

    @ApiField("expires_in")
    private Long expiresIn;

    public String getAppAccessToken() {
        /* 33 */
        return this.appAccessToken;
    }

    public void setAppAccessToken(String appAccessToken) {
        /* 30 */
        this.appAccessToken = appAccessToken;
    }

    public Long getExpiresIn() {
        /* 40 */
        return this.expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        /* 37 */
        this.expiresIn = expiresIn;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayAppTokenGetResponse
 * JD-Core Version:    0.6.0
 */