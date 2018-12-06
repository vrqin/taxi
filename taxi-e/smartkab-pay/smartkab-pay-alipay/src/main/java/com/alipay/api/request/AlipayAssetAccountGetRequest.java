package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayAssetAccountGetResponse;

import java.util.Map;


public class AlipayAssetAccountGetRequest implements AlipayRequest<AlipayAssetAccountGetResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String providerId;
    private String providerUserId;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /*  49 */   private boolean needEncrypt = false;


    public String getProviderId() {
        /*  35 */
        return this.providerId;

    }


    public void setProviderId(String providerId) {
        /*  32 */
        this.providerId = providerId;

    }


    public String getProviderUserId() {
        /*  42 */
        return this.providerUserId;

    }


    public void setProviderUserId(String providerUserId) {
        /*  39 */
        this.providerUserId = providerUserId;

    }


    public String getNotifyUrl() {
        /*  52 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /*  56 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /*  60 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /*  64 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /*  68 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /*  72 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /*  80 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /*  76 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /*  88 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /*  84 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /*  96 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /*  92 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 100 */
        return "alipay.asset.account.get";

    }


    public Map<String, String> getTextParams() {
        /* 104 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 105 */
        txtParams.put("provider_id", this.providerId);
        /* 106 */
        txtParams.put("provider_user_id", this.providerUserId);
        /* 107 */
        if (this.udfParams != null) {
            /* 108 */
            txtParams.putAll(this.udfParams);

        }
        /* 110 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 114 */
        if (this.udfParams == null) {
            /* 115 */
            this.udfParams = new AlipayHashMap();

        }
        /* 117 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayAssetAccountGetResponse> getResponseClass() {
        /* 121 */
        return AlipayAssetAccountGetResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 127 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 133 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayAssetAccountGetRequest
 * JD-Core Version:    0.6.0
 */