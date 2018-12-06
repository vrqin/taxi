package com.alipay.api;

import com.alipay.api.internal.mapping.ApiField;

public class AlipayMobilePublicMultiMediaDownloadResponse extends AlipayResponse {
    private static final long serialVersionUID = 4500718209713594926L;

    @ApiField("code")
    private String code;

    @ApiField("msg")
    private String msg;

    public String getCode() {
        /* 30 */
        return this.code;
    }

    public void setCode(String code) {
        /* 26 */
        this.code = code;
    }

    public String getMsg() {
        /* 40 */
        return this.msg;
    }

    public void setMsg(String msg) {
        /* 35 */
        this.msg = msg;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.AlipayMobilePublicMultiMediaDownloadResponse
 * JD-Core Version:    0.6.0
 */