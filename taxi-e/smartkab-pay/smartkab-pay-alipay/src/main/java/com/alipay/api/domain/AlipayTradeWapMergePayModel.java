package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayTradeWapMergePayModel extends AlipayObject {
    private static final long serialVersionUID = 8575728638642964666L;

    @ApiField("pre_order_no")
    private String preOrderNo;

    public String getPreOrderNo() {
        /* 23 */
        return this.preOrderNo;
    }

    public void setPreOrderNo(String preOrderNo) {
        /* 26 */
        this.preOrderNo = preOrderNo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayTradeWapMergePayModel
 * JD-Core Version:    0.6.0
 */