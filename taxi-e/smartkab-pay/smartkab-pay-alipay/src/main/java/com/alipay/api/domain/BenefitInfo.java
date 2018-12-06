package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;


public class BenefitInfo extends AlipayObject {
    private static final long serialVersionUID = 1282154583463359857L;


    @ApiField("benefit_info_id")
    private String benefitInfoId;


    @ApiField("benefit_name")
    private String benefitName;


    @ApiField("benefit_name_cn")
    private String benefitNameCn;


    @ApiField("benefit_type")
    private String benefitType;


    @ApiField("dispatch_dt")
    private Date dispatchDt;


    @ApiField("end_dt")
    private Date endDt;


    @ApiField("start_dt")
    private Date startDt;


    @ApiField("status")
    private String status;


    public String getBenefitInfoId() {
        /*  70 */
        return this.benefitInfoId;

    }


    public void setBenefitInfoId(String benefitInfoId) {
        /*  73 */
        this.benefitInfoId = benefitInfoId;

    }


    public String getBenefitName() {
        /*  77 */
        return this.benefitName;

    }


    public void setBenefitName(String benefitName) {
        /*  80 */
        this.benefitName = benefitName;

    }


    public String getBenefitNameCn() {
        /*  84 */
        return this.benefitNameCn;

    }


    public void setBenefitNameCn(String benefitNameCn) {
        /*  87 */
        this.benefitNameCn = benefitNameCn;

    }


    public String getBenefitType() {
        /*  91 */
        return this.benefitType;

    }


    public void setBenefitType(String benefitType) {
        /*  94 */
        this.benefitType = benefitType;

    }


    public Date getDispatchDt() {
        /*  98 */
        return this.dispatchDt;

    }


    public void setDispatchDt(Date dispatchDt) {
        /* 101 */
        this.dispatchDt = dispatchDt;

    }


    public Date getEndDt() {
        /* 105 */
        return this.endDt;

    }


    public void setEndDt(Date endDt) {
        /* 108 */
        this.endDt = endDt;

    }


    public Date getStartDt() {
        /* 112 */
        return this.startDt;

    }


    public void setStartDt(Date startDt) {
        /* 115 */
        this.startDt = startDt;

    }


    public String getStatus() {
        /* 119 */
        return this.status;

    }


    public void setStatus(String status) {
        /* 122 */
        this.status = status;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.BenefitInfo
 * JD-Core Version:    0.6.0
 */