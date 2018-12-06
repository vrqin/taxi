package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayEcoMycarOrderSyncVerifyModel extends AlipayObject {
    private static final long serialVersionUID = 8432634571224792211L;

    @ApiField("order_no")
    private String orderNo;

    @ApiField("order_status")
    private String orderStatus;

    @ApiField("sms_code")
    private String smsCode;

    public String getOrderNo() {
        /* 35 */
        return this.orderNo;
    }

    public void setOrderNo(String orderNo) {
        /* 38 */
        this.orderNo = orderNo;
    }

    public String getOrderStatus() {
        /* 42 */
        return this.orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        /* 45 */
        this.orderStatus = orderStatus;
    }

    public String getSmsCode() {
        /* 49 */
        return this.smsCode;
    }

    public void setSmsCode(String smsCode) {
        /* 52 */
        this.smsCode = smsCode;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayEcoMycarOrderSyncVerifyModel
 * JD-Core Version:    0.6.0
 */