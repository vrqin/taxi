package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiMarketingCampaignActivityCreateResponse extends AlipayResponse {
    private static final long serialVersionUID = 7282121952439449369L;

    @ApiField("audit_status")
    private String auditStatus;

    @ApiField("camp_id")
    private String campId;

    @ApiField("camp_status")
    private String campStatus;

    public String getAuditStatus() {
        /* 43 */
        return this.auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        /* 40 */
        this.auditStatus = auditStatus;
    }

    public String getCampId() {
        /* 50 */
        return this.campId;
    }

    public void setCampId(String campId) {
        /* 47 */
        this.campId = campId;
    }

    public String getCampStatus() {
        /* 57 */
        return this.campStatus;
    }

    public void setCampStatus(String campStatus) {
        /* 54 */
        this.campStatus = campStatus;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.KoubeiMarketingCampaignActivityCreateResponse
 * JD-Core Version:    0.6.0
 */