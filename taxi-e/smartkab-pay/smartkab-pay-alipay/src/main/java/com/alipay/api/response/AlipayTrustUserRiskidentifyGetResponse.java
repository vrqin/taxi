package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.AliTrustRiskIdentify;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayTrustUserRiskidentifyGetResponse extends AlipayResponse {
    private static final long serialVersionUID = 1196482965491886171L;

    @ApiField("ali_trust_risk_identify")
    private AliTrustRiskIdentify aliTrustRiskIdentify;

    public AliTrustRiskIdentify getAliTrustRiskIdentify() {
        /* 28 */
        return this.aliTrustRiskIdentify;
    }

    public void setAliTrustRiskIdentify(AliTrustRiskIdentify aliTrustRiskIdentify) {
        /* 25 */
        this.aliTrustRiskIdentify = aliTrustRiskIdentify;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayTrustUserRiskidentifyGetResponse
 * JD-Core Version:    0.6.0
 */