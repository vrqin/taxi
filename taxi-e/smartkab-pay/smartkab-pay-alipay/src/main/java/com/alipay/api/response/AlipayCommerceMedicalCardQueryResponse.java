package com.alipay.api.response;


import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayCommerceMedicalCardQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 2493686516542688241L;


    @ApiField("agreement_no")
    private String agreementNo;


    @ApiField("buyer_logon_id")
    private String buyerLogonId;


    @ApiField("buyer_user_id")
    private String buyerUserId;


    @ApiField("card_org_name")
    private String cardOrgName;


    @ApiField("card_org_no")
    private String cardOrgNo;


    @ApiField("city")
    private String city;


    @ApiField("extend_params")
    private String extendParams;


    @ApiField("gmt_sign")
    private String gmtSign;


    @ApiField("medical_card_id")
    private String medicalCardId;


    @ApiField("medical_card_no")
    private String medicalCardNo;


    @ApiField("medical_card_type")
    private String medicalCardType;


    @ApiField("sign_status")
    private String signStatus;


    public String getAgreementNo() {
        /*  98 */
        return this.agreementNo;

    }


    public void setAgreementNo(String agreementNo) {
        /*  95 */
        this.agreementNo = agreementNo;

    }


    public String getBuyerLogonId() {
        /* 105 */
        return this.buyerLogonId;

    }


    public void setBuyerLogonId(String buyerLogonId) {
        /* 102 */
        this.buyerLogonId = buyerLogonId;

    }


    public String getBuyerUserId() {
        /* 112 */
        return this.buyerUserId;

    }


    public void setBuyerUserId(String buyerUserId) {
        /* 109 */
        this.buyerUserId = buyerUserId;

    }


    public String getCardOrgName() {
        /* 119 */
        return this.cardOrgName;

    }


    public void setCardOrgName(String cardOrgName) {
        /* 116 */
        this.cardOrgName = cardOrgName;

    }


    public String getCardOrgNo() {
        /* 126 */
        return this.cardOrgNo;

    }


    public void setCardOrgNo(String cardOrgNo) {
        /* 123 */
        this.cardOrgNo = cardOrgNo;

    }


    public String getCity() {
        /* 133 */
        return this.city;

    }


    public void setCity(String city) {
        /* 130 */
        this.city = city;

    }


    public String getExtendParams() {
        /* 140 */
        return this.extendParams;

    }


    public void setExtendParams(String extendParams) {
        /* 137 */
        this.extendParams = extendParams;

    }


    public String getGmtSign() {
        /* 147 */
        return this.gmtSign;

    }


    public void setGmtSign(String gmtSign) {
        /* 144 */
        this.gmtSign = gmtSign;

    }


    public String getMedicalCardId() {
        /* 154 */
        return this.medicalCardId;

    }


    public void setMedicalCardId(String medicalCardId) {
        /* 151 */
        this.medicalCardId = medicalCardId;

    }


    public String getMedicalCardNo() {
        /* 161 */
        return this.medicalCardNo;

    }


    public void setMedicalCardNo(String medicalCardNo) {
        /* 158 */
        this.medicalCardNo = medicalCardNo;

    }


    public String getMedicalCardType() {
        /* 168 */
        return this.medicalCardType;

    }


    public void setMedicalCardType(String medicalCardType) {
        /* 165 */
        this.medicalCardType = medicalCardType;

    }


    public String getSignStatus() {
        /* 175 */
        return this.signStatus;

    }


    public void setSignStatus(String signStatus) {
        /* 172 */
        this.signStatus = signStatus;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayCommerceMedicalCardQueryResponse
 * JD-Core Version:    0.6.0
 */