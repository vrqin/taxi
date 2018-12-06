package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipaySystemOauthTokenResponse extends AlipayResponse {
    private static final long serialVersionUID = 2667748517232484194L;

    @ApiField("access_token")
    private String accessToken;

    @ApiField("alipay_user_id")
    private String alipayUserId;

    @ApiField("expires_in")
    private String expiresIn;

    @ApiField("re_expires_in")
    private String reExpiresIn;

    @ApiField("refresh_token")
    private String refreshToken;

    @ApiField("user_id")
    private String userId;

    public String getAccessToken() {
        /* 57 */
        return this.accessToken;
    }

    public void setAccessToken(String accessToken) {
        /* 54 */
        this.accessToken = accessToken;
    }

    public String getAlipayUserId() {
        /* 64 */
        return this.alipayUserId;
    }

    public void setAlipayUserId(String alipayUserId) {
        /* 61 */
        this.alipayUserId = alipayUserId;
    }

    public String getExpiresIn() {
        /* 71 */
        return this.expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        /* 68 */
        this.expiresIn = expiresIn;
    }

    public String getReExpiresIn() {
        /* 78 */
        return this.reExpiresIn;
    }

    public void setReExpiresIn(String reExpiresIn) {
        /* 75 */
        this.reExpiresIn = reExpiresIn;
    }

    public String getRefreshToken() {
        /* 85 */
        return this.refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        /* 82 */
        this.refreshToken = refreshToken;
    }

    public String getUserId() {
        /* 92 */
        return this.userId;
    }

    public void setUserId(String userId) {
        /* 89 */
        this.userId = userId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipaySystemOauthTokenResponse
 * JD-Core Version:    0.6.0
 */