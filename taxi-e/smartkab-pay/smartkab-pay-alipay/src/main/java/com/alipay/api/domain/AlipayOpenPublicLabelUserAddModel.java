package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenPublicLabelUserAddModel extends AlipayObject {
    private static final long serialVersionUID = 6293882716547262746L;

    @ApiField("label_id")
    private Long labelId;

    @ApiField("user_id")
    private String userId;

    public Long getLabelId() {
        /* 29 */
        return this.labelId;
    }

    public void setLabelId(Long labelId) {
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
 * Qualified Name:     com.alipay.api.domain.AlipayOpenPublicLabelUserAddModel
 * JD-Core Version:    0.6.0
 */