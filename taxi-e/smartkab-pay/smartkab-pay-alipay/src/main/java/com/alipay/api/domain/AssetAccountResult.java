package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AssetAccountResult extends AlipayObject {
    private static final long serialVersionUID = 6854553241661658422L;

    @ApiField("alipay_user_id")
    private String alipayUserId;

    @ApiField("consumer_id")
    private String consumerId;

    @ApiField("provider_id")
    private String providerId;

    @ApiField("provider_user_id")
    private String providerUserId;

    @ApiField("provider_user_name")
    private String providerUserName;

    public String getAlipayUserId() {
        /* 47 */
        return this.alipayUserId;
    }

    public void setAlipayUserId(String alipayUserId) {
        /* 50 */
        this.alipayUserId = alipayUserId;
    }

    public String getConsumerId() {
        /* 54 */
        return this.consumerId;
    }

    public void setConsumerId(String consumerId) {
        /* 57 */
        this.consumerId = consumerId;
    }

    public String getProviderId() {
        /* 61 */
        return this.providerId;
    }

    public void setProviderId(String providerId) {
        /* 64 */
        this.providerId = providerId;
    }

    public String getProviderUserId() {
        /* 68 */
        return this.providerUserId;
    }

    public void setProviderUserId(String providerUserId) {
        /* 71 */
        this.providerUserId = providerUserId;
    }

    public String getProviderUserName() {
        /* 75 */
        return this.providerUserName;
    }

    public void setProviderUserName(String providerUserName) {
        /* 78 */
        this.providerUserName = providerUserName;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AssetAccountResult
 * JD-Core Version:    0.6.0
 */