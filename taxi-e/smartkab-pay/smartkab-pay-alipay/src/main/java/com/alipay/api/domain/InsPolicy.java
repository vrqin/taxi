package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.Date;
import java.util.List;


public class InsPolicy extends AlipayObject {
    private static final long serialVersionUID = 7462211196898679599L;


    @ApiField("applicant")
    private InsPerson applicant;


    @ApiField("biz_data")
    private String bizData;


    @ApiListField("claims")

    @ApiField("ins_claim")
    private List<InsClaim> claims;


    @ApiField("effect_end_time")
    private String effectEndTime;


    @ApiField("effect_start_time")
    private String effectStartTime;


    @ApiListField("insureds")

    @ApiField("ins_person")
    private List<InsPerson> insureds;


    @ApiField("merchant_name")
    private String merchantName;


    @ApiField("policy_no")
    private String policyNo;


    @ApiField("policy_status")
    private String policyStatus;


    @ApiField("premium")
    private Long premium;


    @ApiField("prod_name")
    private String prodName;


    @ApiField("sum_insured")
    private Long sumInsured;


    @ApiField("surrender_fee")
    private Long surrenderFee;


    @ApiField("surrender_time")
    private Date surrenderTime;


    public InsPerson getApplicant() {
        /* 107 */
        return this.applicant;

    }


    public void setApplicant(InsPerson applicant) {
        /* 110 */
        this.applicant = applicant;

    }


    public String getBizData() {
        /* 114 */
        return this.bizData;

    }


    public void setBizData(String bizData) {
        /* 117 */
        this.bizData = bizData;

    }


    public List<InsClaim> getClaims() {
        /* 121 */
        return this.claims;

    }


    public void setClaims(List<InsClaim> claims) {
        /* 124 */
        this.claims = claims;

    }


    public String getEffectEndTime() {
        /* 128 */
        return this.effectEndTime;

    }


    public void setEffectEndTime(String effectEndTime) {
        /* 131 */
        this.effectEndTime = effectEndTime;

    }


    public String getEffectStartTime() {
        /* 135 */
        return this.effectStartTime;

    }


    public void setEffectStartTime(String effectStartTime) {
        /* 138 */
        this.effectStartTime = effectStartTime;

    }


    public List<InsPerson> getInsureds() {
        /* 142 */
        return this.insureds;

    }


    public void setInsureds(List<InsPerson> insureds) {
        /* 145 */
        this.insureds = insureds;

    }


    public String getMerchantName() {
        /* 149 */
        return this.merchantName;

    }


    public void setMerchantName(String merchantName) {
        /* 152 */
        this.merchantName = merchantName;

    }


    public String getPolicyNo() {
        /* 156 */
        return this.policyNo;

    }


    public void setPolicyNo(String policyNo) {
        /* 159 */
        this.policyNo = policyNo;

    }


    public String getPolicyStatus() {
        /* 163 */
        return this.policyStatus;

    }


    public void setPolicyStatus(String policyStatus) {
        /* 166 */
        this.policyStatus = policyStatus;

    }


    public Long getPremium() {
        /* 170 */
        return this.premium;

    }


    public void setPremium(Long premium) {
        /* 173 */
        this.premium = premium;

    }


    public String getProdName() {
        /* 177 */
        return this.prodName;

    }


    public void setProdName(String prodName) {
        /* 180 */
        this.prodName = prodName;

    }


    public Long getSumInsured() {
        /* 184 */
        return this.sumInsured;

    }


    public void setSumInsured(Long sumInsured) {
        /* 187 */
        this.sumInsured = sumInsured;

    }


    public Long getSurrenderFee() {
        /* 191 */
        return this.surrenderFee;

    }


    public void setSurrenderFee(Long surrenderFee) {
        /* 194 */
        this.surrenderFee = surrenderFee;

    }


    public Date getSurrenderTime() {
        /* 198 */
        return this.surrenderTime;

    }


    public void setSurrenderTime(Date surrenderTime) {
        /* 201 */
        this.surrenderTime = surrenderTime;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.InsPolicy
 * JD-Core Version:    0.6.0
 */