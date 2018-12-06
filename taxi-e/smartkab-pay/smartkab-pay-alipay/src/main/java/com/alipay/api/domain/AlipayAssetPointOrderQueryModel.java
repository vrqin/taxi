package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayAssetPointOrderQueryModel extends AlipayObject {
    private static final long serialVersionUID = 7821862994518328166L;

    @ApiField("merchant_order_no")
    private String merchantOrderNo;

    public String getMerchantOrderNo() {
        /* 23 */
        return this.merchantOrderNo;
    }

    public void setMerchantOrderNo(String merchantOrderNo) {
        /* 26 */
        this.merchantOrderNo = merchantOrderNo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayAssetPointOrderQueryModel
 * JD-Core Version:    0.6.0
 */