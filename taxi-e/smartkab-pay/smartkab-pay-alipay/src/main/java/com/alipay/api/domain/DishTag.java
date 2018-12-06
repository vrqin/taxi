package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class DishTag extends AlipayObject {
    private static final long serialVersionUID = 7817355162331857713L;

    @ApiField("type")
    private String type;

    @ApiField("value")
    private String value;

    public String getType() {
        /* 29 */
        return this.type;
    }

    public void setType(String type) {
        /* 32 */
        this.type = type;
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
 * Qualified Name:     com.alipay.api.domain.DishTag
 * JD-Core Version:    0.6.0
 */