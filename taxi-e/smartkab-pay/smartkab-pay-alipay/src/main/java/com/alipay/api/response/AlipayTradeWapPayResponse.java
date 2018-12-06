package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayTradeWapPayResponse extends AlipayResponse {
    private static final long serialVersionUID = 4312593464711451356L;

    @ApiField("out_trade_no")
    private String outTradeNo;

    @ApiField("seller_id")
    private String sellerId;

    @ApiField("total_amount")
    private String totalAmount;

    @ApiField("trade_no")
    private String tradeNo;

    public String getOutTradeNo() {
        /* 46 */
        return this.outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        /* 43 */
        this.outTradeNo = outTradeNo;
    }

    public String getSellerId() {
        /* 53 */
        return this.sellerId;
    }

    public void setSellerId(String sellerId) {
        /* 50 */
        this.sellerId = sellerId;
    }

    public String getTotalAmount() {
        /* 60 */
        return this.totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        /* 57 */
        this.totalAmount = totalAmount;
    }

    public String getTradeNo() {
        /* 67 */
        return this.tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        /* 64 */
        this.tradeNo = tradeNo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayTradeWapPayResponse
 * JD-Core Version:    0.6.0
 */