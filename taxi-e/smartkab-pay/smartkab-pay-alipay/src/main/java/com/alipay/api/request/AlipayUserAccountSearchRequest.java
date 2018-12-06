package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayUserAccountSearchResponse;

import java.util.Map;


public class AlipayUserAccountSearchRequest implements AlipayRequest<AlipayUserAccountSearchResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String endTime;
    private String fields;
    private String pageNo;
    private String pageSize;
    private String startTime;
    private String type;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /*  96 */   private boolean needEncrypt = false;


    public String getEndTime() {
        /*  54 */
        return this.endTime;

    }


    public void setEndTime(String endTime) {
        /*  51 */
        this.endTime = endTime;

    }


    public String getFields() {
        /*  61 */
        return this.fields;

    }


    public void setFields(String fields) {
        /*  58 */
        this.fields = fields;

    }


    public String getPageNo() {
        /*  68 */
        return this.pageNo;

    }


    public void setPageNo(String pageNo) {
        /*  65 */
        this.pageNo = pageNo;

    }


    public String getPageSize() {
        /*  75 */
        return this.pageSize;

    }


    public void setPageSize(String pageSize) {
        /*  72 */
        this.pageSize = pageSize;

    }


    public String getStartTime() {
        /*  82 */
        return this.startTime;

    }


    public void setStartTime(String startTime) {
        /*  79 */
        this.startTime = startTime;

    }


    public String getType() {
        /*  89 */
        return this.type;

    }


    public void setType(String type) {
        /*  86 */
        this.type = type;

    }


    public String getNotifyUrl() {
        /*  99 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /* 103 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /* 107 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /* 111 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /* 115 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /* 119 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /* 127 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /* 123 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /* 135 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /* 131 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /* 143 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 139 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 147 */
        return "alipay.user.account.search";

    }


    public Map<String, String> getTextParams() {
        /* 151 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 152 */
        txtParams.put("end_time", this.endTime);
        /* 153 */
        txtParams.put("fields", this.fields);
        /* 154 */
        txtParams.put("page_no", this.pageNo);
        /* 155 */
        txtParams.put("page_size", this.pageSize);
        /* 156 */
        txtParams.put("start_time", this.startTime);
        /* 157 */
        txtParams.put("type", this.type);
        /* 158 */
        if (this.udfParams != null) {
            /* 159 */
            txtParams.putAll(this.udfParams);

        }
        /* 161 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 165 */
        if (this.udfParams == null) {
            /* 166 */
            this.udfParams = new AlipayHashMap();

        }
        /* 168 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayUserAccountSearchResponse> getResponseClass() {
        /* 172 */
        return AlipayUserAccountSearchResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 178 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 184 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayUserAccountSearchRequest
 * JD-Core Version:    0.6.0
 */