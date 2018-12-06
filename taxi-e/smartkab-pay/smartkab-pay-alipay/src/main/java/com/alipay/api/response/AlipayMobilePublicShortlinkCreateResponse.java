package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMobilePublicShortlinkCreateResponse extends AlipayResponse {
    private static final long serialVersionUID = 3585754846675691763L;

    @ApiField("code")
    private String code;

    @ApiField("msg")
    private String msg;

    @ApiField("shortlink")
    private String shortlink;

    public String getCode() {
        /* 39 */
        return this.code;
    }

    public void setCode(String code) {
        /* 36 */
        this.code = code;
    }

    public String getMsg() {
        /* 46 */
        return this.msg;
    }

    public void setMsg(String msg) {
        /* 43 */
        this.msg = msg;
    }

    public String getShortlink() {
        /* 53 */
        return this.shortlink;
    }

    public void setShortlink(String shortlink) {
        /* 50 */
        this.shortlink = shortlink;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMobilePublicShortlinkCreateResponse
 * JD-Core Version:    0.6.0
 */