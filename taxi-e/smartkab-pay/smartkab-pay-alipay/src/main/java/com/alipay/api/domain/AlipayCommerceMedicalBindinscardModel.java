package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayCommerceMedicalBindinscardModel extends AlipayObject {
    private static final long serialVersionUID = 4583591158431317878L;

    @ApiField("return_url")
    private String returnUrl;

    public String getReturnUrl() {
        /* 23 */
        return this.returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        /* 26 */
        this.returnUrl = returnUrl;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayCommerceMedicalBindinscardModel
 * JD-Core Version:    0.6.0
 */