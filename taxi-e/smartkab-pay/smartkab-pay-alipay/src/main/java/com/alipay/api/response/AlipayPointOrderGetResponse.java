package com.alipay.api.response;


import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;


public class AlipayPointOrderGetResponse extends AlipayResponse {
    private static final long serialVersionUID = 1321761653583675345L;


    @ApiField("alipay_order_no")
    private String alipayOrderNo;


    @ApiField("create_time")
    private Date createTime;


    @ApiField("dispatch_user_id")
    private String dispatchUserId;


    @ApiField("memo")
    private String memo;


    @ApiField("merchant_order_no")
    private String merchantOrderNo;


    @ApiField("order_status")
    private String orderStatus;


    @ApiField("point_count")
    private Long pointCount;


    @ApiField("receive_user_id")
    private String receiveUserId;


    public String getAlipayOrderNo() {
        /*  70 */
        return this.alipayOrderNo;

    }


    public void setAlipayOrderNo(String alipayOrderNo) {
        /*  67 */
        this.alipayOrderNo = alipayOrderNo;

    }


    public Date getCreateTime() {
        /*  77 */
        return this.createTime;

    }


    public void setCreateTime(Date createTime) {
        /*  74 */
        this.createTime = createTime;

    }


    public String getDispatchUserId() {
        /*  84 */
        return this.dispatchUserId;

    }


    public void setDispatchUserId(String dispatchUserId) {
        /*  81 */
        this.dispatchUserId = dispatchUserId;

    }


    public String getMemo() {
        /*  91 */
        return this.memo;

    }


    public void setMemo(String memo) {
        /*  88 */
        this.memo = memo;

    }


    public String getMerchantOrderNo() {
        /*  98 */
        return this.merchantOrderNo;

    }


    public void setMerchantOrderNo(String merchantOrderNo) {
        /*  95 */
        this.merchantOrderNo = merchantOrderNo;

    }


    public String getOrderStatus() {
        /* 105 */
        return this.orderStatus;

    }


    public void setOrderStatus(String orderStatus) {
        /* 102 */
        this.orderStatus = orderStatus;

    }


    public Long getPointCount() {
        /* 112 */
        return this.pointCount;

    }


    public void setPointCount(Long pointCount) {
        /* 109 */
        this.pointCount = pointCount;

    }


    public String getReceiveUserId() {
        /* 119 */
        return this.receiveUserId;

    }


    public void setReceiveUserId(String receiveUserId) {
        /* 116 */
        this.receiveUserId = receiveUserId;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayPointOrderGetResponse
 * JD-Core Version:    0.6.0
 */