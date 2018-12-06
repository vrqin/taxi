package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class DelayInfo extends AlipayObject {
    private static final long serialVersionUID = 5292248886825453257L;

    @ApiField("type")
    private String type;

    @ApiField("value")
    private String value;

    public String getType() {
        /* 33 */
        return this.type;
    }

    public void setType(String type) {
        /* 36 */
        this.type = type;
    }

    public String getValue() {
        /* 40 */
        return this.value;
    }

    public void setValue(String value) {
        /* 43 */
        this.value = value;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.DelayInfo
 * JD-Core Version:    0.6.0
 */