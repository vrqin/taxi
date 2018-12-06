package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class OpenAuthTokenAppModel extends AlipayObject {
    private static final long serialVersionUID = 6846588831192481528L;

    @ApiField("code")
    private String code;

    @ApiField("grant_type")
    private String grantType;

    @ApiField("refresh_token")
    private String refreshToken;

    public String getCode() {
        /* 36 */
        return this.code;
    }

    public void setCode(String code) {
        /* 39 */
        this.code = code;
    }

    public String getGrantType() {
        /* 43 */
        return this.grantType;
    }

    public void setGrantType(String grantType) {
        /* 46 */
        this.grantType = grantType;
    }

    public String getRefreshToken() {
        /* 50 */
        return this.refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        /* 53 */
        this.refreshToken = refreshToken;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.OpenAuthTokenAppModel
 * JD-Core Version:    0.6.0
 */