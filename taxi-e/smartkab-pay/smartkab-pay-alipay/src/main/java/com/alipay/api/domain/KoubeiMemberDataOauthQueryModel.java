package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiMemberDataOauthQueryModel extends AlipayObject {
    private static final long serialVersionUID = 7337385655328867395L;

    @ApiField("auth_type")
    private String authType;

    @ApiField("code")
    private String code;

    @ApiField("ext_info")
    private String extInfo;

    public String getAuthType() {
        /* 35 */
        return this.authType;
    }

    public void setAuthType(String authType) {
        /* 38 */
        this.authType = authType;
    }

    public String getCode() {
        /* 42 */
        return this.code;
    }

    public void setCode(String code) {
        /* 45 */
        this.code = code;
    }

    public String getExtInfo() {
        /* 49 */
        return this.extInfo;
    }

    public void setExtInfo(String extInfo) {
        /* 52 */
        this.extInfo = extInfo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMemberDataOauthQueryModel
 * JD-Core Version:    0.6.0
 */