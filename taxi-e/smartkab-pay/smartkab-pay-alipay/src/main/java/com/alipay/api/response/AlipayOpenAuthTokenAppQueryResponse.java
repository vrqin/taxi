package com.alipay.api.response;


import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.Date;
import java.util.List;


public class AlipayOpenAuthTokenAppQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 8195267238852756225L;


    @ApiField("auth_app_id")
    private String authAppId;


    @ApiField("auth_end")
    private Date authEnd;


    @ApiListField("auth_methods")

    @ApiField("string")
    private List<String> authMethods;


    @ApiField("auth_start")
    private Date authStart;


    @ApiField("expires_in")
    private Long expiresIn;


    @ApiField("status")
    private String status;


    @ApiField("user_id")
    private String userId;


    public String getAuthAppId() {
        /*  67 */
        return this.authAppId;

    }


    public void setAuthAppId(String authAppId) {
        /*  64 */
        this.authAppId = authAppId;

    }


    public Date getAuthEnd() {
        /*  74 */
        return this.authEnd;

    }


    public void setAuthEnd(Date authEnd) {
        /*  71 */
        this.authEnd = authEnd;

    }


    public List<String> getAuthMethods() {
        /*  81 */
        return this.authMethods;

    }


    public void setAuthMethods(List<String> authMethods) {
        /*  78 */
        this.authMethods = authMethods;

    }


    public Date getAuthStart() {
        /*  88 */
        return this.authStart;

    }


    public void setAuthStart(Date authStart) {
        /*  85 */
        this.authStart = authStart;

    }


    public Long getExpiresIn() {
        /*  95 */
        return this.expiresIn;

    }


    public void setExpiresIn(Long expiresIn) {
        /*  92 */
        this.expiresIn = expiresIn;

    }


    public String getStatus() {
        /* 102 */
        return this.status;

    }


    public void setStatus(String status) {
        /*  99 */
        this.status = status;

    }


    public String getUserId() {
        /* 109 */
        return this.userId;

    }


    public void setUserId(String userId) {
        /* 106 */
        this.userId = userId;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOpenAuthTokenAppQueryResponse
 * JD-Core Version:    0.6.0
 */