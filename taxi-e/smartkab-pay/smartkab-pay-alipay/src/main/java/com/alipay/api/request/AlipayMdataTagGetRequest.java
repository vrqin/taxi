package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayMdataTagGetResponse;

import java.util.List;
import java.util.Map;


public class AlipayMdataTagGetRequest implements AlipayRequest<AlipayMdataTagGetResponse> {
    private AlipayHashMap udfParams;
    /*  19 */   private String apiVersion = "1.0";
    private List<String> requiredTags;
    private String userId;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /*  49 */   private boolean needEncrypt = false;


    public List<String> getRequiredTags() {
        /*  35 */
        return this.requiredTags;

    }


    public void setRequiredTags(List<String> requiredTags) {
        /*  32 */
        this.requiredTags = requiredTags;

    }


    public String getUserId() {
        /*  42 */
        return this.userId;

    }


    public void setUserId(String userId) {
        /*  39 */
        this.userId = userId;

    }


    public String getNotifyUrl() {
        /*  52 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /*  56 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /*  60 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /*  64 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /*  68 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /*  72 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /*  80 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /*  76 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /*  88 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /*  84 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /*  96 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /*  92 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 100 */
        return "alipay.mdata.tag.get";

    }


    public Map<String, String> getTextParams() {
        /* 104 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 105 */
        txtParams.put("required_tags", this.requiredTags);
        /* 106 */
        txtParams.put("user_id", this.userId);
        /* 107 */
        if (this.udfParams != null) {
            /* 108 */
            txtParams.putAll(this.udfParams);

        }
        /* 110 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 114 */
        if (this.udfParams == null) {
            /* 115 */
            this.udfParams = new AlipayHashMap();

        }
        /* 117 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayMdataTagGetResponse> getResponseClass() {
        /* 121 */
        return AlipayMdataTagGetResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 127 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 133 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayMdataTagGetRequest
 * JD-Core Version:    0.6.0
 */