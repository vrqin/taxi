package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenPublicQrcodeCreateResponse extends AlipayResponse {
    private static final long serialVersionUID = 5187667518595153898L;

    @ApiField("code_img")
    private String codeImg;

    @ApiField("expire_second")
    private String expireSecond;

    public String getCodeImg() {
        /* 33 */
        return this.codeImg;
    }

    public void setCodeImg(String codeImg) {
        /* 30 */
        this.codeImg = codeImg;
    }

    public String getExpireSecond() {
        /* 40 */
        return this.expireSecond;
    }

    public void setExpireSecond(String expireSecond) {
        /* 37 */
        this.expireSecond = expireSecond;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOpenPublicQrcodeCreateResponse
 * JD-Core Version:    0.6.0
 */