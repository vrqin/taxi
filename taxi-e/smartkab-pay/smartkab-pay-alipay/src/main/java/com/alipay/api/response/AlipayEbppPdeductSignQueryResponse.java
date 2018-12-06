package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayEbppPdeductSignQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 3292462535164759438L;

    @ApiField("agreement_id")
    private String agreementId;

    @ApiField("bill_key")
    private String billKey;

    @ApiField("charge_inst")
    private String chargeInst;

    @ApiField("out_agreement_id")
    private String outAgreementId;

    @ApiField("sign_date")
    private String signDate;

    @ApiField("user_id")
    private String userId;

    public String getAgreementId() {
        /* 57 */
        return this.agreementId;
    }

    public void setAgreementId(String agreementId) {
        /* 54 */
        this.agreementId = agreementId;
    }

    public String getBillKey() {
        /* 64 */
        return this.billKey;
    }

    public void setBillKey(String billKey) {
        /* 61 */
        this.billKey = billKey;
    }

    public String getChargeInst() {
        /* 71 */
        return this.chargeInst;
    }

    public void setChargeInst(String chargeInst) {
        /* 68 */
        this.chargeInst = chargeInst;
    }

    public String getOutAgreementId() {
        /* 78 */
        return this.outAgreementId;
    }

    public void setOutAgreementId(String outAgreementId) {
        /* 75 */
        this.outAgreementId = outAgreementId;
    }

    public String getSignDate() {
        /* 85 */
        return this.signDate;
    }

    public void setSignDate(String signDate) {
        /* 82 */
        this.signDate = signDate;
    }

    public String getUserId() {
        /* 92 */
        return this.userId;
    }

    public void setUserId(String userId) {
        /* 89 */
        this.userId = userId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayEbppPdeductSignQueryResponse
 * JD-Core Version:    0.6.0
 */