package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class DishonestyDetailInfo extends AlipayObject {
    private static final long serialVersionUID = 1852537593638373981L;


    @ApiField("behavior")
    private String behavior;


    @ApiField("case_code")
    private String caseCode;


    @ApiField("enforce_court")
    private String enforceCourt;


    @ApiField("id_number")
    private String idNumber;


    @ApiField("name")
    private String name;


    @ApiField("performance")
    private String performance;


    @ApiField("publish_date")
    private String publishDate;


    @ApiField("region")
    private String region;


    public String getBehavior() {
        /*  65 */
        return this.behavior;

    }


    public void setBehavior(String behavior) {
        /*  68 */
        this.behavior = behavior;

    }


    public String getCaseCode() {
        /*  72 */
        return this.caseCode;

    }


    public void setCaseCode(String caseCode) {
        /*  75 */
        this.caseCode = caseCode;

    }


    public String getEnforceCourt() {
        /*  79 */
        return this.enforceCourt;

    }


    public void setEnforceCourt(String enforceCourt) {
        /*  82 */
        this.enforceCourt = enforceCourt;

    }


    public String getIdNumber() {
        /*  86 */
        return this.idNumber;

    }


    public void setIdNumber(String idNumber) {
        /*  89 */
        this.idNumber = idNumber;

    }


    public String getName() {
        /*  93 */
        return this.name;

    }


    public void setName(String name) {
        /*  96 */
        this.name = name;

    }


    public String getPerformance() {
        /* 100 */
        return this.performance;

    }


    public void setPerformance(String performance) {
        /* 103 */
        this.performance = performance;

    }


    public String getPublishDate() {
        /* 107 */
        return this.publishDate;

    }


    public void setPublishDate(String publishDate) {
        /* 110 */
        this.publishDate = publishDate;

    }


    public String getRegion() {
        /* 114 */
        return this.region;

    }


    public void setRegion(String region) {
        /* 117 */
        this.region = region;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.DishonestyDetailInfo
 * JD-Core Version:    0.6.0
 */