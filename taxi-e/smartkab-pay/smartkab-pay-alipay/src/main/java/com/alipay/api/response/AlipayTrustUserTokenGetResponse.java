package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayTrustUserTokenGetResponse extends AlipayResponse {
    private static final long serialVersionUID = 5189884842246642471L;

    @ApiField("access_token")
    private String accessToken;

    @ApiField("refresh_token")
    private String refreshToken;

    public String getAccessToken() {
        /* 33 */
        return this.accessToken;
    }

    public void setAccessToken(String accessToken) {
        /* 30 */
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        /* 40 */
        return this.refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        /* 37 */
        this.refreshToken = refreshToken;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayTrustUserTokenGetResponse
 * JD-Core Version:    0.6.0
 */