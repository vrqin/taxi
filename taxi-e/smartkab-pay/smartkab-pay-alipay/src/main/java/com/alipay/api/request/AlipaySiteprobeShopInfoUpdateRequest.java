package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipaySiteprobeShopInfoUpdateResponse;

import java.util.Map;


public class AlipaySiteprobeShopInfoUpdateRequest implements AlipayRequest<AlipaySiteprobeShopInfoUpdateResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String bizContent;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /*  40 */   private boolean needEncrypt = false;


    public String getBizContent() {
        /*  33 */
        return this.bizContent;

    }


    public void setBizContent(String bizContent) {
        /*  30 */
        this.bizContent = bizContent;

    }


    public String getNotifyUrl() {
        /*  43 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /*  47 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /*  51 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /*  55 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /*  59 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /*  63 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /*  71 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /*  67 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /*  79 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /*  75 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /*  87 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /*  83 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /*  91 */
        return "alipay.siteprobe.shop.info.update";

    }


    public Map<String, String> getTextParams() {
        /*  95 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /*  96 */
        txtParams.put("biz_content", this.bizContent);
        /*  97 */
        if (this.udfParams != null) {
            /*  98 */
            txtParams.putAll(this.udfParams);

        }
        /* 100 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 104 */
        if (this.udfParams == null) {
            /* 105 */
            this.udfParams = new AlipayHashMap();

        }
        /* 107 */
        this.udfParams.put(key, value);

    }


    public Class<AlipaySiteprobeShopInfoUpdateResponse> getResponseClass() {
        /* 111 */
        return AlipaySiteprobeShopInfoUpdateResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 117 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 123 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipaySiteprobeShopInfoUpdateRequest
 * JD-Core Version:    0.6.0
 */