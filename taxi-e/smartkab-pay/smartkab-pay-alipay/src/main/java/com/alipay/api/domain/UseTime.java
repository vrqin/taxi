package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class UseTime extends AlipayObject {
    private static final long serialVersionUID = 3442763277162869125L;

    @ApiField("dimension")
    private String dimension;

    @ApiField("times")
    private String times;

    @ApiField("values")
    private String values;

    public String getDimension() {
        /* 40 */
        return this.dimension;
    }

    public void setDimension(String dimension) {
        /* 43 */
        this.dimension = dimension;
    }

    public String getTimes() {
        /* 47 */
        return this.times;
    }

    public void setTimes(String times) {
        /* 50 */
        this.times = times;
    }

    public String getValues() {
        /* 54 */
        return this.values;
    }

    public void setValues(String values) {
        /* 57 */
        this.values = values;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.UseTime
 * JD-Core Version:    0.6.0
 */