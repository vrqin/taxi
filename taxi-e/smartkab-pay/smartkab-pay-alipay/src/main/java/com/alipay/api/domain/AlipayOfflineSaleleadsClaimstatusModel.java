package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOfflineSaleleadsClaimstatusModel extends AlipayObject {
    private static final long serialVersionUID = 7856556125662862356L;

    @ApiField("leads_id")
    private String leadsId;

    @ApiField("ope_pid")
    private String opePid;

    @ApiField("ope_pid_orig")
    private String opePidOrig;

    @ApiField("oper_type")
    private String operType;

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

    public String getOpePid() {
        /* 54 */
        return this.opePid;
    }

    public void setOpePid(String opePid) {
        /* 57 */
        this.opePid = opePid;
    }

    public String getOpePidOrig() {
        /* 61 */
        return this.opePidOrig;
    }

    public void setOpePidOrig(String opePidOrig) {
        /* 64 */
        this.opePidOrig = opePidOrig;
    }

    public String getOperType() {
        /* 68 */
        return this.operType;
    }

    public void setOperType(String operType) {
        /* 71 */
        this.operType = operType;
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
 * Qualified Name:     com.alipay.api.domain.AlipayOfflineSaleleadsClaimstatusModel
 * JD-Core Version:    0.6.0
 */