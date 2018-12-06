package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayPassCodeAddResponse;

import java.util.List;
import java.util.Map;


public class AlipayPassCodeAddRequest implements AlipayRequest<AlipayPassCodeAddResponse> {
    private AlipayHashMap udfParams;
    /*  19 */   private String apiVersion = "1.0";
    private String fileContent;
    private String recognitionInfo;
    private String recognitionType;
    private List<String> verifyType;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /*  77 */   private boolean needEncrypt = false;


    public String getFileContent() {
        /*  49 */
        return this.fileContent;

    }


    public void setFileContent(String fileContent) {
        /*  46 */
        this.fileContent = fileContent;

    }


    public String getRecognitionInfo() {
        /*  56 */
        return this.recognitionInfo;

    }


    public void setRecognitionInfo(String recognitionInfo) {
        /*  53 */
        this.recognitionInfo = recognitionInfo;

    }


    public String getRecognitionType() {
        /*  63 */
        return this.recognitionType;

    }


    public void setRecognitionType(String recognitionType) {
        /*  60 */
        this.recognitionType = recognitionType;

    }


    public List<String> getVerifyType() {
        /*  70 */
        return this.verifyType;

    }


    public void setVerifyType(List<String> verifyType) {
        /*  67 */
        this.verifyType = verifyType;

    }


    public String getNotifyUrl() {
        /*  80 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /*  84 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /*  88 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /*  92 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /*  96 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /* 100 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /* 108 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /* 104 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /* 116 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /* 112 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /* 124 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 120 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 128 */
        return "alipay.pass.code.add";

    }


    public Map<String, String> getTextParams() {
        /* 132 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 133 */
        txtParams.put("file_content", this.fileContent);
        /* 134 */
        txtParams.put("recognition_info", this.recognitionInfo);
        /* 135 */
        txtParams.put("recognition_type", this.recognitionType);
        /* 136 */
        txtParams.put("verify_type", this.verifyType);
        /* 137 */
        if (this.udfParams != null) {
            /* 138 */
            txtParams.putAll(this.udfParams);

        }
        /* 140 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 144 */
        if (this.udfParams == null) {
            /* 145 */
            this.udfParams = new AlipayHashMap();

        }
        /* 147 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayPassCodeAddResponse> getResponseClass() {
        /* 151 */
        return AlipayPassCodeAddResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 157 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 163 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayPassCodeAddRequest
 * JD-Core Version:    0.6.0
 */