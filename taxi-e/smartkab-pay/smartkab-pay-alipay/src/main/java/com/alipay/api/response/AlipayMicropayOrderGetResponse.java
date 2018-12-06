package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.MicroPayOrderDetail;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMicropayOrderGetResponse extends AlipayResponse {
    private static final long serialVersionUID = 3252923722362445767L;

    @ApiField("micro_pay_order_detail")
    private MicroPayOrderDetail microPayOrderDetail;

    public MicroPayOrderDetail getMicroPayOrderDetail() {
        /* 28 */
        return this.microPayOrderDetail;
    }

    public void setMicroPayOrderDetail(MicroPayOrderDetail microPayOrderDetail) {
        /* 25 */
        this.microPayOrderDetail = microPayOrderDetail;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMicropayOrderGetResponse
 * JD-Core Version:    0.6.0
 */