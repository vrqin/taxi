package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayPassCodeVerifyResponse;

import java.util.Map;


public class AlipayPassCodeVerifyRequest implements AlipayRequest<AlipayPassCodeVerifyResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String extInfo;
    private String operatorId;
    private String operatorType;
    private String verifyCode;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /*  76 */   private boolean needEncrypt = false;


    public String getExtInfo() {
        /*  48 */
        return this.extInfo;

    }


    public void setExtInfo(String extInfo) {
        /*  45 */
        this.extInfo = extInfo;

    }


    public String getOperatorId() {
        /*  55 */
        return this.operatorId;

    }


    public void setOperatorId(String operatorId) {
        /*  52 */
        this.operatorId = operatorId;

    }


    public String getOperatorType() {
        /*  62 */
        return this.operatorType;

    }


    public void setOperatorType(String operatorType) {
        /*  59 */
        this.operatorType = operatorType;

    }


    public String getVerifyCode() {
        /*  69 */
        return this.verifyCode;

    }


    public void setVerifyCode(String verifyCode) {
        /*  66 */
        this.verifyCode = verifyCode;

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
        return "alipay.pass.code.verify";

    }


    public Map<String, String> getTextParams() {
        /* 131 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 132 */
        txtParams.put("ext_info", this.extInfo);
        /* 133 */
        txtParams.put("operator_id", this.operatorId);
        /* 134 */
        txtParams.put("operator_type", this.operatorType);
        /* 135 */
        txtParams.put("verify_code", this.verifyCode);
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


    public Class<AlipayPassCodeVerifyResponse> getResponseClass() {
        /* 150 */
        return AlipayPassCodeVerifyResponse.class;

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
 * Qualified Name:     com.alipay.api.request.AlipayPassCodeVerifyRequest
 * JD-Core Version:    0.6.0
 */