package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenPublicFollowListModel extends AlipayObject {
    private static final long serialVersionUID = 8892494483359271115L;

    @ApiField("next_user_id")
    private String nextUserId;

    public String getNextUserId() {
        /* 23 */
        return this.nextUserId;
    }

    public void setNextUserId(String nextUserId) {
        /* 26 */
        this.nextUserId = nextUserId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOpenPublicFollowListModel
 * JD-Core Version:    0.6.0
 */