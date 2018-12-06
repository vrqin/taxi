package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class DishonorOrder extends AlipayObject {
    private static final long serialVersionUID = 4247481847255868821L;


    @ApiField("amount")
    private String amount;


    @ApiField("dishonor_date")
    private String dishonorDate;


    @ApiField("fail_reason")
    private String failReason;


    @ApiField("order_id")
    private String orderId;


    @ApiField("out_biz_no")
    private String outBizNo;


    @ApiField("pay_date")
    private String payDate;


    @ApiField("payer_account")
    private String payerAccount;


    @ApiField("payment_no")
    private String paymentNo;


    public String getAmount() {
        /*  66 */
        return this.amount;

    }


    public void setAmount(String amount) {
        /*  69 */
        this.amount = amount;

    }


    public String getDishonorDate() {
        /*  73 */
        return this.dishonorDate;

    }


    public void setDishonorDate(String dishonorDate) {
        /*  76 */
        this.dishonorDate = dishonorDate;

    }


    public String getFailReason() {
        /*  80 */
        return this.failReason;

    }


    public void setFailReason(String failReason) {
        /*  83 */
        this.failReason = failReason;

    }


    public String getOrderId() {
        /*  87 */
        return this.orderId;

    }


    public void setOrderId(String orderId) {
        /*  90 */
        this.orderId = orderId;

    }


    public String getOutBizNo() {
        /*  94 */
        return this.outBizNo;

    }


    public void setOutBizNo(String outBizNo) {
        /*  97 */
        this.outBizNo = outBizNo;

    }


    public String getPayDate() {
        /* 101 */
        return this.payDate;

    }


    public void setPayDate(String payDate) {
        /* 104 */
        this.payDate = payDate;

    }


    public String getPayerAccount() {
        /* 108 */
        return this.payerAccount;

    }


    public void setPayerAccount(String payerAccount) {
        /* 111 */
        this.payerAccount = payerAccount;

    }


    public String getPaymentNo() {
        /* 115 */
        return this.paymentNo;

    }


    public void setPaymentNo(String paymentNo) {
        /* 118 */
        this.paymentNo = paymentNo;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.DishonorOrder
 * JD-Core Version:    0.6.0
 */