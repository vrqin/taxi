package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayTradeCancelModel extends AlipayObject {
    private static final long serialVersionUID = 6523624911147756882L;

    @ApiField("out_trade_no")
    private String outTradeNo;

    @ApiField("trade_no")
    private String tradeNo;

    public String getOutTradeNo() {
        /* 29 */
        return this.outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        /* 32 */
        this.outTradeNo = outTradeNo;
    }

    public String getTradeNo() {
        /* 36 */
        return this.tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        /* 39 */
        this.tradeNo = tradeNo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayTradeCancelModel
 * JD-Core Version:    0.6.0
 */