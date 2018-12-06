package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class OpenPromoPrizeDimension extends AlipayObject {
    private static final long serialVersionUID = 3171611939238577294L;

    @ApiField("dimension")
    private String dimension;

    @ApiListField("values")
    @ApiField("number")
    private List<Long> values;

    public String getDimension() {
        /* 35 */
        return this.dimension;
    }

    public void setDimension(String dimension) {
        /* 38 */
        this.dimension = dimension;
    }

    public List<Long> getValues() {
        /* 42 */
        return this.values;
    }

    public void setValues(List<Long> values) {
        /* 45 */
        this.values = values;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.OpenPromoPrizeDimension
 * JD-Core Version:    0.6.0
 */