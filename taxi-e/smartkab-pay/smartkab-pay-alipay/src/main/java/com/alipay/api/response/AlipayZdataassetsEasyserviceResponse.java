package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayZdataassetsEasyserviceResponse extends AlipayResponse {
    private static final long serialVersionUID = 1795377998149794139L;

    @ApiField("result")
    private String result;

    public String getResult() {
        /* 27 */
        return this.result;
    }

    public void setResult(String result) {
        /* 24 */
        this.result = result;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayZdataassetsEasyserviceResponse
 * JD-Core Version:    0.6.0
 */