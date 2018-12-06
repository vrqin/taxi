package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipaySiteprobeDeviceInfoSearchResponse;

import java.util.Map;


public class AlipaySiteprobeDeviceInfoSearchRequest implements AlipayRequest<AlipaySiteprobeDeviceInfoSearchResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String bizContent;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /*  39 */   private boolean needEncrypt = false;


    public String getBizContent() {
        /*  32 */
        return this.bizContent;

    }


    public void setBizContent(String bizContent) {
        /*  29 */
        this.bizContent = bizContent;

    }


    public String getNotifyUrl() {
        /*  42 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /*  46 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /*  50 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /*  54 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /*  58 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /*  62 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /*  70 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /*  66 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /*  78 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /*  74 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /*  86 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /*  82 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /*  90 */
        return "alipay.siteprobe.device.info.search";

    }


    public Map<String, String> getTextParams() {
        /*  94 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /*  95 */
        txtParams.put("biz_content", this.bizContent);
        /*  96 */
        if (this.udfParams != null) {
            /*  97 */
            txtParams.putAll(this.udfParams);

        }
        /*  99 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 103 */
        if (this.udfParams == null) {
            /* 104 */
            this.udfParams = new AlipayHashMap();

        }
        /* 106 */
        this.udfParams.put(key, value);

    }


    public Class<AlipaySiteprobeDeviceInfoSearchResponse> getResponseClass() {
        /* 110 */
        return AlipaySiteprobeDeviceInfoSearchResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 116 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 122 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipaySiteprobeDeviceInfoSearchRequest
 * JD-Core Version:    0.6.0
 */