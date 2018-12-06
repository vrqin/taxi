package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOfflineMarketLeadsClaimModel extends AlipayObject {
    private static final long serialVersionUID = 7814958676829786963L;

    @ApiField("leads_id")
    private String leadsId;

    @ApiField("op_id")
    private String opId;

    @ApiField("operate_notify_url")
    private String operateNotifyUrl;

    @ApiField("request_id")
    private String requestId;

    public String getLeadsId() {
        /* 41 */
        return this.leadsId;
    }

    public void setLeadsId(String leadsId) {
        /* 44 */
        this.leadsId = leadsId;
    }

    public String getOpId() {
        /* 48 */
        return this.opId;
    }

    public void setOpId(String opId) {
        /* 51 */
        this.opId = opId;
    }

    public String getOperateNotifyUrl() {
        /* 55 */
        return this.operateNotifyUrl;
    }

    public void setOperateNotifyUrl(String operateNotifyUrl) {
        /* 58 */
        this.operateNotifyUrl = operateNotifyUrl;
    }

    public String getRequestId() {
        /* 62 */
        return this.requestId;
    }

    public void setRequestId(String requestId) {
        /* 65 */
        this.requestId = requestId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOfflineMarketLeadsClaimModel
 * JD-Core Version:    0.6.0
 */