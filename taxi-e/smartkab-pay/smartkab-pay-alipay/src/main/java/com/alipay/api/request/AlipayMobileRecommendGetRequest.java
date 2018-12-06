package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayMobileRecommendGetResponse;

import java.util.Map;


public class AlipayMobileRecommendGetRequest implements AlipayRequest<AlipayMobileRecommendGetResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String extInfo;
    private String limit;
    private String sceneId;
    private String startIdx;
    private String userId;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /*  84 */   private boolean needEncrypt = false;


    public String getExtInfo() {
        /*  49 */
        return this.extInfo;

    }


    public void setExtInfo(String extInfo) {
        /*  46 */
        this.extInfo = extInfo;

    }


    public String getLimit() {
        /*  56 */
        return this.limit;

    }


    public void setLimit(String limit) {
        /*  53 */
        this.limit = limit;

    }


    public String getSceneId() {
        /*  63 */
        return this.sceneId;

    }


    public void setSceneId(String sceneId) {
        /*  60 */
        this.sceneId = sceneId;

    }


    public String getStartIdx() {
        /*  70 */
        return this.startIdx;

    }


    public void setStartIdx(String startIdx) {
        /*  67 */
        this.startIdx = startIdx;

    }


    public String getUserId() {
        /*  77 */
        return this.userId;

    }


    public void setUserId(String userId) {
        /*  74 */
        this.userId = userId;

    }


    public String getNotifyUrl() {
        /*  87 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /*  91 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /*  95 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /*  99 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /* 103 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /* 107 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /* 115 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /* 111 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /* 123 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /* 119 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /* 131 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 127 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 135 */
        return "alipay.mobile.recommend.get";

    }


    public Map<String, String> getTextParams() {
        /* 139 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 140 */
        txtParams.put("ext_info", this.extInfo);
        /* 141 */
        txtParams.put("limit", this.limit);
        /* 142 */
        txtParams.put("scene_id", this.sceneId);
        /* 143 */
        txtParams.put("start_idx", this.startIdx);
        /* 144 */
        txtParams.put("user_id", this.userId);
        /* 145 */
        if (this.udfParams != null) {
            /* 146 */
            txtParams.putAll(this.udfParams);

        }
        /* 148 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 152 */
        if (this.udfParams == null) {
            /* 153 */
            this.udfParams = new AlipayHashMap();

        }
        /* 155 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayMobileRecommendGetResponse> getResponseClass() {
        /* 159 */
        return AlipayMobileRecommendGetResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 165 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 171 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayMobileRecommendGetRequest
 * JD-Core Version:    0.6.0
 */