package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class ForbbidenTime extends AlipayObject {
    private static final long serialVersionUID = 7554266267743763292L;

    @ApiField("days")
    private String days;

    public String getDays() {
        /* 25 */
        return this.days;
    }

    public void setDays(String days) {
        /* 28 */
        this.days = days;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.ForbbidenTime
 * JD-Core Version:    0.6.0
 */