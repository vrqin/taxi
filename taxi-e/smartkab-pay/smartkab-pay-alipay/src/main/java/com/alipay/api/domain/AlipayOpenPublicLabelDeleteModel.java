package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenPublicLabelDeleteModel extends AlipayObject {
    private static final long serialVersionUID = 1467558935177334277L;

    @ApiField("id")
    private String id;

    public String getId() {
        /* 23 */
        return this.id;
    }

    public void setId(String id) {
        /* 26 */
        this.id = id;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOpenPublicLabelDeleteModel
 * JD-Core Version:    0.6.0
 */