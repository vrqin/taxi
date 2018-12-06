package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayTrustUserRiskSummaryGetResponse extends AlipayResponse {
    private static final long serialVersionUID = 8565558196165282448L;

    @ApiField("risk_code")
    private String riskCode;

    public String getRiskCode() {
        /* 27 */
        return this.riskCode;
    }

    public void setRiskCode(String riskCode) {
        /* 24 */
        this.riskCode = riskCode;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayTrustUserRiskSummaryGetResponse
 * JD-Core Version:    0.6.0
 */