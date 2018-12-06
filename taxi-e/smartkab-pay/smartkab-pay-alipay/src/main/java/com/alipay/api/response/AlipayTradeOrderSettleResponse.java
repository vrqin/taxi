package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayTradeOrderSettleResponse extends AlipayResponse {
    private static final long serialVersionUID = 6531541488192219243L;

    @ApiField("trade_no")
    private String tradeNo;

    public String getTradeNo() {
        /* 27 */
        return this.tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        /* 24 */
        this.tradeNo = tradeNo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayTradeOrderSettleResponse
 * JD-Core Version:    0.6.0
 */