package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiMemberDataCategoryQueryModel extends AlipayObject {
    private static final long serialVersionUID = 8535287645964247622L;

    @ApiField("parent_id")
    private String parentId;

    public String getParentId() {
        /* 23 */
        return this.parentId;
    }

    public void setParentId(String parentId) {
        /* 26 */
        this.parentId = parentId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMemberDataCategoryQueryModel
 * JD-Core Version:    0.6.0
 */