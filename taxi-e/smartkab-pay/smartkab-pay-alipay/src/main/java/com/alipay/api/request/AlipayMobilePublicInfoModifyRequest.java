package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayMobilePublicInfoModifyResponse;

import java.util.Map;


public class AlipayMobilePublicInfoModifyRequest implements AlipayRequest<AlipayMobilePublicInfoModifyResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String appName;
    private String authPic;
    private String licenseUrl;
    private String logoUrl;
    private String publicGreeting;
    private String shopPic1;
    private String shopPic2;
    private String shopPic3;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /* 120 */   private boolean needEncrypt = false;


    public String getAppName() {
        /*  64 */
        return this.appName;

    }


    public void setAppName(String appName) {
        /*  61 */
        this.appName = appName;

    }


    public String getAuthPic() {
        /*  71 */
        return this.authPic;

    }


    public void setAuthPic(String authPic) {
        /*  68 */
        this.authPic = authPic;

    }


    public String getLicenseUrl() {
        /*  78 */
        return this.licenseUrl;

    }


    public void setLicenseUrl(String licenseUrl) {
        /*  75 */
        this.licenseUrl = licenseUrl;

    }


    public String getLogoUrl() {
        /*  85 */
        return this.logoUrl;

    }


    public void setLogoUrl(String logoUrl) {
        /*  82 */
        this.logoUrl = logoUrl;

    }


    public String getPublicGreeting() {
        /*  92 */
        return this.publicGreeting;

    }


    public void setPublicGreeting(String publicGreeting) {
        /*  89 */
        this.publicGreeting = publicGreeting;

    }


    public String getShopPic1() {
        /*  99 */
        return this.shopPic1;

    }


    public void setShopPic1(String shopPic1) {
        /*  96 */
        this.shopPic1 = shopPic1;

    }


    public String getShopPic2() {
        /* 106 */
        return this.shopPic2;

    }


    public void setShopPic2(String shopPic2) {
        /* 103 */
        this.shopPic2 = shopPic2;

    }


    public String getShopPic3() {
        /* 113 */
        return this.shopPic3;

    }


    public void setShopPic3(String shopPic3) {
        /* 110 */
        this.shopPic3 = shopPic3;

    }


    public String getNotifyUrl() {
        /* 123 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /* 127 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /* 131 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /* 135 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /* 139 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /* 143 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /* 151 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /* 147 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /* 159 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /* 155 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /* 167 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 163 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 171 */
        return "alipay.mobile.public.info.modify";

    }


    public Map<String, String> getTextParams() {
        /* 175 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 176 */
        txtParams.put("app_name", this.appName);
        /* 177 */
        txtParams.put("auth_pic", this.authPic);
        /* 178 */
        txtParams.put("license_url", this.licenseUrl);
        /* 179 */
        txtParams.put("logo_url", this.logoUrl);
        /* 180 */
        txtParams.put("public_greeting", this.publicGreeting);
        /* 181 */
        txtParams.put("shop_pic1", this.shopPic1);
        /* 182 */
        txtParams.put("shop_pic2", this.shopPic2);
        /* 183 */
        txtParams.put("shop_pic3", this.shopPic3);
        /* 184 */
        if (this.udfParams != null) {
            /* 185 */
            txtParams.putAll(this.udfParams);

        }
        /* 187 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 191 */
        if (this.udfParams == null) {
            /* 192 */
            this.udfParams = new AlipayHashMap();

        }
        /* 194 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayMobilePublicInfoModifyResponse> getResponseClass() {
        /* 198 */
        return AlipayMobilePublicInfoModifyResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 204 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 210 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayMobilePublicInfoModifyRequest
 * JD-Core Version:    0.6.0
 */