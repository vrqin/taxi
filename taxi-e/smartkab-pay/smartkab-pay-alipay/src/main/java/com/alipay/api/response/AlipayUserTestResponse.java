package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayUserTestResponse extends AlipayResponse {
    private static final long serialVersionUID = 8234514128413663446L;

    @ApiField("ret1")
    private String ret1;

    public String getRet1() {
        /* 27 */
        return this.ret1;
    }

    public void setRet1(String ret1) {
        /* 24 */
        this.ret1 = ret1;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayUserTestResponse
 * JD-Core Version:    0.6.0
 */