package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOfflineSaleleadsContractconfirmModel extends AlipayObject {
    private static final long serialVersionUID = 2815899293445426516L;

    @ApiField("alipay_card_name")
    private String alipayCardName;

    @ApiField("alipay_card_no")
    private String alipayCardNo;

    @ApiField("leads_id")
    private String leadsId;

    @ApiField("ope_pid")
    private String opePid;

    @ApiField("request_id")
    private String requestId;

    @ApiField("sign_status")
    private String signStatus;

    public String getAlipayCardName() {
        /* 53 */
        return this.alipayCardName;
    }

    public void setAlipayCardName(String alipayCardName) {
        /* 56 */
        this.alipayCardName = alipayCardName;
    }

    public String getAlipayCardNo() {
        /* 60 */
        return this.alipayCardNo;
    }

    public void setAlipayCardNo(String alipayCardNo) {
        /* 63 */
        this.alipayCardNo = alipayCardNo;
    }

    public String getLeadsId() {
        /* 67 */
        return this.leadsId;
    }

    public void setLeadsId(String leadsId) {
        /* 70 */
        this.leadsId = leadsId;
    }

    public String getOpePid() {
        /* 74 */
        return this.opePid;
    }

    public void setOpePid(String opePid) {
        /* 77 */
        this.opePid = opePid;
    }

    public String getRequestId() {
        /* 81 */
        return this.requestId;
    }

    public void setRequestId(String requestId) {
        /* 84 */
        this.requestId = requestId;
    }

    public String getSignStatus() {
        /* 88 */
        return this.signStatus;
    }

    public void setSignStatus(String signStatus) {
        /* 91 */
        this.signStatus = signStatus;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOfflineSaleleadsContractconfirmModel
 * JD-Core Version:    0.6.0
 */