package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class Coupon extends AlipayObject {
    private static final long serialVersionUID = 2547155124438239653L;


    @ApiField("available_amount")
    private String availableAmount;


    @ApiField("coupon_no")
    private String couponNo;


    @ApiField("deduct_amount")
    private String deductAmount;


    @ApiField("gmt_active")
    private String gmtActive;


    @ApiField("gmt_create")
    private String gmtCreate;


    @ApiField("gmt_expired")
    private String gmtExpired;


    @ApiField("instructions")
    private String instructions;


    @ApiField("memo")
    private String memo;


    @ApiField("merchant_uniq_id")
    private String merchantUniqId;


    @ApiField("multi_use_flag")
    private String multiUseFlag;


    @ApiField("name")
    private String name;


    @ApiField("refund_flag")
    private String refundFlag;


    @ApiField("status")
    private String status;


    @ApiField("template_no")
    private String templateNo;


    @ApiField("user_id")
    private String userId;


    public String getAvailableAmount() {
        /* 107 */
        return this.availableAmount;

    }


    public void setAvailableAmount(String availableAmount) {
        /* 110 */
        this.availableAmount = availableAmount;

    }


    public String getCouponNo() {
        /* 114 */
        return this.couponNo;

    }


    public void setCouponNo(String couponNo) {
        /* 117 */
        this.couponNo = couponNo;

    }


    public String getDeductAmount() {
        /* 121 */
        return this.deductAmount;

    }


    public void setDeductAmount(String deductAmount) {
        /* 124 */
        this.deductAmount = deductAmount;

    }


    public String getGmtActive() {
        /* 128 */
        return this.gmtActive;

    }


    public void setGmtActive(String gmtActive) {
        /* 131 */
        this.gmtActive = gmtActive;

    }


    public String getGmtCreate() {
        /* 135 */
        return this.gmtCreate;

    }


    public void setGmtCreate(String gmtCreate) {
        /* 138 */
        this.gmtCreate = gmtCreate;

    }


    public String getGmtExpired() {
        /* 142 */
        return this.gmtExpired;

    }


    public void setGmtExpired(String gmtExpired) {
        /* 145 */
        this.gmtExpired = gmtExpired;

    }


    public String getInstructions() {
        /* 149 */
        return this.instructions;

    }


    public void setInstructions(String instructions) {
        /* 152 */
        this.instructions = instructions;

    }


    public String getMemo() {
        /* 156 */
        return this.memo;

    }


    public void setMemo(String memo) {
        /* 159 */
        this.memo = memo;

    }


    public String getMerchantUniqId() {
        /* 163 */
        return this.merchantUniqId;

    }


    public void setMerchantUniqId(String merchantUniqId) {
        /* 166 */
        this.merchantUniqId = merchantUniqId;

    }


    public String getMultiUseFlag() {
        /* 170 */
        return this.multiUseFlag;

    }


    public void setMultiUseFlag(String multiUseFlag) {
        /* 173 */
        this.multiUseFlag = multiUseFlag;

    }


    public String getName() {
        /* 177 */
        return this.name;

    }


    public void setName(String name) {
        /* 180 */
        this.name = name;

    }


    public String getRefundFlag() {
        /* 184 */
        return this.refundFlag;

    }


    public void setRefundFlag(String refundFlag) {
        /* 187 */
        this.refundFlag = refundFlag;

    }


    public String getStatus() {
        /* 191 */
        return this.status;

    }


    public void setStatus(String status) {
        /* 194 */
        this.status = status;

    }


    public String getTemplateNo() {
        /* 198 */
        return this.templateNo;

    }


    public void setTemplateNo(String templateNo) {
        /* 201 */
        this.templateNo = templateNo;

    }


    public String getUserId() {
        /* 205 */
        return this.userId;

    }


    public void setUserId(String userId) {
        /* 208 */
        this.userId = userId;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.Coupon
 * JD-Core Version:    0.6.0
 */