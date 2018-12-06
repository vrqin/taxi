package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayTradeCreateResponse extends AlipayResponse {
    private static final long serialVersionUID = 6797266847992485733L;

    @ApiField("out_trade_no")
    private String outTradeNo;

    @ApiField("trade_no")
    private String tradeNo;

    public String getOutTradeNo() {
        /* 33 */
        return this.outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        /* 30 */
        this.outTradeNo = outTradeNo;
    }

    public String getTradeNo() {
        /* 40 */
        return this.tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        /* 37 */
        this.tradeNo = tradeNo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayTradeCreateResponse
 * JD-Core Version:    0.6.0
 */