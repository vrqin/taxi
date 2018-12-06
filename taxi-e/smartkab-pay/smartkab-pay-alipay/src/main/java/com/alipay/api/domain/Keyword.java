package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class Keyword extends AlipayObject {
    private static final long serialVersionUID = 7686834654421893758L;

    @ApiField("color")
    private String color;

    @ApiField("value")
    private String value;

    public String getColor() {
        /* 29 */
        return this.color;
    }

    public void setColor(String color) {
        /* 32 */
        this.color = color;
    }

    public String getValue() {
        /* 36 */
        return this.value;
    }

    public void setValue(String value) {
        /* 39 */
        this.value = value;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.Keyword
 * JD-Core Version:    0.6.0
 */