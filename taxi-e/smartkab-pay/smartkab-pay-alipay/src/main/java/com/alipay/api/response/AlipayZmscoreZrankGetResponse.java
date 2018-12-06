package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.AlipayZmScoreZrankResult;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayZmscoreZrankGetResponse extends AlipayResponse {
    private static final long serialVersionUID = 1581429724545164797L;

    @ApiField("zm_score_zrank")
    private AlipayZmScoreZrankResult zmScoreZrank;

    public AlipayZmScoreZrankResult getZmScoreZrank() {
        /* 28 */
        return this.zmScoreZrank;
    }

    public void setZmScoreZrank(AlipayZmScoreZrankResult zmScoreZrank) {
        /* 25 */
        this.zmScoreZrank = zmScoreZrank;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayZmscoreZrankGetResponse
 * JD-Core Version:    0.6.0
 */