package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenPublicShortlinkCreateResponse extends AlipayResponse {
    private static final long serialVersionUID = 3782927555836625684L;

    @ApiField("shortlink")
    private String shortlink;

    public String getShortlink() {
        /* 27 */
        return this.shortlink;
    }

    public void setShortlink(String shortlink) {
        /* 24 */
        this.shortlink = shortlink;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOpenPublicShortlinkCreateResponse
 * JD-Core Version:    0.6.0
 */