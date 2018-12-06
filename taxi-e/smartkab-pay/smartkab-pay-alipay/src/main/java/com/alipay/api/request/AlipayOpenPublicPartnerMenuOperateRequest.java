package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayOpenPublicPartnerMenuOperateResponse;

import java.util.Map;


public class AlipayOpenPublicPartnerMenuOperateRequest implements AlipayRequest<AlipayOpenPublicPartnerMenuOperateResponse> {
    private AlipayHashMap udfParams;
    /*  19 */   private String apiVersion = "1.0";
    private String bizContent;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /*  37 */   private boolean needEncrypt = false;


    public String getBizContent() {
        /*  30 */
        return this.bizContent;

    }


    public void setBizContent(String bizContent) {
        /*  27 */
        this.bizContent = bizContent;

    }


    public String getNotifyUrl() {
        /*  40 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /*  44 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /*  48 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /*  52 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /*  56 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /*  60 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /*  68 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /*  64 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /*  76 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /*  72 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /*  84 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /*  80 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /*  88 */
        return "alipay.open.public.partner.menu.operate";

    }


    public Map<String, String> getTextParams() {
        /*  92 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /*  93 */
        txtParams.put("biz_content", this.bizContent);
        /*  94 */
        if (this.udfParams != null) {
            /*  95 */
            txtParams.putAll(this.udfParams);

        }
        /*  97 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 101 */
        if (this.udfParams == null) {
            /* 102 */
            this.udfParams = new AlipayHashMap();

        }
        /* 104 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayOpenPublicPartnerMenuOperateResponse> getResponseClass() {
        /* 108 */
        return AlipayOpenPublicPartnerMenuOperateResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 114 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 120 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayOpenPublicPartnerMenuOperateRequest
 * JD-Core Version:    0.6.0
 */