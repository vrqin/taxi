package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenPublicThirdCustomerServiceResponse extends AlipayResponse {
    private static final long serialVersionUID = 1313832337772237312L;

    @ApiField("public_name")
    private String publicName;

    public String getPublicName() {
        /* 27 */
        return this.publicName;
    }

    public void setPublicName(String publicName) {
        /* 24 */
        this.publicName = publicName;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOpenPublicThirdCustomerServiceResponse
 * JD-Core Version:    0.6.0
 */