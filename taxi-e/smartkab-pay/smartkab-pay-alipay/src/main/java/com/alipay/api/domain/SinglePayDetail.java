package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;


public class SinglePayDetail extends AlipayObject {
    private static final long serialVersionUID = 6416728191656685429L;


    @ApiField("alipay_order_no")
    private String alipayOrderNo;


    @ApiField("amount")
    private String amount;


    @ApiField("create_time")
    private Date createTime;


    @ApiField("modified_time")
    private Date modifiedTime;


    @ApiField("pay_url")
    private String payUrl;


    @ApiField("receive_user_id")
    private String receiveUserId;


    @ApiField("transfer_order_no")
    private String transferOrderNo;


    @ApiField("transfer_out_order_no")
    private String transferOutOrderNo;


    public String getAlipayOrderNo() {
        /*  67 */
        return this.alipayOrderNo;

    }


    public void setAlipayOrderNo(String alipayOrderNo) {
        /*  70 */
        this.alipayOrderNo = alipayOrderNo;

    }


    public String getAmount() {
        /*  74 */
        return this.amount;

    }


    public void setAmount(String amount) {
        /*  77 */
        this.amount = amount;

    }


    public Date getCreateTime() {
        /*  81 */
        return this.createTime;

    }


    public void setCreateTime(Date createTime) {
        /*  84 */
        this.createTime = createTime;

    }


    public Date getModifiedTime() {
        /*  88 */
        return this.modifiedTime;

    }


    public void setModifiedTime(Date modifiedTime) {
        /*  91 */
        this.modifiedTime = modifiedTime;

    }


    public String getPayUrl() {
        /*  95 */
        return this.payUrl;

    }


    public void setPayUrl(String payUrl) {
        /*  98 */
        this.payUrl = payUrl;

    }


    public String getReceiveUserId() {
        /* 102 */
        return this.receiveUserId;

    }


    public void setReceiveUserId(String receiveUserId) {
        /* 105 */
        this.receiveUserId = receiveUserId;

    }


    public String getTransferOrderNo() {
        /* 109 */
        return this.transferOrderNo;

    }


    public void setTransferOrderNo(String transferOrderNo) {
        /* 112 */
        this.transferOrderNo = transferOrderNo;

    }


    public String getTransferOutOrderNo() {
        /* 116 */
        return this.transferOutOrderNo;

    }


    public void setTransferOutOrderNo(String transferOutOrderNo) {
        /* 119 */
        this.transferOutOrderNo = transferOutOrderNo;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.SinglePayDetail
 * JD-Core Version:    0.6.0
 */