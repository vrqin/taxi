package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMobilePublicInfoModifyResponse extends AlipayResponse {
    private static final long serialVersionUID = 6717582949262678167L;

    @ApiField("audit_desc")
    private String auditDesc;

    @ApiField("audit_status")
    private String auditStatus;

    public String getAuditDesc() {
        /* 33 */
        return this.auditDesc;
    }

    public void setAuditDesc(String auditDesc) {
        /* 30 */
        this.auditDesc = auditDesc;
    }

    public String getAuditStatus() {
        /* 40 */
        return this.auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        /* 37 */
        this.auditStatus = auditStatus;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMobilePublicInfoModifyResponse
 * JD-Core Version:    0.6.0
 */