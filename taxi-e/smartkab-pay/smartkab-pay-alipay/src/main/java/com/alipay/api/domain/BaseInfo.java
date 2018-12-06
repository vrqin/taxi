package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;


public class BaseInfo extends AlipayObject {
    private static final long serialVersionUID = 1311244956933479358L;


    @ApiField("app_name")
    private String appName;


    @ApiListField("contact_info")

    @ApiField("contact_person_info")
    private List<ContactPersonInfo> contactInfo;


    @ApiField("logo_pic")
    private String logoPic;


    @ApiField("mcc_code")
    private String mccCode;


    @ApiListField("special_license_pic")

    @ApiField("string")
    private List<String> specialLicensePic;


    @ApiListField("web_address")

    @ApiField("string")
    private List<String> webAddress;


    @ApiField("web_auth_pic")
    private String webAuthPic;


    public String getAppName() {
        /*  69 */
        return this.appName;

    }


    public void setAppName(String appName) {
        /*  72 */
        this.appName = appName;

    }


    public List<ContactPersonInfo> getContactInfo() {
        /*  76 */
        return this.contactInfo;

    }


    public void setContactInfo(List<ContactPersonInfo> contactInfo) {
        /*  79 */
        this.contactInfo = contactInfo;

    }


    public String getLogoPic() {
        /*  83 */
        return this.logoPic;

    }


    public void setLogoPic(String logoPic) {
        /*  86 */
        this.logoPic = logoPic;

    }


    public String getMccCode() {
        /*  90 */
        return this.mccCode;

    }


    public void setMccCode(String mccCode) {
        /*  93 */
        this.mccCode = mccCode;

    }


    public List<String> getSpecialLicensePic() {
        /*  97 */
        return this.specialLicensePic;

    }


    public void setSpecialLicensePic(List<String> specialLicensePic) {
        /* 100 */
        this.specialLicensePic = specialLicensePic;

    }


    public List<String> getWebAddress() {
        /* 104 */
        return this.webAddress;

    }


    public void setWebAddress(List<String> webAddress) {
        /* 107 */
        this.webAddress = webAddress;

    }


    public String getWebAuthPic() {
        /* 111 */
        return this.webAuthPic;

    }


    public void setWebAuthPic(String webAuthPic) {
        /* 114 */
        this.webAuthPic = webAuthPic;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.BaseInfo
 * JD-Core Version:    0.6.0
 */