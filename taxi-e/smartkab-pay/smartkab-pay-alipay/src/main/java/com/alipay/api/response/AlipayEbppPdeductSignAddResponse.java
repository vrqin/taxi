package com.alipay.api.response;


import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;


public class AlipayEbppPdeductSignAddResponse extends AlipayResponse {
    private static final long serialVersionUID = 6579492764491134199L;


    @ApiField("agreement_id")
    private String agreementId;


    @ApiField("agreement_status")
    private String agreementStatus;


    @ApiField("extend_field")
    private String extendField;


    @ApiField("notify_config")
    private String notifyConfig;


    @ApiField("out_agreement_id")
    private String outAgreementId;


    @ApiListField("pay_config")

    @ApiField("string")
    private List<String> payConfig;


    @ApiField("sign_date")
    private String signDate;


    public String getAgreementId() {
        /*  66 */
        return this.agreementId;

    }


    public void setAgreementId(String agreementId) {
        /*  63 */
        this.agreementId = agreementId;

    }


    public String getAgreementStatus() {
        /*  73 */
        return this.agreementStatus;

    }


    public void setAgreementStatus(String agreementStatus) {
        /*  70 */
        this.agreementStatus = agreementStatus;

    }


    public String getExtendField() {
        /*  80 */
        return this.extendField;

    }


    public void setExtendField(String extendField) {
        /*  77 */
        this.extendField = extendField;

    }


    public String getNotifyConfig() {
        /*  87 */
        return this.notifyConfig;

    }


    public void setNotifyConfig(String notifyConfig) {
        /*  84 */
        this.notifyConfig = notifyConfig;

    }


    public String getOutAgreementId() {
        /*  94 */
        return this.outAgreementId;

    }


    public void setOutAgreementId(String outAgreementId) {
        /*  91 */
        this.outAgreementId = outAgreementId;

    }


    public List<String> getPayConfig() {
        /* 101 */
        return this.payConfig;

    }


    public void setPayConfig(List<String> payConfig) {
        /*  98 */
        this.payConfig = payConfig;

    }


    public String getSignDate() {
        /* 108 */
        return this.signDate;

    }


    public void setSignDate(String signDate) {
        /* 105 */
        this.signDate = signDate;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayEbppPdeductSignAddResponse
 * JD-Core Version:    0.6.0
 */