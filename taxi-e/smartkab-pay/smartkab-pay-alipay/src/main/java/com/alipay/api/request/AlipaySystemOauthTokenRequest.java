package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;

import java.util.Map;


public class AlipaySystemOauthTokenRequest implements AlipayRequest<AlipaySystemOauthTokenResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String code;
    private String grantType;
    private String refreshToken;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /*  60 */   private boolean needEncrypt = false;


    public String getCode() {
        /*  39 */
        return this.code;

    }


    public void setCode(String code) {
        /*  36 */
        this.code = code;

    }


    public String getGrantType() {
        /*  46 */
        return this.grantType;

    }


    public void setGrantType(String grantType) {
        /*  43 */
        this.grantType = grantType;

    }


    public String getRefreshToken() {
        /*  53 */
        return this.refreshToken;

    }


    public void setRefreshToken(String refreshToken) {
        /*  50 */
        this.refreshToken = refreshToken;

    }


    public String getNotifyUrl() {
        /*  63 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /*  67 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /*  71 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /*  75 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /*  79 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /*  83 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /*  91 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /*  87 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /*  99 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /*  95 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /* 107 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 103 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 111 */
        return "alipay.system.oauth.token";

    }


    public Map<String, String> getTextParams() {
        /* 115 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 116 */
        txtParams.put("code", this.code);
        /* 117 */
        txtParams.put("grant_type", this.grantType);
        /* 118 */
        txtParams.put("refresh_token", this.refreshToken);
        /* 119 */
        if (this.udfParams != null) {
            /* 120 */
            txtParams.putAll(this.udfParams);

        }
        /* 122 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 126 */
        if (this.udfParams == null) {
            /* 127 */
            this.udfParams = new AlipayHashMap();

        }
        /* 129 */
        this.udfParams.put(key, value);

    }


    public Class<AlipaySystemOauthTokenResponse> getResponseClass() {
        /* 133 */
        return AlipaySystemOauthTokenResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 139 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 145 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipaySystemOauthTokenRequest
 * JD-Core Version:    0.6.0
 */