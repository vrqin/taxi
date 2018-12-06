package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayAccountExrateAdviceAcceptModel extends AlipayObject {
    private static final long serialVersionUID = 6246328776878824643L;

    @ApiField("advice")
    private AdviceVO advice;

    public AdviceVO getAdvice() {
        /* 23 */
        return this.advice;
    }

    public void setAdvice(AdviceVO advice) {
        /* 26 */
        this.advice = advice;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayAccountExrateAdviceAcceptModel
 * JD-Core Version:    0.6.0
 */