package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayTradeFastpayRefundQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 1371619784517921186L;

    @ApiField("out_request_no")
    private String outRequestNo;

    @ApiField("out_trade_no")
    private String outTradeNo;

    @ApiField("refund_amount")
    private String refundAmount;

    @ApiField("refund_reason")
    private String refundReason;

    @ApiField("total_amount")
    private String totalAmount;

    @ApiField("trade_no")
    private String tradeNo;

    public String getOutRequestNo() {
        /* 57 */
        return this.outRequestNo;
    }

    public void setOutRequestNo(String outRequestNo) {
        /* 54 */
        this.outRequestNo = outRequestNo;
    }

    public String getOutTradeNo() {
        /* 64 */
        return this.outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        /* 61 */
        this.outTradeNo = outTradeNo;
    }

    public String getRefundAmount() {
        /* 71 */
        return this.refundAmount;
    }

    public void setRefundAmount(String refundAmount) {
        /* 68 */
        this.refundAmount = refundAmount;
    }

    public String getRefundReason() {
        /* 78 */
        return this.refundReason;
    }

    public void setRefundReason(String refundReason) {
        /* 75 */
        this.refundReason = refundReason;
    }

    public String getTotalAmount() {
        /* 85 */
        return this.totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        /* 82 */
        this.totalAmount = totalAmount;
    }

    public String getTradeNo() {
        /* 92 */
        return this.tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        /* 89 */
        this.tradeNo = tradeNo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayTradeFastpayRefundQueryResponse
 * JD-Core Version:    0.6.0
 */