package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMobileShakeUserQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 4884487878642573255L;

    @ApiField("bizdata")
    private String bizdata;

    @ApiField("logon_id")
    private String logonId;

    @ApiField("pass_id")
    private String passId;

    @ApiField("user_id")
    private String userId;

    public String getBizdata() {
        /* 45 */
        return this.bizdata;
    }

    public void setBizdata(String bizdata) {
        /* 42 */
        this.bizdata = bizdata;
    }

    public String getLogonId() {
        /* 52 */
        return this.logonId;
    }

    public void setLogonId(String logonId) {
        /* 49 */
        this.logonId = logonId;
    }

    public String getPassId() {
        /* 59 */
        return this.passId;
    }

    public void setPassId(String passId) {
        /* 56 */
        this.passId = passId;
    }

    public String getUserId() {
        /* 66 */
        return this.userId;
    }

    public void setUserId(String userId) {
        /* 63 */
        this.userId = userId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMobileShakeUserQueryResponse
 * JD-Core Version:    0.6.0
 */