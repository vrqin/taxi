package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AliTrustRiskIdentify extends AlipayObject {
    private static final long serialVersionUID = 2599696537452965422L;

    @ApiListField("details")
    @ApiField("zhima_risk_detail")
    private List<ZhimaRiskDetail> details;

    @ApiField("is_risk")
    private String isRisk;

    @ApiField("risk_tag")
    private String riskTag;

    public List<ZhimaRiskDetail> getDetails() {
        /* 39 */
        return this.details;
    }

    public void setDetails(List<ZhimaRiskDetail> details) {
        /* 42 */
        this.details = details;
    }

    public String getIsRisk() {
        /* 46 */
        return this.isRisk;
    }

    public void setIsRisk(String isRisk) {
        /* 49 */
        this.isRisk = isRisk;
    }

    public String getRiskTag() {
        /* 53 */
        return this.riskTag;
    }

    public void setRiskTag(String riskTag) {
        /* 56 */
        this.riskTag = riskTag;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AliTrustRiskIdentify
 * JD-Core Version:    0.6.0
 */