package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiMarketingCampaignActivityOfflineResponse extends AlipayResponse {
    private static final long serialVersionUID = 7273874782312486655L;

    @ApiField("audit_status")
    private String auditStatus;

    @ApiField("camp_status")
    private String campStatus;

    public String getAuditStatus() {
        /* 33 */
        return this.auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        /* 30 */
        this.auditStatus = auditStatus;
    }

    public String getCampStatus() {
        /* 40 */
        return this.campStatus;
    }

    public void setCampStatus(String campStatus) {
        /* 37 */
        this.campStatus = campStatus;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.KoubeiMarketingCampaignActivityOfflineResponse
 * JD-Core Version:    0.6.0
 */