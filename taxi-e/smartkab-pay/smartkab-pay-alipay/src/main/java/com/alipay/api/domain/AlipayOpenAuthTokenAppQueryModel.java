package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenAuthTokenAppQueryModel extends AlipayObject {
    private static final long serialVersionUID = 8273139941958619726L;

    @ApiField("app_auth_token")
    private String appAuthToken;

    public String getAppAuthToken() {
        /* 23 */
        return this.appAuthToken;
    }

    public void setAppAuthToken(String appAuthToken) {
        /* 26 */
        this.appAuthToken = appAuthToken;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOpenAuthTokenAppQueryModel
 * JD-Core Version:    0.6.0
 */