package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;

public class AlipayOpenPublicLifeAccountCreateResponse extends AlipayResponse {
    private static final long serialVersionUID = 8846647121937151431L;

    @ApiField("expire_time")
    private Date expireTime;

    @ApiField("public_id")
    private String publicId;

    @ApiField("refresh_token")
    private String refreshToken;

    @ApiField("token")
    private String token;

    public Date getExpireTime() {
        /* 46 */
        return this.expireTime;
    }

    public void setExpireTime(Date expireTime) {
        /* 43 */
        this.expireTime = expireTime;
    }

    public String getPublicId() {
        /* 53 */
        return this.publicId;
    }

    public void setPublicId(String publicId) {
        /* 50 */
        this.publicId = publicId;
    }

    public String getRefreshToken() {
        /* 60 */
        return this.refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        /* 57 */
        this.refreshToken = refreshToken;
    }

    public String getToken() {
        /* 67 */
        return this.token;
    }

    public void setToken(String token) {
        /* 64 */
        this.token = token;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOpenPublicLifeAccountCreateResponse
 * JD-Core Version:    0.6.0
 */