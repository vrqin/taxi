package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayTransferThirdpartyBillCreateResponse extends AlipayResponse {
    private static final long serialVersionUID = 8385962673755259184L;

    @ApiField("order_id")
    private String orderId;

    @ApiField("order_type")
    private String orderType;

    @ApiField("payment_id")
    private String paymentId;

    public String getOrderId() {
        /* 39 */
        return this.orderId;
    }

    public void setOrderId(String orderId) {
        /* 36 */
        this.orderId = orderId;
    }

    public String getOrderType() {
        /* 46 */
        return this.orderType;
    }

    public void setOrderType(String orderType) {
        /* 43 */
        this.orderType = orderType;
    }

    public String getPaymentId() {
        /* 53 */
        return this.paymentId;
    }

    public void setPaymentId(String paymentId) {
        /* 50 */
        this.paymentId = paymentId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayTransferThirdpartyBillCreateResponse
 * JD-Core Version:    0.6.0
 */