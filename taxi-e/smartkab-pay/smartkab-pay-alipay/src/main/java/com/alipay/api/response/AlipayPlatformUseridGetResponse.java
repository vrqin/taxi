package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayPlatformUseridGetResponse extends AlipayResponse {
    private static final long serialVersionUID = 3838847533972783413L;

    @ApiField("dict")
    private String dict;

    public String getDict() {
        /* 27 */
        return this.dict;
    }

    public void setDict(String dict) {
        /* 24 */
        this.dict = dict;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayPlatformUseridGetResponse
 * JD-Core Version:    0.6.0
 */