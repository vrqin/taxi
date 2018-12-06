package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipaySiteprobeShopPublicBindResponse extends AlipayResponse {
    private static final long serialVersionUID = 8475838278736128997L;

    @ApiField("code")
    private String code;

    @ApiField("msg")
    private String msg;

    @ApiField("public_logo")
    private String publicLogo;

    @ApiField("public_name")
    private String publicName;

    public String getCode() {
        /* 45 */
        return this.code;
    }

    public void setCode(String code) {
        /* 42 */
        this.code = code;
    }

    public String getMsg() {
        /* 52 */
        return this.msg;
    }

    public void setMsg(String msg) {
        /* 49 */
        this.msg = msg;
    }

    public String getPublicLogo() {
        /* 59 */
        return this.publicLogo;
    }

    public void setPublicLogo(String publicLogo) {
        /* 56 */
        this.publicLogo = publicLogo;
    }

    public String getPublicName() {
        /* 66 */
        return this.publicName;
    }

    public void setPublicName(String publicName) {
        /* 63 */
        this.publicName = publicName;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipaySiteprobeShopPublicBindResponse
 * JD-Core Version:    0.6.0
 */