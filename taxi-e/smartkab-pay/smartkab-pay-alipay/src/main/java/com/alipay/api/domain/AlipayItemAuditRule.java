package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayItemAuditRule extends AlipayObject {
    private static final long serialVersionUID = 7792119844399782875L;

    @ApiField("audit_type")
    private String auditType;

    @ApiField("need_audit")
    private Boolean needAudit;

    public String getAuditType() {
        /* 29 */
        return this.auditType;
    }

    public void setAuditType(String auditType) {
        /* 32 */
        this.auditType = auditType;
    }

    public Boolean getNeedAudit() {
        /* 36 */
        return this.needAudit;
    }

    public void setNeedAudit(Boolean needAudit) {
        /* 39 */
        this.needAudit = needAudit;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayItemAuditRule
 * JD-Core Version:    0.6.0
 */