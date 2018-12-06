package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayTradeQueryModel extends AlipayObject {
    private static final long serialVersionUID = 2646277134734265863L;

    @ApiField("out_trade_no")
    private String outTradeNo;

    @ApiField("trade_no")
    private String tradeNo;

    public String getOutTradeNo() {
        /* 31 */
        return this.outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        /* 34 */
        this.outTradeNo = outTradeNo;
    }

    public String getTradeNo() {
        /* 38 */
        return this.tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        /* 41 */
        this.tradeNo = tradeNo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayTradeQueryModel
 * JD-Core Version:    0.6.0
 */