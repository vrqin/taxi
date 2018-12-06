package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMobilePublicQrcodeCreateResponse extends AlipayResponse {
    private static final long serialVersionUID = 1487464854659748722L;

    @ApiField("code")
    private String code;

    @ApiField("code_img")
    private String codeImg;

    @ApiField("expire_second")
    private Long expireSecond;

    @ApiField("msg")
    private String msg;

    public String getCode() {
        /* 45 */
        return this.code;
    }

    public void setCode(String code) {
        /* 42 */
        this.code = code;
    }

    public String getCodeImg() {
        /* 52 */
        return this.codeImg;
    }

    public void setCodeImg(String codeImg) {
        /* 49 */
        this.codeImg = codeImg;
    }

    public Long getExpireSecond() {
        /* 59 */
        return this.expireSecond;
    }

    public void setExpireSecond(Long expireSecond) {
        /* 56 */
        this.expireSecond = expireSecond;
    }

    public String getMsg() {
        /* 66 */
        return this.msg;
    }

    public void setMsg(String msg) {
        /* 63 */
        this.msg = msg;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMobilePublicQrcodeCreateResponse
 * JD-Core Version:    0.6.0
 */