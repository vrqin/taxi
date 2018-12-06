package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayTradeAppMergePayModel extends AlipayObject {
    private static final long serialVersionUID = 5817131754524457837L;

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
 * Qualified Name:     com.alipay.api.domain.AlipayTradeAppMergePayModel
 * JD-Core Version:    0.6.0
 */