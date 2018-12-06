package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayMobileShakeUserQueryResponse;

import java.util.Map;


public class AlipayMobileShakeUserQueryRequest implements AlipayRequest<AlipayMobileShakeUserQueryResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String dynamicId;
    private String dynamicIdType;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /*  51 */   private boolean needEncrypt = false;


    public String getDynamicId() {
        /*  37 */
        return this.dynamicId;

    }


    public void setDynamicId(String dynamicId) {
        /*  34 */
        this.dynamicId = dynamicId;

    }


    public String getDynamicIdType() {
        /*  44 */
        return this.dynamicIdType;

    }


    public void setDynamicIdType(String dynamicIdType) {
        /*  41 */
        this.dynamicIdType = dynamicIdType;

    }


    public String getNotifyUrl() {
        /*  54 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /*  58 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /*  62 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /*  66 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /*  70 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /*  74 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /*  82 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /*  78 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /*  90 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /*  86 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /*  98 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /*  94 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 102 */
        return "alipay.mobile.shake.user.query";

    }


    public Map<String, String> getTextParams() {
        /* 106 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 107 */
        txtParams.put("dynamic_id", this.dynamicId);
        /* 108 */
        txtParams.put("dynamic_id_type", this.dynamicIdType);
        /* 109 */
        if (this.udfParams != null) {
            /* 110 */
            txtParams.putAll(this.udfParams);

        }
        /* 112 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 116 */
        if (this.udfParams == null) {
            /* 117 */
            this.udfParams = new AlipayHashMap();

        }
        /* 119 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayMobileShakeUserQueryResponse> getResponseClass() {
        /* 123 */
        return AlipayMobileShakeUserQueryResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 129 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 135 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayMobileShakeUserQueryRequest
 * JD-Core Version:    0.6.0
 */