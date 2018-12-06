package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipaySecurityRiskDetectResponse extends AlipayResponse {
    private static final long serialVersionUID = 6513743619585371131L;

    @ApiField("risk_code")
    private String riskCode;

    @ApiField("risk_level")
    private Long riskLevel;

    public String getRiskCode() {
        /* 33 */
        return this.riskCode;
    }

    public void setRiskCode(String riskCode) {
        /* 30 */
        this.riskCode = riskCode;
    }

    public Long getRiskLevel() {
        /* 40 */
        return this.riskLevel;
    }

    public void setRiskLevel(Long riskLevel) {
        /* 37 */
        this.riskLevel = riskLevel;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipaySecurityRiskDetectResponse
 * JD-Core Version:    0.6.0
 */