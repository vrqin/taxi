package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayEbppAlipayEbppPdeductAsyPayModel extends AlipayObject {
    private static final long serialVersionUID = 5765763491111457948L;


    @ApiField("agent_channel")
    private String agentChannel;


    @ApiField("agent_code")
    private String agentCode;


    @ApiField("agreement_id")
    private String agreementId;


    @ApiField("bill_date")
    private String billDate;


    @ApiField("bill_key")
    private String billKey;


    @ApiField("extend_field")
    private String extendField;


    @ApiField("fine_amount")
    private String fineAmount;


    @ApiField("memo")
    private String memo;


    @ApiField("out_order_no")
    private String outOrderNo;


    @ApiField("pay_amount")
    private String payAmount;


    @ApiField("pid")
    private String pid;


    @ApiField("user_id")
    private String userId;


    public String getAgentChannel() {
        /*  89 */
        return this.agentChannel;

    }


    public void setAgentChannel(String agentChannel) {
        /*  92 */
        this.agentChannel = agentChannel;

    }


    public String getAgentCode() {
        /*  96 */
        return this.agentCode;

    }


    public void setAgentCode(String agentCode) {
        /*  99 */
        this.agentCode = agentCode;

    }


    public String getAgreementId() {
        /* 103 */
        return this.agreementId;

    }


    public void setAgreementId(String agreementId) {
        /* 106 */
        this.agreementId = agreementId;

    }


    public String getBillDate() {
        /* 110 */
        return this.billDate;

    }


    public void setBillDate(String billDate) {
        /* 113 */
        this.billDate = billDate;

    }


    public String getBillKey() {
        /* 117 */
        return this.billKey;

    }


    public void setBillKey(String billKey) {
        /* 120 */
        this.billKey = billKey;

    }


    public String getExtendField() {
        /* 124 */
        return this.extendField;

    }


    public void setExtendField(String extendField) {
        /* 127 */
        this.extendField = extendField;

    }


    public String getFineAmount() {
        /* 131 */
        return this.fineAmount;

    }


    public void setFineAmount(String fineAmount) {
        /* 134 */
        this.fineAmount = fineAmount;

    }


    public String getMemo() {
        /* 138 */
        return this.memo;

    }


    public void setMemo(String memo) {
        /* 141 */
        this.memo = memo;

    }


    public String getOutOrderNo() {
        /* 145 */
        return this.outOrderNo;

    }


    public void setOutOrderNo(String outOrderNo) {
        /* 148 */
        this.outOrderNo = outOrderNo;

    }


    public String getPayAmount() {
        /* 152 */
        return this.payAmount;

    }


    public void setPayAmount(String payAmount) {
        /* 155 */
        this.payAmount = payAmount;

    }


    public String getPid() {
        /* 159 */
        return this.pid;

    }


    public void setPid(String pid) {
        /* 162 */
        this.pid = pid;

    }


    public String getUserId() {
        /* 166 */
        return this.userId;

    }


    public void setUserId(String userId) {
        /* 169 */
        this.userId = userId;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayEbppAlipayEbppPdeductAsyPayModel
 * JD-Core Version:    0.6.0
 */