package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayAssetAccountBindResponse extends AlipayResponse {
    private static final long serialVersionUID = 2583246916727288893L;

    @ApiField("alipay_user_id")
    private String alipayUserId;

    @ApiField("provider_id")
    private String providerId;

    @ApiField("provider_user_id")
    private String providerUserId;

    @ApiField("provider_user_name")
    private String providerUserName;

    public String getAlipayUserId() {
        /* 45 */
        return this.alipayUserId;
    }

    public void setAlipayUserId(String alipayUserId) {
        /* 42 */
        this.alipayUserId = alipayUserId;
    }

    public String getProviderId() {
        /* 52 */
        return this.providerId;
    }

    public void setProviderId(String providerId) {
        /* 49 */
        this.providerId = providerId;
    }

    public String getProviderUserId() {
        /* 59 */
        return this.providerUserId;
    }

    public void setProviderUserId(String providerUserId) {
        /* 56 */
        this.providerUserId = providerUserId;
    }

    public String getProviderUserName() {
        /* 66 */
        return this.providerUserName;
    }

    public void setProviderUserName(String providerUserName) {
        /* 63 */
        this.providerUserName = providerUserName;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayAssetAccountBindResponse
 * JD-Core Version:    0.6.0
 */