package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayTradeAppPayModel extends AlipayObject {
    private static final long serialVersionUID = 6799966377833251911L;


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


    public String getBody() {
        /*  59 */
        return this.body;

    }


    public void setBody(String body) {
        /*  62 */
        this.body = body;

    }


    public String getOutTradeNo() {
        /*  66 */
        return this.outTradeNo;

    }


    public void setOutTradeNo(String outTradeNo) {
        /*  69 */
        this.outTradeNo = outTradeNo;

    }


    public String getProductCode() {
        /*  73 */
        return this.productCode;

    }


    public void setProductCode(String productCode) {
        /*  76 */
        this.productCode = productCode;

    }


    public String getSellerId() {
        /*  80 */
        return this.sellerId;

    }


    public void setSellerId(String sellerId) {
        /*  83 */
        this.sellerId = sellerId;

    }


    public String getSubject() {
        /*  87 */
        return this.subject;

    }


    public void setSubject(String subject) {
        /*  90 */
        this.subject = subject;

    }


    public String getTimeoutExpress() {
        /*  94 */
        return this.timeoutExpress;

    }


    public void setTimeoutExpress(String timeoutExpress) {
        /*  97 */
        this.timeoutExpress = timeoutExpress;

    }


    public String getTotalAmount() {
        /* 101 */
        return this.totalAmount;

    }


    public void setTotalAmount(String totalAmount) {
        /* 104 */
        this.totalAmount = totalAmount;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayTradeAppPayModel
 * JD-Core Version:    0.6.0
 */