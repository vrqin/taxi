package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class OrderDetailResult extends AlipayObject {
    private static final long serialVersionUID = 7386623279486489626L;


    @ApiField("app_id")
    private String appId;


    @ApiField("out_trade_no")
    private String outTradeNo;


    @ApiField("passback_params")
    private String passbackParams;


    @ApiField("seller_id")
    private String sellerId;


    @ApiField("subject")
    private String subject;


    @ApiField("total_amount")
    private String totalAmount;


    @ApiField("trade_no")
    private String tradeNo;


    @ApiField("trade_status")
    private String tradeStatus;


    public String getAppId() {
        /*  69 */
        return this.appId;

    }


    public void setAppId(String appId) {
        /*  72 */
        this.appId = appId;

    }


    public String getOutTradeNo() {
        /*  76 */
        return this.outTradeNo;

    }


    public void setOutTradeNo(String outTradeNo) {
        /*  79 */
        this.outTradeNo = outTradeNo;

    }


    public String getPassbackParams() {
        /*  83 */
        return this.passbackParams;

    }


    public void setPassbackParams(String passbackParams) {
        /*  86 */
        this.passbackParams = passbackParams;

    }


    public String getSellerId() {
        /*  90 */
        return this.sellerId;

    }


    public void setSellerId(String sellerId) {
        /*  93 */
        this.sellerId = sellerId;

    }


    public String getSubject() {
        /*  97 */
        return this.subject;

    }


    public void setSubject(String subject) {
        /* 100 */
        this.subject = subject;

    }


    public String getTotalAmount() {
        /* 104 */
        return this.totalAmount;

    }


    public void setTotalAmount(String totalAmount) {
        /* 107 */
        this.totalAmount = totalAmount;

    }


    public String getTradeNo() {
        /* 111 */
        return this.tradeNo;

    }


    public void setTradeNo(String tradeNo) {
        /* 114 */
        this.tradeNo = tradeNo;

    }


    public String getTradeStatus() {
        /* 118 */
        return this.tradeStatus;

    }


    public void setTradeStatus(String tradeStatus) {
        /* 121 */
        this.tradeStatus = tradeStatus;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.OrderDetailResult
 * JD-Core Version:    0.6.0
 */