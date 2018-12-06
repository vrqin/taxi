package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipaySocialBaseGroupQueryModel extends AlipayObject {
    private static final long serialVersionUID = 7382163427714428944L;

    @ApiField("group_id")
    private String groupId;

    public String getGroupId() {
        /* 23 */
        return this.groupId;
    }

    public void setGroupId(String groupId) {
        /* 26 */
        this.groupId = groupId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipaySocialBaseGroupQueryModel
 * JD-Core Version:    0.6.0
 */