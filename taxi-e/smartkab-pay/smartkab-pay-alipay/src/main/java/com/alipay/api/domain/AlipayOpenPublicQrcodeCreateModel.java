package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenPublicQrcodeCreateModel extends AlipayObject {
    private static final long serialVersionUID = 5843291974459441654L;

    @ApiField("code_info")
    private CodeInfo codeInfo;

    @ApiField("code_type")
    private String codeType;

    @ApiField("expire_second")
    private String expireSecond;

    @ApiField("show_logo")
    private String showLogo;

    public CodeInfo getCodeInfo() {
        /* 44 */
        return this.codeInfo;
    }

    public void setCodeInfo(CodeInfo codeInfo) {
        /* 47 */
        this.codeInfo = codeInfo;
    }

    public String getCodeType() {
        /* 51 */
        return this.codeType;
    }

    public void setCodeType(String codeType) {
        /* 54 */
        this.codeType = codeType;
    }

    public String getExpireSecond() {
        /* 58 */
        return this.expireSecond;
    }

    public void setExpireSecond(String expireSecond) {
        /* 61 */
        this.expireSecond = expireSecond;
    }

    public String getShowLogo() {
        /* 65 */
        return this.showLogo;
    }

    public void setShowLogo(String showLogo) {
        /* 68 */
        this.showLogo = showLogo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOpenPublicQrcodeCreateModel
 * JD-Core Version:    0.6.0
 */