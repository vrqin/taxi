package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenAuthIndustryPlatformCreateTokenResponse extends AlipayResponse {
    private static final long serialVersionUID = 8763515191317881813L;

    @ApiField("auth_code")
    private String authCode;

    @ApiField("requst_app_id")
    private String requstAppId;

    @ApiField("scope")
    private String scope;

    public String getAuthCode() {
        /* 39 */
        return this.authCode;
    }

    public void setAuthCode(String authCode) {
        /* 36 */
        this.authCode = authCode;
    }

    public String getRequstAppId() {
        /* 46 */
        return this.requstAppId;
    }

    public void setRequstAppId(String requstAppId) {
        /* 43 */
        this.requstAppId = requstAppId;
    }

    public String getScope() {
        /* 53 */
        return this.scope;
    }

    public void setScope(String scope) {
        /* 50 */
        this.scope = scope;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOpenAuthIndustryPlatformCreateTokenResponse
 * JD-Core Version:    0.6.0
 */