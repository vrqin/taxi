package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenAuthAlipayOpenAuthIndustryPlatformCreateTokenModel extends AlipayObject {
    private static final long serialVersionUID = 1341462416125381392L;

    @ApiField("isv_appid")
    private String isvAppid;

    @ApiField("scope")
    private String scope;

    public String getIsvAppid() {
        /* 29 */
        return this.isvAppid;
    }

    public void setIsvAppid(String isvAppid) {
        /* 32 */
        this.isvAppid = isvAppid;
    }

    public String getScope() {
        /* 36 */
        return this.scope;
    }

    public void setScope(String scope) {
        /* 39 */
        this.scope = scope;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOpenAuthAlipayOpenAuthIndustryPlatformCreateTokenModel
 * JD-Core Version:    0.6.0
 */