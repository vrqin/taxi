package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayTradeFastpayRefundQueryModel extends AlipayObject {
    private static final long serialVersionUID = 8514296959191259655L;

    @ApiField("out_request_no")
    private String outRequestNo;

    @ApiField("out_trade_no")
    private String outTradeNo;

    @ApiField("trade_no")
    private String tradeNo;

    public String getOutRequestNo() {
        /* 35 */
        return this.outRequestNo;
    }

    public void setOutRequestNo(String outRequestNo) {
        /* 38 */
        this.outRequestNo = outRequestNo;
    }

    public String getOutTradeNo() {
        /* 42 */
        return this.outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        /* 45 */
        this.outTradeNo = outTradeNo;
    }

    public String getTradeNo() {
        /* 49 */
        return this.tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        /* 52 */
        this.tradeNo = tradeNo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayTradeFastpayRefundQueryModel
 * JD-Core Version:    0.6.0
 */