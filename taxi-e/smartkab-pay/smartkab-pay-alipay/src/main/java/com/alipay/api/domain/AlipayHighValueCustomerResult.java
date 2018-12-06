package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayHighValueCustomerResult extends AlipayObject {
    private static final long serialVersionUID = 8394255476972294324L;

    @ApiField("level")
    private String level;

    public String getLevel() {
        /* 23 */
        return this.level;
    }

    public void setLevel(String level) {
        /* 26 */
        this.level = level;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayHighValueCustomerResult
 * JD-Core Version:    0.6.0
 */