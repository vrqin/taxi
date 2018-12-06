package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayTradePayResponse;

import java.util.Map;


public class AlipayTradePayRequest implements AlipayRequest<AlipayTradePayResponse> {
    private AlipayHashMap udfParams;
    /*  19 */   private String apiVersion = "1.0";
    private String bizContent;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /*  38 */   private boolean needEncrypt = false;


    public String getBizContent() {
        /*  31 */
        return this.bizContent;

    }


    public void setBizContent(String bizContent) {
        /*  28 */
        this.bizContent = bizContent;

    }


    public String getNotifyUrl() {
        /*  41 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /*  45 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /*  49 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /*  53 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /*  57 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /*  61 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /*  69 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /*  65 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /*  77 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /*  73 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /*  85 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /*  81 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /*  89 */
        return "alipay.trade.pay";

    }


    public Map<String, String> getTextParams() {
        /*  93 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /*  94 */
        txtParams.put("biz_content", this.bizContent);
        /*  95 */
        if (this.udfParams != null) {
            /*  96 */
            txtParams.putAll(this.udfParams);

        }
        /*  98 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 102 */
        if (this.udfParams == null) {
            /* 103 */
            this.udfParams = new AlipayHashMap();

        }
        /* 105 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayTradePayResponse> getResponseClass() {
        /* 109 */
        return AlipayTradePayResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 115 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 121 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayTradePayRequest
 * JD-Core Version:    0.6.0
 */