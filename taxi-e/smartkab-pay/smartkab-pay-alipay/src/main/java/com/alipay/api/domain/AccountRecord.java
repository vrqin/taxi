package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;


public class AccountRecord extends AlipayObject {
    private static final long serialVersionUID = 8523947247633441714L;


    @ApiField("alipay_order_no")
    private String alipayOrderNo;


    @ApiField("balance")
    private String balance;


    @ApiField("business_type")
    private String businessType;


    @ApiField("create_time")
    private Date createTime;


    @ApiField("in_amount")
    private String inAmount;


    @ApiField("memo")
    private String memo;


    @ApiField("merchant_order_no")
    private String merchantOrderNo;


    @ApiField("opt_user_id")
    private String optUserId;


    @ApiField("out_amount")
    private String outAmount;


    @ApiField("self_user_id")
    private String selfUserId;


    @ApiField("type")
    private String type;


    public String getAlipayOrderNo() {
        /*  85 */
        return this.alipayOrderNo;

    }


    public void setAlipayOrderNo(String alipayOrderNo) {
        /*  88 */
        this.alipayOrderNo = alipayOrderNo;

    }


    public String getBalance() {
        /*  92 */
        return this.balance;

    }


    public void setBalance(String balance) {
        /*  95 */
        this.balance = balance;

    }


    public String getBusinessType() {
        /*  99 */
        return this.businessType;

    }


    public void setBusinessType(String businessType) {
        /* 102 */
        this.businessType = businessType;

    }


    public Date getCreateTime() {
        /* 106 */
        return this.createTime;

    }


    public void setCreateTime(Date createTime) {
        /* 109 */
        this.createTime = createTime;

    }


    public String getInAmount() {
        /* 113 */
        return this.inAmount;

    }


    public void setInAmount(String inAmount) {
        /* 116 */
        this.inAmount = inAmount;

    }


    public String getMemo() {
        /* 120 */
        return this.memo;

    }


    public void setMemo(String memo) {
        /* 123 */
        this.memo = memo;

    }


    public String getMerchantOrderNo() {
        /* 127 */
        return this.merchantOrderNo;

    }


    public void setMerchantOrderNo(String merchantOrderNo) {
        /* 130 */
        this.merchantOrderNo = merchantOrderNo;

    }


    public String getOptUserId() {
        /* 134 */
        return this.optUserId;

    }


    public void setOptUserId(String optUserId) {
        /* 137 */
        this.optUserId = optUserId;

    }


    public String getOutAmount() {
        /* 141 */
        return this.outAmount;

    }


    public void setOutAmount(String outAmount) {
        /* 144 */
        this.outAmount = outAmount;

    }


    public String getSelfUserId() {
        /* 148 */
        return this.selfUserId;

    }


    public void setSelfUserId(String selfUserId) {
        /* 151 */
        this.selfUserId = selfUserId;

    }


    public String getType() {
        /* 155 */
        return this.type;

    }


    public void setType(String type) {
        /* 158 */
        this.type = type;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AccountRecord
 * JD-Core Version:    0.6.0
 */