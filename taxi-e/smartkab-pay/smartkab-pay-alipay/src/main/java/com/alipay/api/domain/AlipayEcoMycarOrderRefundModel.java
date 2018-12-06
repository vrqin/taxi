package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayEcoMycarOrderRefundModel extends AlipayObject {
    private static final long serialVersionUID = 5322364864268177228L;

    @ApiField("order_no")
    private String orderNo;

    @ApiField("refund_reason")
    private String refundReason;

    public String getOrderNo() {
        /* 29 */
        return this.orderNo;
    }

    public void setOrderNo(String orderNo) {
        /* 32 */
        this.orderNo = orderNo;
    }

    public String getRefundReason() {
        /* 36 */
        return this.refundReason;
    }

    public void setRefundReason(String refundReason) {
        /* 39 */
        this.refundReason = refundReason;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayEcoMycarOrderRefundModel
 * JD-Core Version:    0.6.0
 */