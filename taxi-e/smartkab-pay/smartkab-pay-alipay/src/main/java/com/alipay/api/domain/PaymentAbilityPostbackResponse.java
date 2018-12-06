package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class PaymentAbilityPostbackResponse extends AlipayObject {
    private static final long serialVersionUID = 8381745249119287343L;

    @ApiField("error_order")
    private String errorOrder;

    @ApiField("order_ids")
    private String orderIds;

    public String getErrorOrder() {
        /* 29 */
        return this.errorOrder;
    }

    public void setErrorOrder(String errorOrder) {
        /* 32 */
        this.errorOrder = errorOrder;
    }

    public String getOrderIds() {
        /* 36 */
        return this.orderIds;
    }

    public void setOrderIds(String orderIds) {
        /* 39 */
        this.orderIds = orderIds;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.PaymentAbilityPostbackResponse
 * JD-Core Version:    0.6.0
 */