package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMobilePublicMessagebatchPushResponse extends AlipayResponse {
    private static final long serialVersionUID = 1267972434872672736L;

    @ApiField("code")
    private String code;

    @ApiField("data")
    private String data;

    @ApiField("msg")
    private String msg;

    public String getCode() {
        /* 39 */
        return this.code;
    }

    public void setCode(String code) {
        /* 36 */
        this.code = code;
    }

    public String getData() {
        /* 46 */
        return this.data;
    }

    public void setData(String data) {
        /* 43 */
        this.data = data;
    }

    public String getMsg() {
        /* 53 */
        return this.msg;
    }

    public void setMsg(String msg) {
        /* 50 */
        this.msg = msg;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMobilePublicMessagebatchPushResponse
 * JD-Core Version:    0.6.0
 */