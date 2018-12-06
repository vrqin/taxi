package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class InfoCode extends AlipayObject {
    private static final long serialVersionUID = 3855157437169238515L;

    @ApiField("risk_description")
    private String riskDescription;

    @ApiField("risk_factor_code")
    private String riskFactorCode;

    @ApiField("risk_factor_name")
    private String riskFactorName;

    @ApiField("risk_magnitude")
    private String riskMagnitude;

    public String getRiskDescription() {
        /* 41 */
        return this.riskDescription;
    }

    public void setRiskDescription(String riskDescription) {
        /* 44 */
        this.riskDescription = riskDescription;
    }

    public String getRiskFactorCode() {
        /* 48 */
        return this.riskFactorCode;
    }

    public void setRiskFactorCode(String riskFactorCode) {
        /* 51 */
        this.riskFactorCode = riskFactorCode;
    }

    public String getRiskFactorName() {
        /* 55 */
        return this.riskFactorName;
    }

    public void setRiskFactorName(String riskFactorName) {
        /* 58 */
        this.riskFactorName = riskFactorName;
    }

    public String getRiskMagnitude() {
        /* 62 */
        return this.riskMagnitude;
    }

    public void setRiskMagnitude(String riskMagnitude) {
        /* 65 */
        this.riskMagnitude = riskMagnitude;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.InfoCode
 * JD-Core Version:    0.6.0
 */