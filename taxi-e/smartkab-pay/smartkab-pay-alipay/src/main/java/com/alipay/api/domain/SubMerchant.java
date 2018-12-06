package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class SubMerchant extends AlipayObject {
    private static final long serialVersionUID = 1237117437151462333L;

    @ApiField("merchant_id")
    private String merchantId;

    public String getMerchantId() {
        /* 23 */
        return this.merchantId;
    }

    public void setMerchantId(String merchantId) {
        /* 26 */
        this.merchantId = merchantId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.SubMerchant
 * JD-Core Version:    0.6.0
 */