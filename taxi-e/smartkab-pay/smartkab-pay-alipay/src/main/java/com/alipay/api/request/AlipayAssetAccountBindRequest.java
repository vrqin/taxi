package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayAssetAccountBindResponse;

import java.util.Map;


public class AlipayAssetAccountBindRequest implements AlipayRequest<AlipayAssetAccountBindResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String bindScene;
    private String providerId;
    private String providerUserId;
    private String providerUserName;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /*  76 */   private boolean needEncrypt = false;


    public String getBindScene() {
        /*  48 */
        return this.bindScene;

    }


    public void setBindScene(String bindScene) {
        /*  45 */
        this.bindScene = bindScene;

    }


    public String getProviderId() {
        /*  55 */
        return this.providerId;

    }


    public void setProviderId(String providerId) {
        /*  52 */
        this.providerId = providerId;

    }


    public String getProviderUserId() {
        /*  62 */
        return this.providerUserId;

    }


    public void setProviderUserId(String providerUserId) {
        /*  59 */
        this.providerUserId = providerUserId;

    }


    public String getProviderUserName() {
        /*  69 */
        return this.providerUserName;

    }


    public void setProviderUserName(String providerUserName) {
        /*  66 */
        this.providerUserName = providerUserName;

    }


    public String getNotifyUrl() {
        /*  79 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /*  83 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /*  87 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /*  91 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /*  95 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /*  99 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /* 107 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /* 103 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /* 115 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /* 111 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /* 123 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 119 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 127 */
        return "alipay.asset.account.bind";

    }


    public Map<String, String> getTextParams() {
        /* 131 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 132 */
        txtParams.put("bind_scene", this.bindScene);
        /* 133 */
        txtParams.put("provider_id", this.providerId);
        /* 134 */
        txtParams.put("provider_user_id", this.providerUserId);
        /* 135 */
        txtParams.put("provider_user_name", this.providerUserName);
        /* 136 */
        if (this.udfParams != null) {
            /* 137 */
            txtParams.putAll(this.udfParams);

        }
        /* 139 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 143 */
        if (this.udfParams == null) {
            /* 144 */
            this.udfParams = new AlipayHashMap();

        }
        /* 146 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayAssetAccountBindResponse> getResponseClass() {
        /* 150 */
        return AlipayAssetAccountBindResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 156 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 162 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayAssetAccountBindRequest
 * JD-Core Version:    0.6.0
 */