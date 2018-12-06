package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class LabelContext extends AlipayObject {
    private static final long serialVersionUID = 3534614611547141854L;

    @ApiField("a")
    private LabelFilter a;

    public LabelFilter getA() {
        /* 23 */
        return this.a;
    }

    public void setA(LabelFilter a) {
        /* 26 */
        this.a = a;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.LabelContext
 * JD-Core Version:    0.6.0
 */