package com.alipay.api.response;


import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayMobilePublicInfoQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 8263896624827366667L;


    @ApiField("app_name")
    private String appName;


    @ApiField("audit_desc")
    private String auditDesc;


    @ApiField("audit_status")
    private String auditStatus;


    @ApiField("is_online")
    private String isOnline;


    @ApiField("is_release")
    private String isRelease;


    @ApiField("logo_url")
    private String logoUrl;


    @ApiField("public_greeting")
    private String publicGreeting;


    public String getAppName() {
        /*  63 */
        return this.appName;

    }


    public void setAppName(String appName) {
        /*  60 */
        this.appName = appName;

    }


    public String getAuditDesc() {
        /*  70 */
        return this.auditDesc;

    }


    public void setAuditDesc(String auditDesc) {
        /*  67 */
        this.auditDesc = auditDesc;

    }


    public String getAuditStatus() {
        /*  77 */
        return this.auditStatus;

    }


    public void setAuditStatus(String auditStatus) {
        /*  74 */
        this.auditStatus = auditStatus;

    }


    public String getIsOnline() {
        /*  84 */
        return this.isOnline;

    }


    public void setIsOnline(String isOnline) {
        /*  81 */
        this.isOnline = isOnline;

    }


    public String getIsRelease() {
        /*  91 */
        return this.isRelease;

    }


    public void setIsRelease(String isRelease) {
        /*  88 */
        this.isRelease = isRelease;

    }


    public String getLogoUrl() {
        /*  98 */
        return this.logoUrl;

    }


    public void setLogoUrl(String logoUrl) {
        /*  95 */
        this.logoUrl = logoUrl;

    }


    public String getPublicGreeting() {
        /* 105 */
        return this.publicGreeting;

    }


    public void setPublicGreeting(String publicGreeting) {
        /* 102 */
        this.publicGreeting = publicGreeting;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMobilePublicInfoQueryResponse
 * JD-Core Version:    0.6.0
 */