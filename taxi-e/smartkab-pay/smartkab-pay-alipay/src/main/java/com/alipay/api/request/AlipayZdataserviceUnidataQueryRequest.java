package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayZdataserviceUnidataQueryResponse;

import java.util.Map;


public class AlipayZdataserviceUnidataQueryRequest implements AlipayRequest<AlipayZdataserviceUnidataQueryResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String queryCondition;
    private String uniqKey;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /*  48 */   private boolean needEncrypt = false;


    public String getQueryCondition() {
        /*  34 */
        return this.queryCondition;

    }


    public void setQueryCondition(String queryCondition) {
        /*  31 */
        this.queryCondition = queryCondition;

    }


    public String getUniqKey() {
        /*  41 */
        return this.uniqKey;

    }


    public void setUniqKey(String uniqKey) {
        /*  38 */
        this.uniqKey = uniqKey;

    }


    public String getNotifyUrl() {
        /*  51 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /*  55 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /*  59 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /*  63 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /*  67 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /*  71 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /*  79 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /*  75 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /*  87 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /*  83 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /*  95 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /*  91 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /*  99 */
        return "alipay.zdataservice.unidata.query";

    }


    public Map<String, String> getTextParams() {
        /* 103 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 104 */
        txtParams.put("query_condition", this.queryCondition);
        /* 105 */
        txtParams.put("uniq_key", this.uniqKey);
        /* 106 */
        if (this.udfParams != null) {
            /* 107 */
            txtParams.putAll(this.udfParams);

        }
        /* 109 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 113 */
        if (this.udfParams == null) {
            /* 114 */
            this.udfParams = new AlipayHashMap();

        }
        /* 116 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayZdataserviceUnidataQueryResponse> getResponseClass() {
        /* 120 */
        return AlipayZdataserviceUnidataQueryResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 126 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 132 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayZdataserviceUnidataQueryRequest
 * JD-Core Version:    0.6.0
 */