package com.alipay.api.response;


import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayAccountExrateAdviceAcceptResponse extends AlipayResponse {
    private static final long serialVersionUID = 5163194979851367911L;


    @ApiField("client_id")
    private String clientId;


    @ApiField("contra_amount")
    private String contraAmount;


    @ApiField("contra_ccy")
    private String contraCcy;


    @ApiField("deal_ref")
    private String dealRef;


    @ApiField("dealt_rate")
    private String dealtRate;


    @ApiField("duplicate")
    private Boolean duplicate;


    @ApiField("messag_id")
    private String messagId;


    @ApiField("msg_type")
    private String msgType;


    @ApiField("requested_rate_status")
    private String requestedRateStatus;


    @ApiField("side")
    private String side;


    @ApiField("transaction_amount")
    private String transactionAmount;


    @ApiField("transaction_ccy")
    private String transactionCcy;


    @ApiField("value_date")
    private String valueDate;


    public String getClientId() {
        /* 107 */
        return this.clientId;

    }


    public void setClientId(String clientId) {
        /* 104 */
        this.clientId = clientId;

    }


    public String getContraAmount() {
        /* 114 */
        return this.contraAmount;

    }


    public void setContraAmount(String contraAmount) {
        /* 111 */
        this.contraAmount = contraAmount;

    }


    public String getContraCcy() {
        /* 121 */
        return this.contraCcy;

    }


    public void setContraCcy(String contraCcy) {
        /* 118 */
        this.contraCcy = contraCcy;

    }


    public String getDealRef() {
        /* 128 */
        return this.dealRef;

    }


    public void setDealRef(String dealRef) {
        /* 125 */
        this.dealRef = dealRef;

    }


    public String getDealtRate() {
        /* 135 */
        return this.dealtRate;

    }


    public void setDealtRate(String dealtRate) {
        /* 132 */
        this.dealtRate = dealtRate;

    }


    public Boolean getDuplicate() {
        /* 142 */
        return this.duplicate;

    }


    public void setDuplicate(Boolean duplicate) {
        /* 139 */
        this.duplicate = duplicate;

    }


    public String getMessagId() {
        /* 149 */
        return this.messagId;

    }


    public void setMessagId(String messagId) {
        /* 146 */
        this.messagId = messagId;

    }


    public String getMsgType() {
        /* 156 */
        return this.msgType;

    }


    public void setMsgType(String msgType) {
        /* 153 */
        this.msgType = msgType;

    }


    public String getRequestedRateStatus() {
        /* 163 */
        return this.requestedRateStatus;

    }


    public void setRequestedRateStatus(String requestedRateStatus) {
        /* 160 */
        this.requestedRateStatus = requestedRateStatus;

    }


    public String getSide() {
        /* 170 */
        return this.side;

    }


    public void setSide(String side) {
        /* 167 */
        this.side = side;

    }


    public String getTransactionAmount() {
        /* 177 */
        return this.transactionAmount;

    }


    public void setTransactionAmount(String transactionAmount) {
        /* 174 */
        this.transactionAmount = transactionAmount;

    }


    public String getTransactionCcy() {
        /* 184 */
        return this.transactionCcy;

    }


    public void setTransactionCcy(String transactionCcy) {
        /* 181 */
        this.transactionCcy = transactionCcy;

    }


    public String getValueDate() {
        /* 191 */
        return this.valueDate;

    }


    public void setValueDate(String valueDate) {
        /* 188 */
        this.valueDate = valueDate;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayAccountExrateAdviceAcceptResponse
 * JD-Core Version:    0.6.0
 */