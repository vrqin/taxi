package com.alipay.api;


import com.alipay.api.internal.util.AlipayHashMap;

import java.io.OutputStream;
import java.util.Map;


public class AlipayMobilePublicMultiMediaDownloadRequest implements AlipayRequest<AlipayMobilePublicMultiMediaDownloadResponse> {
    private AlipayHashMap udfParams;
    /*  21 */   private String apiVersion = "1.0";
    private String notifyUrl;
    private OutputStream outputStream;
    private String bizContent;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;


    public String getBizContent() {
        /*  34 */
        return this.bizContent;

    }


    public void setBizContent(String bizContent) {
        /*  30 */
        this.bizContent = bizContent;

    }


    public String getApiVersion() {
        /*  42 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /*  46 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /*  54 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /*  50 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /*  62 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /*  58 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /*  70 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /*  66 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /*  74 */
        return "alipay.mobile.public.multimedia.download";

    }


    public Map<String, String> getTextParams() {
        /*  78 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /*  79 */
        txtParams.put("biz_content", this.bizContent);
        /*  80 */
        if (this.udfParams != null) {
            /*  81 */
            txtParams.putAll(this.udfParams);

        }
        /*  83 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /*  87 */
        if (this.udfParams == null) {
            /*  88 */
            this.udfParams = new AlipayHashMap();

        }
        /*  90 */
        this.udfParams.put(key, value);

    }


    public OutputStream getOutputStream() {
        /*  99 */
        return this.outputStream;

    }


    public void setOutputStream(OutputStream outputStream) {
        /* 108 */
        this.outputStream = outputStream;

    }


    public String getNotifyUrl() {
        /* 117 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /* 126 */
        this.notifyUrl = notifyUrl;

    }


    public Class<AlipayMobilePublicMultiMediaDownloadResponse> getResponseClass() {
        /* 130 */
        return AlipayMobilePublicMultiMediaDownloadResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 137 */
        return false;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 145 */
        throw new RuntimeException("当前请求不支持加密！");

    }


    public String getReturnUrl() {
        /* 149 */
        return null;

    }


    public void setReturnUrl(String returnUrl) {

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.AlipayMobilePublicMultiMediaDownloadRequest
 * JD-Core Version:    0.6.0
 */