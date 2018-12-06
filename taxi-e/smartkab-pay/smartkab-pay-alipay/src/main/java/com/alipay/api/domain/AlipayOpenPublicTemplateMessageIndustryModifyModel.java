package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayOpenPublicTemplateMessageIndustryModifyModel extends AlipayObject {
    private static final long serialVersionUID = 8858856788296838143L;


    @ApiField("primary_industry_code")
    private String primaryIndustryCode;


    @ApiField("primary_industry_name")
    private String primaryIndustryName;


    @ApiField("secondary_industry_code")
    private String secondaryIndustryCode;


    @ApiField("secondary_industry_name")
    private String secondaryIndustryName;


    public String getPrimaryIndustryCode() {
        /*  83 */
        return this.primaryIndustryCode;

    }


    public void setPrimaryIndustryCode(String primaryIndustryCode) {
        /*  86 */
        this.primaryIndustryCode = primaryIndustryCode;

    }


    public String getPrimaryIndustryName() {
        /*  90 */
        return this.primaryIndustryName;

    }


    public void setPrimaryIndustryName(String primaryIndustryName) {
        /*  93 */
        this.primaryIndustryName = primaryIndustryName;

    }


    public String getSecondaryIndustryCode() {
        /*  97 */
        return this.secondaryIndustryCode;

    }


    public void setSecondaryIndustryCode(String secondaryIndustryCode) {
        /* 100 */
        this.secondaryIndustryCode = secondaryIndustryCode;

    }


    public String getSecondaryIndustryName() {
        /* 104 */
        return this.secondaryIndustryName;

    }


    public void setSecondaryIndustryName(String secondaryIndustryName) {
        /* 107 */
        this.secondaryIndustryName = secondaryIndustryName;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOpenPublicTemplateMessageIndustryModifyModel
 * JD-Core Version:    0.6.0
 */