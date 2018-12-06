package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;


public class MicroPayOrderDetail extends AlipayObject {
    private static final long serialVersionUID = 7311427634757265398L;


    @ApiField("alipay_order_no")
    private String alipayOrderNo;


    @ApiField("alipay_user_id")
    private String alipayUserId;


    @ApiField("available_amount")
    private String availableAmount;


    @ApiField("create_time")
    private Date createTime;


    @ApiField("expire_time")
    private Date expireTime;


    @ApiField("freeze_amount")
    private String freezeAmount;


    @ApiField("memo")
    private String memo;


    @ApiField("merchant_order_no")
    private String merchantOrderNo;


    @ApiField("modified_time")
    private Date modifiedTime;


    @ApiField("order_status")
    private String orderStatus;


    @ApiField("pay_amount")
    private String payAmount;


    @ApiField("pay_confirm")
    private String payConfirm;


    public String getAlipayOrderNo() {
        /*  91 */
        return this.alipayOrderNo;

    }


    public void setAlipayOrderNo(String alipayOrderNo) {
        /*  94 */
        this.alipayOrderNo = alipayOrderNo;

    }


    public String getAlipayUserId() {
        /*  98 */
        return this.alipayUserId;

    }


    public void setAlipayUserId(String alipayUserId) {
        /* 101 */
        this.alipayUserId = alipayUserId;

    }


    public String getAvailableAmount() {
        /* 105 */
        return this.availableAmount;

    }


    public void setAvailableAmount(String availableAmount) {
        /* 108 */
        this.availableAmount = availableAmount;

    }


    public Date getCreateTime() {
        /* 112 */
        return this.createTime;

    }


    public void setCreateTime(Date createTime) {
        /* 115 */
        this.createTime = createTime;

    }


    public Date getExpireTime() {
        /* 119 */
        return this.expireTime;

    }


    public void setExpireTime(Date expireTime) {
        /* 122 */
        this.expireTime = expireTime;

    }


    public String getFreezeAmount() {
        /* 126 */
        return this.freezeAmount;

    }


    public void setFreezeAmount(String freezeAmount) {
        /* 129 */
        this.freezeAmount = freezeAmount;

    }


    public String getMemo() {
        /* 133 */
        return this.memo;

    }


    public void setMemo(String memo) {
        /* 136 */
        this.memo = memo;

    }


    public String getMerchantOrderNo() {
        /* 140 */
        return this.merchantOrderNo;

    }


    public void setMerchantOrderNo(String merchantOrderNo) {
        /* 143 */
        this.merchantOrderNo = merchantOrderNo;

    }


    public Date getModifiedTime() {
        /* 147 */
        return this.modifiedTime;

    }


    public void setModifiedTime(Date modifiedTime) {
        /* 150 */
        this.modifiedTime = modifiedTime;

    }


    public String getOrderStatus() {
        /* 154 */
        return this.orderStatus;

    }


    public void setOrderStatus(String orderStatus) {
        /* 157 */
        this.orderStatus = orderStatus;

    }


    public String getPayAmount() {
        /* 161 */
        return this.payAmount;

    }


    public void setPayAmount(String payAmount) {
        /* 164 */
        this.payAmount = payAmount;

    }


    public String getPayConfirm() {
        /* 168 */
        return this.payConfirm;

    }


    public void setPayConfirm(String payConfirm) {
        /* 171 */
        this.payConfirm = payConfirm;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.MicroPayOrderDetail
 * JD-Core Version:    0.6.0
 */