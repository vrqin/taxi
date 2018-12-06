package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenAuthTokenAppResponse extends AlipayResponse {
    private static final long serialVersionUID = 1438374632531277781L;

    @ApiField("app_auth_token")
    private String appAuthToken;

    @ApiField("app_refresh_token")
    private String appRefreshToken;

    @ApiField("auth_app_id")
    private String authAppId;

    @ApiField("expires_in")
    private String expiresIn;

    @ApiField("re_expires_in")
    private String reExpiresIn;

    @ApiField("user_id")
    private String userId;

    public String getAppAuthToken() {
        /* 57 */
        return this.appAuthToken;
    }

    public void setAppAuthToken(String appAuthToken) {
        /* 54 */
        this.appAuthToken = appAuthToken;
    }

    public String getAppRefreshToken() {
        /* 64 */
        return this.appRefreshToken;
    }

    public void setAppRefreshToken(String appRefreshToken) {
        /* 61 */
        this.appRefreshToken = appRefreshToken;
    }

    public String getAuthAppId() {
        /* 71 */
        return this.authAppId;
    }

    public void setAuthAppId(String authAppId) {
        /* 68 */
        this.authAppId = authAppId;
    }

    public String getExpiresIn() {
        /* 78 */
        return this.expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        /* 75 */
        this.expiresIn = expiresIn;
    }

    public String getReExpiresIn() {
        /* 85 */
        return this.reExpiresIn;
    }

    public void setReExpiresIn(String reExpiresIn) {
        /* 82 */
        this.reExpiresIn = reExpiresIn;
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
 * Qualified Name:     com.alipay.api.response.AlipayOpenAuthTokenAppResponse
 * JD-Core Version:    0.6.0
 */