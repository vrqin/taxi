package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AliTrustScore extends AlipayObject {
    private static final long serialVersionUID = 5356566999841733741L;

    @ApiField("score")
    private Long score;

    public Long getScore() {
        /* 23 */
        return this.score;
    }

    public void setScore(Long score) {
        /* 26 */
        this.score = score;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AliTrustScore
 * JD-Core Version:    0.6.0
 */