package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipaySiteprobeDeviceInfoAddResponse;

import java.util.Map;


public class AlipaySiteprobeDeviceInfoAddRequest implements AlipayRequest<AlipaySiteprobeDeviceInfoAddResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String bizContent;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /*  43 */   private boolean needEncrypt = false;


    public String getBizContent() {
        /*  36 */
        return this.bizContent;

    }


    public void setBizContent(String bizContent) {
        /*  33 */
        this.bizContent = bizContent;

    }


    public String getNotifyUrl() {
        /*  46 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /*  50 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /*  54 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /*  58 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /*  62 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /*  66 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /*  74 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /*  70 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /*  82 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /*  78 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /*  90 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /*  86 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /*  94 */
        return "alipay.siteprobe.device.info.add";

    }


    public Map<String, String> getTextParams() {
        /*  98 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /*  99 */
        txtParams.put("biz_content", this.bizContent);
        /* 100 */
        if (this.udfParams != null) {
            /* 101 */
            txtParams.putAll(this.udfParams);

        }
        /* 103 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 107 */
        if (this.udfParams == null) {
            /* 108 */
            this.udfParams = new AlipayHashMap();

        }
        /* 110 */
        this.udfParams.put(key, value);

    }


    public Class<AlipaySiteprobeDeviceInfoAddResponse> getResponseClass() {
        /* 114 */
        return AlipaySiteprobeDeviceInfoAddResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 120 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 126 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipaySiteprobeDeviceInfoAddRequest
 * JD-Core Version:    0.6.0
 */