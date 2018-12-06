package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOfflineMarketLeadsReleaseModel extends AlipayObject {
    private static final long serialVersionUID = 8647335754569158918L;

    @ApiField("leads_id")
    private String leadsId;

    @ApiField("op_id")
    private String opId;

    @ApiField("operate_notify_url")
    private String operateNotifyUrl;

    @ApiField("release_reason")
    private String releaseReason;

    @ApiField("request_id")
    private String requestId;

    public String getLeadsId() {
        /* 47 */
        return this.leadsId;
    }

    public void setLeadsId(String leadsId) {
        /* 50 */
        this.leadsId = leadsId;
    }

    public String getOpId() {
        /* 54 */
        return this.opId;
    }

    public void setOpId(String opId) {
        /* 57 */
        this.opId = opId;
    }

    public String getOperateNotifyUrl() {
        /* 61 */
        return this.operateNotifyUrl;
    }

    public void setOperateNotifyUrl(String operateNotifyUrl) {
        /* 64 */
        this.operateNotifyUrl = operateNotifyUrl;
    }

    public String getReleaseReason() {
        /* 68 */
        return this.releaseReason;
    }

    public void setReleaseReason(String releaseReason) {
        /* 71 */
        this.releaseReason = releaseReason;
    }

    public String getRequestId() {
        /* 75 */
        return this.requestId;
    }

    public void setRequestId(String requestId) {
        /* 78 */
        this.requestId = requestId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOfflineMarketLeadsReleaseModel
 * JD-Core Version:    0.6.0
 */