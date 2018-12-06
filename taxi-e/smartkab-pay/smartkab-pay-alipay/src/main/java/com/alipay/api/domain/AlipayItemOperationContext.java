package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayItemOperationContext extends AlipayObject {
    private static final long serialVersionUID = 3824958551941337617L;

    @ApiField("creator")
    private String creator;

    @ApiField("op_role")
    private String opRole;

    @ApiField("partner_id")
    private String partnerId;

    public String getCreator() {
        /* 35 */
        return this.creator;
    }

    public void setCreator(String creator) {
        /* 38 */
        this.creator = creator;
    }

    public String getOpRole() {
        /* 42 */
        return this.opRole;
    }

    public void setOpRole(String opRole) {
        /* 45 */
        this.opRole = opRole;
    }

    public String getPartnerId() {
        /* 49 */
        return this.partnerId;
    }

    public void setPartnerId(String partnerId) {
        /* 52 */
        this.partnerId = partnerId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayItemOperationContext
 * JD-Core Version:    0.6.0
 */