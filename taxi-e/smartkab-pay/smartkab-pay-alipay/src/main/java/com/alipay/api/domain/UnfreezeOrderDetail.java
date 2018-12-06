package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;


public class UnfreezeOrderDetail extends AlipayObject {
    private static final long serialVersionUID = 2587251981225825936L;


    @ApiField("alipay_order_no")
    private String alipayOrderNo;


    @ApiField("create_time")
    private Date createTime;


    @ApiField("memo")
    private String memo;


    @ApiField("merchant_order_no")
    private String merchantOrderNo;


    @ApiField("modified_time")
    private Date modifiedTime;


    @ApiField("order_amount")
    private String orderAmount;


    @ApiField("order_status")
    private String orderStatus;


    @ApiField("unfreeze_amount")
    private String unfreezeAmount;


    public String getAlipayOrderNo() {
        /*  67 */
        return this.alipayOrderNo;

    }


    public void setAlipayOrderNo(String alipayOrderNo) {
        /*  70 */
        this.alipayOrderNo = alipayOrderNo;

    }


    public Date getCreateTime() {
        /*  74 */
        return this.createTime;

    }


    public void setCreateTime(Date createTime) {
        /*  77 */
        this.createTime = createTime;

    }


    public String getMemo() {
        /*  81 */
        return this.memo;

    }


    public void setMemo(String memo) {
        /*  84 */
        this.memo = memo;

    }


    public String getMerchantOrderNo() {
        /*  88 */
        return this.merchantOrderNo;

    }


    public void setMerchantOrderNo(String merchantOrderNo) {
        /*  91 */
        this.merchantOrderNo = merchantOrderNo;

    }


    public Date getModifiedTime() {
        /*  95 */
        return this.modifiedTime;

    }


    public void setModifiedTime(Date modifiedTime) {
        /*  98 */
        this.modifiedTime = modifiedTime;

    }


    public String getOrderAmount() {
        /* 102 */
        return this.orderAmount;

    }


    public void setOrderAmount(String orderAmount) {
        /* 105 */
        this.orderAmount = orderAmount;

    }


    public String getOrderStatus() {
        /* 109 */
        return this.orderStatus;

    }


    public void setOrderStatus(String orderStatus) {
        /* 112 */
        this.orderStatus = orderStatus;

    }


    public String getUnfreezeAmount() {
        /* 116 */
        return this.unfreezeAmount;

    }


    public void setUnfreezeAmount(String unfreezeAmount) {
        /* 119 */
        this.unfreezeAmount = unfreezeAmount;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.UnfreezeOrderDetail
 * JD-Core Version:    0.6.0
 */