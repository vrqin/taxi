package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.Date;
import java.util.List;


public class AlipayInsSceneInsureModel extends AlipayObject {
    private static final long serialVersionUID = 8379568419791656399L;


    @ApiField("applicant")
    private InsPerson applicant;


    @ApiField("biz_data")
    private String bizData;


    @ApiField("effect_start_time")
    private Date effectStartTime;


    @ApiListField("insureds")

    @ApiField("ins_person")
    private List<InsPerson> insureds;


    @ApiField("out_biz_no")
    private String outBizNo;


    @ApiField("period")
    private String period;


    @ApiField("prod_code")
    private String prodCode;


    @ApiField("source")
    private String source;


    public InsPerson getApplicant() {
        /*  70 */
        return this.applicant;

    }


    public void setApplicant(InsPerson applicant) {
        /*  73 */
        this.applicant = applicant;

    }


    public String getBizData() {
        /*  77 */
        return this.bizData;

    }


    public void setBizData(String bizData) {
        /*  80 */
        this.bizData = bizData;

    }


    public Date getEffectStartTime() {
        /*  84 */
        return this.effectStartTime;

    }


    public void setEffectStartTime(Date effectStartTime) {
        /*  87 */
        this.effectStartTime = effectStartTime;

    }


    public List<InsPerson> getInsureds() {
        /*  91 */
        return this.insureds;

    }


    public void setInsureds(List<InsPerson> insureds) {
        /*  94 */
        this.insureds = insureds;

    }


    public String getOutBizNo() {
        /*  98 */
        return this.outBizNo;

    }


    public void setOutBizNo(String outBizNo) {
        /* 101 */
        this.outBizNo = outBizNo;

    }


    public String getPeriod() {
        /* 105 */
        return this.period;

    }


    public void setPeriod(String period) {
        /* 108 */
        this.period = period;

    }


    public String getProdCode() {
        /* 112 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 115 */
        this.prodCode = prodCode;

    }


    public String getSource() {
        /* 119 */
        return this.source;

    }


    public void setSource(String source) {
        /* 122 */
        this.source = source;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayInsSceneInsureModel
 * JD-Core Version:    0.6.0
 */