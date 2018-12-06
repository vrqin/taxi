package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayPassFileAddResponse;

import java.util.Map;


public class AlipayPassFileAddRequest implements AlipayRequest<AlipayPassFileAddResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String fileContent;
    private String recognitionInfo;
    private String recognitionType;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /*  63 */   private boolean needEncrypt = false;


    public String getFileContent() {
        /*  42 */
        return this.fileContent;

    }


    public void setFileContent(String fileContent) {
        /*  39 */
        this.fileContent = fileContent;

    }


    public String getRecognitionInfo() {
        /*  49 */
        return this.recognitionInfo;

    }


    public void setRecognitionInfo(String recognitionInfo) {
        /*  46 */
        this.recognitionInfo = recognitionInfo;

    }


    public String getRecognitionType() {
        /*  56 */
        return this.recognitionType;

    }


    public void setRecognitionType(String recognitionType) {
        /*  53 */
        this.recognitionType = recognitionType;

    }


    public String getNotifyUrl() {
        /*  66 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /*  70 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /*  74 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /*  78 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /*  82 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /*  86 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /*  94 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /*  90 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /* 102 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /*  98 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /* 110 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 106 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 114 */
        return "alipay.pass.file.add";

    }


    public Map<String, String> getTextParams() {
        /* 118 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 119 */
        txtParams.put("file_content", this.fileContent);
        /* 120 */
        txtParams.put("recognition_info", this.recognitionInfo);
        /* 121 */
        txtParams.put("recognition_type", this.recognitionType);
        /* 122 */
        if (this.udfParams != null) {
            /* 123 */
            txtParams.putAll(this.udfParams);

        }
        /* 125 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 129 */
        if (this.udfParams == null) {
            /* 130 */
            this.udfParams = new AlipayHashMap();

        }
        /* 132 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayPassFileAddResponse> getResponseClass() {
        /* 136 */
        return AlipayPassFileAddResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 142 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 148 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayPassFileAddRequest
 * JD-Core Version:    0.6.0
 */