package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayTradeRefundModel extends AlipayObject {
    private static final long serialVersionUID = 2575848594919343855L;


    @ApiField("operator_id")
    private String operatorId;


    @ApiField("out_request_no")
    private String outRequestNo;


    @ApiField("out_trade_no")
    private String outTradeNo;


    @ApiField("refund_amount")
    private String refundAmount;


    @ApiField("refund_reason")
    private String refundReason;


    @ApiField("store_id")
    private String storeId;


    @ApiField("terminal_id")
    private String terminalId;


    @ApiField("trade_no")
    private String tradeNo;


    public String getOperatorId() {
        /*  65 */
        return this.operatorId;

    }


    public void setOperatorId(String operatorId) {
        /*  68 */
        this.operatorId = operatorId;

    }


    public String getOutRequestNo() {
        /*  72 */
        return this.outRequestNo;

    }


    public void setOutRequestNo(String outRequestNo) {
        /*  75 */
        this.outRequestNo = outRequestNo;

    }


    public String getOutTradeNo() {
        /*  79 */
        return this.outTradeNo;

    }


    public void setOutTradeNo(String outTradeNo) {
        /*  82 */
        this.outTradeNo = outTradeNo;

    }


    public String getRefundAmount() {
        /*  86 */
        return this.refundAmount;

    }


    public void setRefundAmount(String refundAmount) {
        /*  89 */
        this.refundAmount = refundAmount;

    }


    public String getRefundReason() {
        /*  93 */
        return this.refundReason;

    }


    public void setRefundReason(String refundReason) {
        /*  96 */
        this.refundReason = refundReason;

    }


    public String getStoreId() {
        /* 100 */
        return this.storeId;

    }


    public void setStoreId(String storeId) {
        /* 103 */
        this.storeId = storeId;

    }


    public String getTerminalId() {
        /* 107 */
        return this.terminalId;

    }


    public void setTerminalId(String terminalId) {
        /* 110 */
        this.terminalId = terminalId;

    }


    public String getTradeNo() {
        /* 114 */
        return this.tradeNo;

    }


    public void setTradeNo(String tradeNo) {
        /* 117 */
        this.tradeNo = tradeNo;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayTradeRefundModel
 * JD-Core Version:    0.6.0
 */