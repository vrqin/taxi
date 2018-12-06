package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;


public class BankPayApplyResult extends AlipayObject {
    private static final long serialVersionUID = 4136614538628884415L;


    @ApiField("alipay_account_id")
    private String alipayAccountId;


    @ApiField("alipay_account_type")
    private String alipayAccountType;


    @ApiField("alipay_order_no")
    private String alipayOrderNo;


    @ApiField("amount")
    private Long amount;


    @ApiField("apply_time")
    private Date applyTime;


    @ApiField("bank_order_no")
    private String bankOrderNo;


    @ApiField("biz_order_no")
    private String bizOrderNo;


    @ApiField("biz_type")
    private String bizType;


    @ApiField("channel_desc")
    private String channelDesc;


    @ApiField("memo")
    private String memo;


    @ApiField("order_status")
    private String orderStatus;


    @ApiField("payer_card_account_type")
    private String payerCardAccountType;


    @ApiField("payer_card_id")
    private String payerCardId;


    @ApiField("payer_card_id_type")
    private String payerCardIdType;


    @ApiField("payer_card_type")
    private String payerCardType;


    @ApiField("payer_inst_id")
    private String payerInstId;


    @ApiField("success_time")
    private Date successTime;


    public String getAlipayAccountId() {
        /* 133 */
        return this.alipayAccountId;

    }


    public void setAlipayAccountId(String alipayAccountId) {
        /* 136 */
        this.alipayAccountId = alipayAccountId;

    }


    public String getAlipayAccountType() {
        /* 140 */
        return this.alipayAccountType;

    }


    public void setAlipayAccountType(String alipayAccountType) {
        /* 143 */
        this.alipayAccountType = alipayAccountType;

    }


    public String getAlipayOrderNo() {
        /* 147 */
        return this.alipayOrderNo;

    }


    public void setAlipayOrderNo(String alipayOrderNo) {
        /* 150 */
        this.alipayOrderNo = alipayOrderNo;

    }


    public Long getAmount() {
        /* 154 */
        return this.amount;

    }


    public void setAmount(Long amount) {
        /* 157 */
        this.amount = amount;

    }


    public Date getApplyTime() {
        /* 161 */
        return this.applyTime;

    }


    public void setApplyTime(Date applyTime) {
        /* 164 */
        this.applyTime = applyTime;

    }


    public String getBankOrderNo() {
        /* 168 */
        return this.bankOrderNo;

    }


    public void setBankOrderNo(String bankOrderNo) {
        /* 171 */
        this.bankOrderNo = bankOrderNo;

    }


    public String getBizOrderNo() {
        /* 175 */
        return this.bizOrderNo;

    }


    public void setBizOrderNo(String bizOrderNo) {
        /* 178 */
        this.bizOrderNo = bizOrderNo;

    }


    public String getBizType() {
        /* 182 */
        return this.bizType;

    }


    public void setBizType(String bizType) {
        /* 185 */
        this.bizType = bizType;

    }


    public String getChannelDesc() {
        /* 189 */
        return this.channelDesc;

    }


    public void setChannelDesc(String channelDesc) {
        /* 192 */
        this.channelDesc = channelDesc;

    }


    public String getMemo() {
        /* 196 */
        return this.memo;

    }


    public void setMemo(String memo) {
        /* 199 */
        this.memo = memo;

    }


    public String getOrderStatus() {
        /* 203 */
        return this.orderStatus;

    }


    public void setOrderStatus(String orderStatus) {
        /* 206 */
        this.orderStatus = orderStatus;

    }


    public String getPayerCardAccountType() {
        /* 210 */
        return this.payerCardAccountType;

    }


    public void setPayerCardAccountType(String payerCardAccountType) {
        /* 213 */
        this.payerCardAccountType = payerCardAccountType;

    }


    public String getPayerCardId() {
        /* 217 */
        return this.payerCardId;

    }


    public void setPayerCardId(String payerCardId) {
        /* 220 */
        this.payerCardId = payerCardId;

    }


    public String getPayerCardIdType() {
        /* 224 */
        return this.payerCardIdType;

    }


    public void setPayerCardIdType(String payerCardIdType) {
        /* 227 */
        this.payerCardIdType = payerCardIdType;

    }


    public String getPayerCardType() {
        /* 231 */
        return this.payerCardType;

    }


    public void setPayerCardType(String payerCardType) {
        /* 234 */
        this.payerCardType = payerCardType;

    }


    public String getPayerInstId() {
        /* 238 */
        return this.payerInstId;

    }


    public void setPayerInstId(String payerInstId) {
        /* 241 */
        this.payerInstId = payerInstId;

    }


    public Date getSuccessTime() {
        /* 245 */
        return this.successTime;

    }


    public void setSuccessTime(Date successTime) {
        /* 248 */
        this.successTime = successTime;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.BankPayApplyResult
 * JD-Core Version:    0.6.0
 */