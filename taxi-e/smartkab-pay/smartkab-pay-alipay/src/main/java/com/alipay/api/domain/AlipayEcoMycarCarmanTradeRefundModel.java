package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayEcoMycarCarmanTradeRefundModel extends AlipayObject {
    private static final long serialVersionUID = 7753813655128356622L;

    @ApiField("isv")
    private String isv;

    @ApiField("refund_fee")
    private String refundFee;

    @ApiField("refund_reason")
    private String refundReason;

    @ApiField("trade_no")
    private String tradeNo;

    public String getIsv() {
        /* 41 */
        return this.isv;
    }

    public void setIsv(String isv) {
        /* 44 */
        this.isv = isv;
    }

    public String getRefundFee() {
        /* 48 */
        return this.refundFee;
    }

    public void setRefundFee(String refundFee) {
        /* 51 */
        this.refundFee = refundFee;
    }

    public String getRefundReason() {
        /* 55 */
        return this.refundReason;
    }

    public void setRefundReason(String refundReason) {
        /* 58 */
        this.refundReason = refundReason;
    }

    public String getTradeNo() {
        /* 62 */
        return this.tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        /* 65 */
        this.tradeNo = tradeNo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayEcoMycarCarmanTradeRefundModel
 * JD-Core Version:    0.6.0
 */