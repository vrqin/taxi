package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayBossProdSubmerchantQueryModel extends AlipayObject {
    private static final long serialVersionUID = 1615237417115596897L;

    @ApiField("external_id")
    private String externalId;

    @ApiField("sub_merchant_id")
    private String subMerchantId;

    public String getExternalId() {
        /* 29 */
        return this.externalId;
    }

    public void setExternalId(String externalId) {
        /* 32 */
        this.externalId = externalId;
    }

    public String getSubMerchantId() {
        /* 36 */
        return this.subMerchantId;
    }

    public void setSubMerchantId(String subMerchantId) {
        /* 39 */
        this.subMerchantId = subMerchantId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayBossProdSubmerchantQueryModel
 * JD-Core Version:    0.6.0
 */