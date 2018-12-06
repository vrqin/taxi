package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMobilePublicAccountDeleteResponse extends AlipayResponse {
    private static final long serialVersionUID = 8245769294115868738L;

    @ApiField("code")
    private String code;

    @ApiField("msg")
    private String msg;

    public String getCode() {
        /* 33 */
        return this.code;
    }

    public void setCode(String code) {
        /* 30 */
        this.code = code;
    }

    public String getMsg() {
        /* 40 */
        return this.msg;
    }

    public void setMsg(String msg) {
        /* 37 */
        this.msg = msg;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMobilePublicAccountDeleteResponse
 * JD-Core Version:    0.6.0
 */