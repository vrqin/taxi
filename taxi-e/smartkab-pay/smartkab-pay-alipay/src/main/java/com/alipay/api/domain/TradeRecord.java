package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;


public class TradeRecord extends AlipayObject {
    private static final long serialVersionUID = 5243564334166846764L;


    @ApiField("alipay_order_no")
    private String alipayOrderNo;


    @ApiField("create_time")
    private Date createTime;


    @ApiField("in_out_type")
    private String inOutType;


    @ApiField("merchant_order_no")
    private String merchantOrderNo;


    @ApiField("modified_time")
    private Date modifiedTime;


    @ApiField("opposite_logon_id")
    private String oppositeLogonId;


    @ApiField("opposite_name")
    private String oppositeName;


    @ApiField("opposite_user_id")
    private String oppositeUserId;


    @ApiField("order_from")
    private String orderFrom;


    @ApiField("order_status")
    private String orderStatus;


    @ApiField("order_title")
    private String orderTitle;


    @ApiField("order_type")
    private String orderType;


    @ApiField("owner_logon_id")
    private String ownerLogonId;


    @ApiField("owner_name")
    private String ownerName;


    @ApiField("owner_user_id")
    private String ownerUserId;


    @ApiField("partner_id")
    private String partnerId;


    @ApiField("service_charge")
    private String serviceCharge;


    @ApiField("total_amount")
    private String totalAmount;


    public String getAlipayOrderNo() {
        /* 127 */
        return this.alipayOrderNo;

    }


    public void setAlipayOrderNo(String alipayOrderNo) {
        /* 130 */
        this.alipayOrderNo = alipayOrderNo;

    }


    public Date getCreateTime() {
        /* 134 */
        return this.createTime;

    }


    public void setCreateTime(Date createTime) {
        /* 137 */
        this.createTime = createTime;

    }


    public String getInOutType() {
        /* 141 */
        return this.inOutType;

    }


    public void setInOutType(String inOutType) {
        /* 144 */
        this.inOutType = inOutType;

    }


    public String getMerchantOrderNo() {
        /* 148 */
        return this.merchantOrderNo;

    }


    public void setMerchantOrderNo(String merchantOrderNo) {
        /* 151 */
        this.merchantOrderNo = merchantOrderNo;

    }


    public Date getModifiedTime() {
        /* 155 */
        return this.modifiedTime;

    }


    public void setModifiedTime(Date modifiedTime) {
        /* 158 */
        this.modifiedTime = modifiedTime;

    }


    public String getOppositeLogonId() {
        /* 162 */
        return this.oppositeLogonId;

    }


    public void setOppositeLogonId(String oppositeLogonId) {
        /* 165 */
        this.oppositeLogonId = oppositeLogonId;

    }


    public String getOppositeName() {
        /* 169 */
        return this.oppositeName;

    }


    public void setOppositeName(String oppositeName) {
        /* 172 */
        this.oppositeName = oppositeName;

    }


    public String getOppositeUserId() {
        /* 176 */
        return this.oppositeUserId;

    }


    public void setOppositeUserId(String oppositeUserId) {
        /* 179 */
        this.oppositeUserId = oppositeUserId;

    }


    public String getOrderFrom() {
        /* 183 */
        return this.orderFrom;

    }


    public void setOrderFrom(String orderFrom) {
        /* 186 */
        this.orderFrom = orderFrom;

    }


    public String getOrderStatus() {
        /* 190 */
        return this.orderStatus;

    }


    public void setOrderStatus(String orderStatus) {
        /* 193 */
        this.orderStatus = orderStatus;

    }


    public String getOrderTitle() {
        /* 197 */
        return this.orderTitle;

    }


    public void setOrderTitle(String orderTitle) {
        /* 200 */
        this.orderTitle = orderTitle;

    }


    public String getOrderType() {
        /* 204 */
        return this.orderType;

    }


    public void setOrderType(String orderType) {
        /* 207 */
        this.orderType = orderType;

    }


    public String getOwnerLogonId() {
        /* 211 */
        return this.ownerLogonId;

    }


    public void setOwnerLogonId(String ownerLogonId) {
        /* 214 */
        this.ownerLogonId = ownerLogonId;

    }


    public String getOwnerName() {
        /* 218 */
        return this.ownerName;

    }


    public void setOwnerName(String ownerName) {
        /* 221 */
        this.ownerName = ownerName;

    }


    public String getOwnerUserId() {
        /* 225 */
        return this.ownerUserId;

    }


    public void setOwnerUserId(String ownerUserId) {
        /* 228 */
        this.ownerUserId = ownerUserId;

    }


    public String getPartnerId() {
        /* 232 */
        return this.partnerId;

    }


    public void setPartnerId(String partnerId) {
        /* 235 */
        this.partnerId = partnerId;

    }


    public String getServiceCharge() {
        /* 239 */
        return this.serviceCharge;

    }


    public void setServiceCharge(String serviceCharge) {
        /* 242 */
        this.serviceCharge = serviceCharge;

    }


    public String getTotalAmount() {
        /* 246 */
        return this.totalAmount;

    }


    public void setTotalAmount(String totalAmount) {
        /* 249 */
        this.totalAmount = totalAmount;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.TradeRecord
 * JD-Core Version:    0.6.0
 */