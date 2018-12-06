package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayUserFinanceinfoShareModel extends AlipayObject {
    private static final long serialVersionUID = 4575559392136439512L;

    @ApiField("user_id")
    private String userId;

    public String getUserId() {
        /* 24 */
        return this.userId;
    }

    public void setUserId(String userId) {
        /* 27 */
        this.userId = userId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayUserFinanceinfoShareModel
 * JD-Core Version:    0.6.0
 */