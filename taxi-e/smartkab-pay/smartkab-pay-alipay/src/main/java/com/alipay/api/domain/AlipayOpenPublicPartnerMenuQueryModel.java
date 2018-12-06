package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenPublicPartnerMenuQueryModel extends AlipayObject {
    private static final long serialVersionUID = 2877726524778296242L;

    @ApiField("public_id")
    private String publicId;

    @ApiField("user_id")
    private String userId;

    public String getPublicId() {
        /* 29 */
        return this.publicId;
    }

    public void setPublicId(String publicId) {
        /* 32 */
        this.publicId = publicId;
    }

    public String getUserId() {
        /* 36 */
        return this.userId;
    }

    public void setUserId(String userId) {
        /* 39 */
        this.userId = userId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOpenPublicPartnerMenuQueryModel
 * JD-Core Version:    0.6.0
 */