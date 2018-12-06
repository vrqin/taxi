package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayEcoMycarMaintainDataUpdateResponse extends AlipayResponse {
    private static final long serialVersionUID = 3341573652552166635L;

    @ApiField("info")
    private String info;

    public String getInfo() {
        /* 27 */
        return this.info;
    }

    public void setInfo(String info) {
        /* 24 */
        this.info = info;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayEcoMycarMaintainDataUpdateResponse
 * JD-Core Version:    0.6.0
 */