package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class PeriodInfo extends AlipayObject {
    private static final long serialVersionUID = 4118141122424284715L;

    @ApiField("dimension")
    private String dimension;

    @ApiField("value")
    private Long value;

    public String getDimension() {
        /* 29 */
        return this.dimension;
    }

    public void setDimension(String dimension) {
        /* 32 */
        this.dimension = dimension;
    }

    public Long getValue() {
        /* 36 */
        return this.value;
    }

    public void setValue(Long value) {
        /* 39 */
        this.value = value;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.PeriodInfo
 * JD-Core Version:    0.6.0
 */