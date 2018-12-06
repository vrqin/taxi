package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayMobileCodeCreateResponse;

import java.util.Date;
import java.util.Map;


public class AlipayMobileCodeCreateRequest implements AlipayRequest<AlipayMobileCodeCreateResponse> {
    private AlipayHashMap udfParams;
    /*  19 */   private String apiVersion = "1.0";
    private String bizLinkedId;
    private String bizType;
    private String contextStr;
    private Boolean isDirect;
    private String memo;
    private String sourceId;
    private Date startDate;
    private Long timeout;
    private String userId;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /* 134 */   private boolean needEncrypt = false;


    public String getBizLinkedId() {
        /*  71 */
        return this.bizLinkedId;

    }


    public void setBizLinkedId(String bizLinkedId) {
        /*  68 */
        this.bizLinkedId = bizLinkedId;

    }


    public String getBizType() {
        /*  78 */
        return this.bizType;

    }


    public void setBizType(String bizType) {
        /*  75 */
        this.bizType = bizType;

    }


    public String getContextStr() {
        /*  85 */
        return this.contextStr;

    }


    public void setContextStr(String contextStr) {
        /*  82 */
        this.contextStr = contextStr;

    }


    public Boolean getIsDirect() {
        /*  92 */
        return this.isDirect;

    }


    public void setIsDirect(Boolean isDirect) {
        /*  89 */
        this.isDirect = isDirect;

    }


    public String getMemo() {
        /*  99 */
        return this.memo;

    }


    public void setMemo(String memo) {
        /*  96 */
        this.memo = memo;

    }


    public String getSourceId() {
        /* 106 */
        return this.sourceId;

    }


    public void setSourceId(String sourceId) {
        /* 103 */
        this.sourceId = sourceId;

    }


    public Date getStartDate() {
        /* 113 */
        return this.startDate;

    }


    public void setStartDate(Date startDate) {
        /* 110 */
        this.startDate = startDate;

    }


    public Long getTimeout() {
        /* 120 */
        return this.timeout;

    }


    public void setTimeout(Long timeout) {
        /* 117 */
        this.timeout = timeout;

    }


    public String getUserId() {
        /* 127 */
        return this.userId;

    }


    public void setUserId(String userId) {
        /* 124 */
        this.userId = userId;

    }


    public String getNotifyUrl() {
        /* 137 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /* 141 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /* 145 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /* 149 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /* 153 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /* 157 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /* 165 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /* 161 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /* 173 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /* 169 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /* 181 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 177 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 185 */
        return "alipay.mobile.code.create";

    }


    public Map<String, String> getTextParams() {
        /* 189 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 190 */
        txtParams.put("biz_linked_id", this.bizLinkedId);
        /* 191 */
        txtParams.put("biz_type", this.bizType);
        /* 192 */
        txtParams.put("context_str", this.contextStr);
        /* 193 */
        txtParams.put("is_direct", this.isDirect);
        /* 194 */
        txtParams.put("memo", this.memo);
        /* 195 */
        txtParams.put("source_id", this.sourceId);
        /* 196 */
        txtParams.put("start_date", this.startDate);
        /* 197 */
        txtParams.put("timeout", this.timeout);
        /* 198 */
        txtParams.put("user_id", this.userId);
        /* 199 */
        if (this.udfParams != null) {
            /* 200 */
            txtParams.putAll(this.udfParams);

        }
        /* 202 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 206 */
        if (this.udfParams == null) {
            /* 207 */
            this.udfParams = new AlipayHashMap();

        }
        /* 209 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayMobileCodeCreateResponse> getResponseClass() {
        /* 213 */
        return AlipayMobileCodeCreateResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 219 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 225 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayMobileCodeCreateRequest
 * JD-Core Version:    0.6.0
 */