package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayDataDataserviceCustomerLevelGetModel extends AlipayObject {
    private static final long serialVersionUID = 2322874926283759427L;

    @ApiField("id")
    private String id;

    @ApiField("type")
    private String type;

    public String getId() {
        /* 29 */
        return this.id;
    }

    public void setId(String id) {
        /* 32 */
        this.id = id;
    }

    public String getType() {
        /* 36 */
        return this.type;
    }

    public void setType(String type) {
        /* 39 */
        this.type = type;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayDataDataserviceCustomerLevelGetModel
 * JD-Core Version:    0.6.0
 */