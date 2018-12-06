package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipaySocialBaseRelationFriendsGetModel extends AlipayObject {
    private static final long serialVersionUID = 3737763167156784131L;

    @ApiField("get_type")
    private Long getType;

    @ApiField("include_self")
    private Boolean includeSelf;

    public Long getGetType() {
        /* 29 */
        return this.getType;
    }

    public void setGetType(Long getType) {
        /* 32 */
        this.getType = getType;
    }

    public Boolean getIncludeSelf() {
        /* 36 */
        return this.includeSelf;
    }

    public void setIncludeSelf(Boolean includeSelf) {
        /* 39 */
        this.includeSelf = includeSelf;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipaySocialBaseRelationFriendsGetModel
 * JD-Core Version:    0.6.0
 */