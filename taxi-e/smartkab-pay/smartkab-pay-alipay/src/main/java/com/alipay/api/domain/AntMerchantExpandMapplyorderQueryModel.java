package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AntMerchantExpandMapplyorderQueryModel extends AlipayObject {
    private static final long serialVersionUID = 2488268772631962981L;

    @ApiField("order_no")
    private String orderNo;

    public String getOrderNo() {
        /* 23 */
        return this.orderNo;
    }

    public void setOrderNo(String orderNo) {
        /* 26 */
        this.orderNo = orderNo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AntMerchantExpandMapplyorderQueryModel
 * JD-Core Version:    0.6.0
 */