package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenPublicLabelUpdateModel extends AlipayObject {
    private static final long serialVersionUID = 8154997897451295198L;

    @ApiField("id")
    private String id;

    @ApiField("name")
    private String name;

    public String getId() {
        /* 29 */
        return this.id;
    }

    public void setId(String id) {
        /* 32 */
        this.id = id;
    }

    public String getName() {
        /* 36 */
        return this.name;
    }

    public void setName(String name) {
        /* 39 */
        this.name = name;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOpenPublicLabelUpdateModel
 * JD-Core Version:    0.6.0
 */