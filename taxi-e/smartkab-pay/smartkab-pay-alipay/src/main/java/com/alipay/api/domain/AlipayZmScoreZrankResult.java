package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayZmScoreZrankResult extends AlipayObject {
    private static final long serialVersionUID = 5564218378897299165L;

    @ApiField("zrank")
    private String zrank;

    public String getZrank() {
        /* 23 */
        return this.zrank;
    }

    public void setZrank(String zrank) {
        /* 26 */
        this.zrank = zrank;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayZmScoreZrankResult
 * JD-Core Version:    0.6.0
 */