package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayPlatformOpenidGetResponse extends AlipayResponse {
    private static final long serialVersionUID = 5889524819959658595L;

    @ApiField("code")
    private String code;

    @ApiField("dict")
    private String dict;

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

    public String getDict() {
        /* 46 */
        return this.dict;
    }

    public void setDict(String dict) {
        /* 43 */
        this.dict = dict;
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
 * Qualified Name:     com.alipay.api.response.AlipayPlatformOpenidGetResponse
 * JD-Core Version:    0.6.0
 */