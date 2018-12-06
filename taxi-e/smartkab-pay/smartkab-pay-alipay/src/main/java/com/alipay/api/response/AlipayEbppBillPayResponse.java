package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayEbppBillPayResponse extends AlipayResponse {
    private static final long serialVersionUID = 5377242761793134319L;

    @ApiField("alipay_order_no")
    private String alipayOrderNo;

    @ApiField("merchant_order_no")
    private String merchantOrderNo;

    @ApiField("order_status")
    private String orderStatus;

    @ApiField("order_type")
    private String orderType;

    public String getAlipayOrderNo() {
        /* 45 */
        return this.alipayOrderNo;
    }

    public void setAlipayOrderNo(String alipayOrderNo) {
        /* 42 */
        this.alipayOrderNo = alipayOrderNo;
    }

    public String getMerchantOrderNo() {
        /* 52 */
        return this.merchantOrderNo;
    }

    public void setMerchantOrderNo(String merchantOrderNo) {
        /* 49 */
        this.merchantOrderNo = merchantOrderNo;
    }

    public String getOrderStatus() {
        /* 59 */
        return this.orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        /* 56 */
        this.orderStatus = orderStatus;
    }

    public String getOrderType() {
        /* 66 */
        return this.orderType;
    }

    public void setOrderType(String orderType) {
        /* 63 */
        this.orderType = orderType;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayEbppBillPayResponse
 * JD-Core Version:    0.6.0
 */