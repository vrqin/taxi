package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayTradeFastpayCloseModel extends AlipayObject {
    private static final long serialVersionUID = 2218826453933973756L;

    @ApiField("operator_id")
    private String operatorId;

    @ApiField("out_trade_no")
    private String outTradeNo;

    @ApiField("trade_no")
    private String tradeNo;

    public String getOperatorId() {
        /* 35 */
        return this.operatorId;
    }

    public void setOperatorId(String operatorId) {
        /* 38 */
        this.operatorId = operatorId;
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
 * Qualified Name:     com.alipay.api.domain.AlipayTradeFastpayCloseModel
 * JD-Core Version:    0.6.0
 */