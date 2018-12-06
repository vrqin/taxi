package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOfflineSaleleadsQuerybyidsModel extends AlipayObject {
    private static final long serialVersionUID = 4355686237383197873L;

    @ApiField("leads_id")
    private String leadsId;

    @ApiField("ope_pid")
    private String opePid;

    @ApiField("request_id")
    private String requestId;

    public String getLeadsId() {
        /* 35 */
        return this.leadsId;
    }

    public void setLeadsId(String leadsId) {
        /* 38 */
        this.leadsId = leadsId;
    }

    public String getOpePid() {
        /* 42 */
        return this.opePid;
    }

    public void setOpePid(String opePid) {
        /* 45 */
        this.opePid = opePid;
    }

    public String getRequestId() {
        /* 49 */
        return this.requestId;
    }

    public void setRequestId(String requestId) {
        /* 52 */
        this.requestId = requestId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOfflineSaleleadsQuerybyidsModel
 * JD-Core Version:    0.6.0
 */