package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class MerchantScreenHit extends AlipayObject {
    private static final long serialVersionUID = 3773956138278242471L;

    @ApiField("input_type")
    private String inputType;

    @ApiField("risk_detail")
    private String riskDetail;

    public String getInputType() {
        /* 29 */
        return this.inputType;
    }

    public void setInputType(String inputType) {
        /* 32 */
        this.inputType = inputType;
    }

    public String getRiskDetail() {
        /* 36 */
        return this.riskDetail;
    }

    public void setRiskDetail(String riskDetail) {
        /* 39 */
        this.riskDetail = riskDetail;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.MerchantScreenHit
 * JD-Core Version:    0.6.0
 */