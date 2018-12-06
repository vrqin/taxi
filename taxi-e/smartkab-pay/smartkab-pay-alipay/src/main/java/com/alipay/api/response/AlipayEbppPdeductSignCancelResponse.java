package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayEbppPdeductSignCancelResponse extends AlipayResponse {
    private static final long serialVersionUID = 1686964189811826512L;

    @ApiField("agreement_id")
    private String agreementId;

    @ApiField("agreement_status")
    private String agreementStatus;

    @ApiField("out_agreement_id")
    private String outAgreementId;

    public String getAgreementId() {
        /* 39 */
        return this.agreementId;
    }

    public void setAgreementId(String agreementId) {
        /* 36 */
        this.agreementId = agreementId;
    }

    public String getAgreementStatus() {
        /* 46 */
        return this.agreementStatus;
    }

    public void setAgreementStatus(String agreementStatus) {
        /* 43 */
        this.agreementStatus = agreementStatus;
    }

    public String getOutAgreementId() {
        /* 53 */
        return this.outAgreementId;
    }

    public void setOutAgreementId(String outAgreementId) {
        /* 50 */
        this.outAgreementId = outAgreementId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayEbppPdeductSignCancelResponse
 * JD-Core Version:    0.6.0
 */