package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenPublicGisGetModel extends AlipayObject {
    private static final long serialVersionUID = 1371574374326798914L;

    @ApiField("user_id")
    private String userId;

    public String getUserId() {
        /* 23 */
        return this.userId;
    }

    public void setUserId(String userId) {
        /* 26 */
        this.userId = userId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOpenPublicGisGetModel
 * JD-Core Version:    0.6.0
 */