package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayPassTplContentAddResponse;

import java.util.Map;


public class AlipayPassTplContentAddRequest implements AlipayRequest<AlipayPassTplContentAddResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String recognitionInfo;
    private String recognitionType;
    private String tplId;
    private String tplParams;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /*  75 */   private boolean needEncrypt = false;


    public String getRecognitionInfo() {
        /*  47 */
        return this.recognitionInfo;

    }


    public void setRecognitionInfo(String recognitionInfo) {
        /*  44 */
        this.recognitionInfo = recognitionInfo;

    }


    public String getRecognitionType() {
        /*  54 */
        return this.recognitionType;

    }


    public void setRecognitionType(String recognitionType) {
        /*  51 */
        this.recognitionType = recognitionType;

    }


    public String getTplId() {
        /*  61 */
        return this.tplId;

    }


    public void setTplId(String tplId) {
        /*  58 */
        this.tplId = tplId;

    }


    public String getTplParams() {
        /*  68 */
        return this.tplParams;

    }


    public void setTplParams(String tplParams) {
        /*  65 */
        this.tplParams = tplParams;

    }


    public String getNotifyUrl() {
        /*  78 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /*  82 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /*  86 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /*  90 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /*  94 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /*  98 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /* 106 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /* 102 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /* 114 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /* 110 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /* 122 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 118 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 126 */
        return "alipay.pass.tpl.content.add";

    }


    public Map<String, String> getTextParams() {
        /* 130 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 131 */
        txtParams.put("recognition_info", this.recognitionInfo);
        /* 132 */
        txtParams.put("recognition_type", this.recognitionType);
        /* 133 */
        txtParams.put("tpl_id", this.tplId);
        /* 134 */
        txtParams.put("tpl_params", this.tplParams);
        /* 135 */
        if (this.udfParams != null) {
            /* 136 */
            txtParams.putAll(this.udfParams);

        }
        /* 138 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 142 */
        if (this.udfParams == null) {
            /* 143 */
            this.udfParams = new AlipayHashMap();

        }
        /* 145 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayPassTplContentAddResponse> getResponseClass() {
        /* 149 */
        return AlipayPassTplContentAddResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 155 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 161 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayPassTplContentAddRequest
 * JD-Core Version:    0.6.0
 */