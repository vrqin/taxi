package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayTradeOrderMobilepayModel extends AlipayObject {
    private static final long serialVersionUID = 7899446236382843542L;


    @ApiField("auth_token")
    private String authToken;


    @ApiField("body")
    private String body;


    @ApiField("out_trade_no")
    private String outTradeNo;


    @ApiField("product_code")
    private String productCode;


    @ApiField("seller_id")
    private String sellerId;


    @ApiField("subject")
    private String subject;


    @ApiField("timeout_express")
    private String timeoutExpress;


    @ApiField("total_amount")
    private String totalAmount;


    public String getAuthToken() {
        /*  65 */
        return this.authToken;

    }


    public void setAuthToken(String authToken) {
        /*  68 */
        this.authToken = authToken;

    }


    public String getBody() {
        /*  72 */
        return this.body;

    }


    public void setBody(String body) {
        /*  75 */
        this.body = body;

    }


    public String getOutTradeNo() {
        /*  79 */
        return this.outTradeNo;

    }


    public void setOutTradeNo(String outTradeNo) {
        /*  82 */
        this.outTradeNo = outTradeNo;

    }


    public String getProductCode() {
        /*  86 */
        return this.productCode;

    }


    public void setProductCode(String productCode) {
        /*  89 */
        this.productCode = productCode;

    }


    public String getSellerId() {
        /*  93 */
        return this.sellerId;

    }


    public void setSellerId(String sellerId) {
        /*  96 */
        this.sellerId = sellerId;

    }


    public String getSubject() {
        /* 100 */
        return this.subject;

    }


    public void setSubject(String subject) {
        /* 103 */
        this.subject = subject;

    }


    public String getTimeoutExpress() {
        /* 107 */
        return this.timeoutExpress;

    }


    public void setTimeoutExpress(String timeoutExpress) {
        /* 110 */
        this.timeoutExpress = timeoutExpress;

    }


    public String getTotalAmount() {
        /* 114 */
        return this.totalAmount;

    }


    public void setTotalAmount(String totalAmount) {
        /* 117 */
        this.totalAmount = totalAmount;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayTradeOrderMobilepayModel
 * JD-Core Version:    0.6.0
 */