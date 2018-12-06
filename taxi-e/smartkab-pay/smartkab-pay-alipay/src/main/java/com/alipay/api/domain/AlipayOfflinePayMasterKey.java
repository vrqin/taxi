package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOfflinePayMasterKey extends AlipayObject {
    private static final long serialVersionUID = 5785528797463956289L;

    @ApiField("key_id")
    private Long keyId;

    @ApiField("public_key")
    private String publicKey;

    public Long getKeyId() {
        /* 29 */
        return this.keyId;
    }

    public void setKeyId(Long keyId) {
        /* 32 */
        this.keyId = keyId;
    }

    public String getPublicKey() {
        /* 36 */
        return this.publicKey;
    }

    public void setPublicKey(String publicKey) {
        /* 39 */
        this.publicKey = publicKey;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOfflinePayMasterKey
 * JD-Core Version:    0.6.0
 */