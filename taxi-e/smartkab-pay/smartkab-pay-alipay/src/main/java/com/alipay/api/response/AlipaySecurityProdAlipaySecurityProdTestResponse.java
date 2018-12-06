package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipaySecurityProdAlipaySecurityProdTestResponse extends AlipayResponse {
    private static final long serialVersionUID = 7472411877156136156L;

    @ApiField("admin")
    private String admin;

    public String getAdmin() {
        /* 27 */
        return this.admin;
    }

    public void setAdmin(String admin) {
        /* 24 */
        this.admin = admin;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipaySecurityProdAlipaySecurityProdTestResponse
 * JD-Core Version:    0.6.0
 */