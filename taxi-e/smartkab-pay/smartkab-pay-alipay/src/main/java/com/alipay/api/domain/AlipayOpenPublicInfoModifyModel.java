package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayOpenPublicInfoModifyModel extends AlipayObject {
    private static final long serialVersionUID = 1769393431944845615L;

    @ApiField("app_name")
    private String appName;

    @ApiField("auth_pic")
    private String authPic;

    @ApiField("license_url")
    private String licenseUrl;

    @ApiField("logo_url")
    private String logoUrl;

    @ApiField("public_greeting")
    private String publicGreeting;

    @ApiListField("shop_pics")
    @ApiField("string")
    private List<String> shopPics;

    public String getAppName() {
        /* 57 */
        return this.appName;
    }

    public void setAppName(String appName) {
        /* 60 */
        this.appName = appName;
    }

    public String getAuthPic() {
        /* 64 */
        return this.authPic;
    }

    public void setAuthPic(String authPic) {
        /* 67 */
        this.authPic = authPic;
    }

    public String getLicenseUrl() {
        /* 71 */
        return this.licenseUrl;
    }

    public void setLicenseUrl(String licenseUrl) {
        /* 74 */
        this.licenseUrl = licenseUrl;
    }

    public String getLogoUrl() {
        /* 78 */
        return this.logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        /* 81 */
        this.logoUrl = logoUrl;
    }

    public String getPublicGreeting() {
        /* 85 */
        return this.publicGreeting;
    }

    public void setPublicGreeting(String publicGreeting) {
        /* 88 */
        this.publicGreeting = publicGreeting;
    }

    public List<String> getShopPics() {
        /* 92 */
        return this.shopPics;
    }

    public void setShopPics(List<String> shopPics) {
        /* 95 */
        this.shopPics = shopPics;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOpenPublicInfoModifyModel
 * JD-Core Version:    0.6.0
 */