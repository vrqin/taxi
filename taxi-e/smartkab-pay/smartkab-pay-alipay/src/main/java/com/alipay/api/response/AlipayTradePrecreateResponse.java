package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayTradePrecreateResponse extends AlipayResponse {
    private static final long serialVersionUID = 2298586853115421794L;

    @ApiField("out_trade_no")
    private String outTradeNo;

    @ApiField("qr_code")
    private String qrCode;

    public String getOutTradeNo() {
        /* 33 */
        return this.outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        /* 30 */
        this.outTradeNo = outTradeNo;
    }

    public String getQrCode() {
        /* 40 */
        return this.qrCode;
    }

    public void setQrCode(String qrCode) {
        /* 37 */
        this.qrCode = qrCode;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayTradePrecreateResponse
 * JD-Core Version:    0.6.0
 */