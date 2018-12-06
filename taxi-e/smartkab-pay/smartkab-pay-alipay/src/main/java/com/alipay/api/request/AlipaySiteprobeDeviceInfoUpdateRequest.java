package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipaySiteprobeDeviceInfoUpdateResponse;

import java.util.Map;


public class AlipaySiteprobeDeviceInfoUpdateRequest implements AlipayRequest<AlipaySiteprobeDeviceInfoUpdateResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String bizContent;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /*  44 */   private boolean needEncrypt = false;


    public String getBizContent() {
        /*  37 */
        return this.bizContent;

    }


    public void setBizContent(String bizContent) {
        /*  34 */
        this.bizContent = bizContent;

    }


    public String getNotifyUrl() {
        /*  47 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /*  51 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /*  55 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /*  59 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /*  63 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /*  67 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /*  75 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /*  71 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /*  83 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /*  79 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /*  91 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /*  87 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /*  95 */
        return "alipay.siteprobe.device.info.update";

    }


    public Map<String, String> getTextParams() {
        /*  99 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 100 */
        txtParams.put("biz_content", this.bizContent);
        /* 101 */
        if (this.udfParams != null) {
            /* 102 */
            txtParams.putAll(this.udfParams);

        }
        /* 104 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 108 */
        if (this.udfParams == null) {
            /* 109 */
            this.udfParams = new AlipayHashMap();

        }
        /* 111 */
        this.udfParams.put(key, value);

    }


    public Class<AlipaySiteprobeDeviceInfoUpdateResponse> getResponseClass() {
        /* 115 */
        return AlipaySiteprobeDeviceInfoUpdateResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 121 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 127 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipaySiteprobeDeviceInfoUpdateRequest
 * JD-Core Version:    0.6.0
 */