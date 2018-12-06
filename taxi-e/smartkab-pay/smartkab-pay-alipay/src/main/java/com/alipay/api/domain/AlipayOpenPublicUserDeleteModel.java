package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenPublicUserDeleteModel extends AlipayObject {
    private static final long serialVersionUID = 4655934433697656995L;

    @ApiField("label_id")
    private String labelId;

    @ApiField("user_id")
    private String userId;

    public String getLabelId() {
        /* 29 */
        return this.labelId;
    }

    public void setLabelId(String labelId) {
        /* 32 */
        this.labelId = labelId;
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
 * Qualified Name:     com.alipay.api.domain.AlipayOpenPublicUserDeleteModel
 * JD-Core Version:    0.6.0
 */