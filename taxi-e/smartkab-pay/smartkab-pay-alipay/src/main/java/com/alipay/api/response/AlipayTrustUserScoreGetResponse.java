package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.AliTrustScore;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayTrustUserScoreGetResponse extends AlipayResponse {
    private static final long serialVersionUID = 5234639137688698935L;

    @ApiField("ali_trust_score")
    private AliTrustScore aliTrustScore;

    public AliTrustScore getAliTrustScore() {
        /* 28 */
        return this.aliTrustScore;
    }

    public void setAliTrustScore(AliTrustScore aliTrustScore) {
        /* 25 */
        this.aliTrustScore = aliTrustScore;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayTrustUserScoreGetResponse
 * JD-Core Version:    0.6.0
 */