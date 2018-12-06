package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayEcoMycarMaintainOrderCreateResponse extends AlipayResponse {
    private static final long serialVersionUID = 2875392216995344986L;

    @ApiField("order_no")
    private String orderNo;

    public String getOrderNo() {
        /* 27 */
        return this.orderNo;
    }

    public void setOrderNo(String orderNo) {
        /* 24 */
        this.orderNo = orderNo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayEcoMycarMaintainOrderCreateResponse
 * JD-Core Version:    0.6.0
 */