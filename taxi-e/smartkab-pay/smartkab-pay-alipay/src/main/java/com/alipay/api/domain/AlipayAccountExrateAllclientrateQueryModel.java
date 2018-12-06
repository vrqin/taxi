package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayAccountExrateAllclientrateQueryModel extends AlipayObject {
    private static final long serialVersionUID = 5577259997912373746L;

    @ApiField("client_id")
    private String clientId;

    @ApiField("profile_id")
    private String profileId;

    public String getClientId() {
        /* 29 */
        return this.clientId;
    }

    public void setClientId(String clientId) {
        /* 32 */
        this.clientId = clientId;
    }

    public String getProfileId() {
        /* 36 */
        return this.profileId;
    }

    public void setProfileId(String profileId) {
        /* 39 */
        this.profileId = profileId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayAccountExrateAllclientrateQueryModel
 * JD-Core Version:    0.6.0
 */