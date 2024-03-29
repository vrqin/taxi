package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayUserContractGetResponse;

import java.util.Map;


public class AlipayUserContractGetRequest implements AlipayRequest<AlipayUserContractGetResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String subscriberUserId;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /*  36 */   private boolean needEncrypt = false;


    public String getSubscriberUserId() {
        /*  29 */
        return this.subscriberUserId;

    }


    public void setSubscriberUserId(String subscriberUserId) {
        /*  26 */
        this.subscriberUserId = subscriberUserId;

    }


    public String getNotifyUrl() {
        /*  39 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /*  43 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /*  47 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /*  51 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /*  55 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /*  59 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /*  67 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /*  63 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /*  75 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /*  71 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /*  83 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /*  79 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /*  87 */
        return "alipay.user.contract.get";

    }


    public Map<String, String> getTextParams() {
        /*  91 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /*  92 */
        txtParams.put("subscriber_user_id", this.subscriberUserId);
        /*  93 */
        if (this.udfParams != null) {
            /*  94 */
            txtParams.putAll(this.udfParams);

        }
        /*  96 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 100 */
        if (this.udfParams == null) {
            /* 101 */
            this.udfParams = new AlipayHashMap();

        }
        /* 103 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayUserContractGetResponse> getResponseClass() {
        /* 107 */
        return AlipayUserContractGetResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 113 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 119 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayUserContractGetRequest
 * JD-Core Version:    0.6.0
 */