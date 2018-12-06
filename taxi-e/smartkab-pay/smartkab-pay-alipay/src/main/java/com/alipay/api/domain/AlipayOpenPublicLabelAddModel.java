package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenPublicLabelAddModel extends AlipayObject {
    private static final long serialVersionUID = 1643822892949645541L;

    @ApiField("name")
    private String name;

    public String getName() {
        /* 23 */
        return this.name;
    }

    public void setName(String name) {
        /* 26 */
        this.name = name;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOpenPublicLabelAddModel
 * JD-Core Version:    0.6.0
 */