package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayTradeCancelResponse extends AlipayResponse {
    private static final long serialVersionUID = 2312655835199517269L;

    @ApiField("action")
    private String action;

    @ApiField("out_trade_no")
    private String outTradeNo;

    @ApiField("retry_flag")
    private String retryFlag;

    @ApiField("trade_no")
    private String tradeNo;

    public String getAction() {
        /* 47 */
        return this.action;
    }

    public void setAction(String action) {
        /* 44 */
        this.action = action;
    }

    public String getOutTradeNo() {
        /* 54 */
        return this.outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        /* 51 */
        this.outTradeNo = outTradeNo;
    }

    public String getRetryFlag() {
        /* 61 */
        return this.retryFlag;
    }

    public void setRetryFlag(String retryFlag) {
        /* 58 */
        this.retryFlag = retryFlag;
    }

    public String getTradeNo() {
        /* 68 */
        return this.tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        /* 65 */
        this.tradeNo = tradeNo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayTradeCancelResponse
 * JD-Core Version:    0.6.0
 */