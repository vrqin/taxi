package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class OpenPromoPrizeRelativeTime extends AlipayObject {
    private static final long serialVersionUID = 7211898679316822263L;

    @ApiField("dimension")
    private String dimension;

    @ApiField("value")
    private String value;

    public String getDimension() {
        /* 34 */
        return this.dimension;
    }

    public void setDimension(String dimension) {
        /* 37 */
        this.dimension = dimension;
    }

    public String getValue() {
        /* 41 */
        return this.value;
    }

    public void setValue(String value) {
        /* 44 */
        this.value = value;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.OpenPromoPrizeRelativeTime
 * JD-Core Version:    0.6.0
 */