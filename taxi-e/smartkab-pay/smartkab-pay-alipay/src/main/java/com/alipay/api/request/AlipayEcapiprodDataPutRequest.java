package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayEcapiprodDataPutResponse;

import java.util.Map;


public class AlipayEcapiprodDataPutRequest implements AlipayRequest<AlipayEcapiprodDataPutResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String category;
    private String charSet;
    private String collectingTaskId;
    private String entityCode;
    private String entityName;
    private String entityType;
    private String isvCode;
    private String jsonData;
    private String orgCode;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /* 132 */   private boolean needEncrypt = false;


    public String getCategory() {
        /*  69 */
        return this.category;

    }


    public void setCategory(String category) {
        /*  66 */
        this.category = category;

    }


    public String getCharSet() {
        /*  76 */
        return this.charSet;

    }


    public void setCharSet(String charSet) {
        /*  73 */
        this.charSet = charSet;

    }


    public String getCollectingTaskId() {
        /*  83 */
        return this.collectingTaskId;

    }


    public void setCollectingTaskId(String collectingTaskId) {
        /*  80 */
        this.collectingTaskId = collectingTaskId;

    }


    public String getEntityCode() {
        /*  90 */
        return this.entityCode;

    }


    public void setEntityCode(String entityCode) {
        /*  87 */
        this.entityCode = entityCode;

    }


    public String getEntityName() {
        /*  97 */
        return this.entityName;

    }


    public void setEntityName(String entityName) {
        /*  94 */
        this.entityName = entityName;

    }


    public String getEntityType() {
        /* 104 */
        return this.entityType;

    }


    public void setEntityType(String entityType) {
        /* 101 */
        this.entityType = entityType;

    }


    public String getIsvCode() {
        /* 111 */
        return this.isvCode;

    }


    public void setIsvCode(String isvCode) {
        /* 108 */
        this.isvCode = isvCode;

    }


    public String getJsonData() {
        /* 118 */
        return this.jsonData;

    }


    public void setJsonData(String jsonData) {
        /* 115 */
        this.jsonData = jsonData;

    }


    public String getOrgCode() {
        /* 125 */
        return this.orgCode;

    }


    public void setOrgCode(String orgCode) {
        /* 122 */
        this.orgCode = orgCode;

    }


    public String getNotifyUrl() {
        /* 135 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /* 139 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /* 143 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /* 147 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /* 151 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /* 155 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /* 163 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /* 159 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /* 171 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /* 167 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /* 179 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 175 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 183 */
        return "alipay.ecapiprod.data.put";

    }


    public Map<String, String> getTextParams() {
        /* 187 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 188 */
        txtParams.put("category", this.category);
        /* 189 */
        txtParams.put("char_set", this.charSet);
        /* 190 */
        txtParams.put("collecting_task_id", this.collectingTaskId);
        /* 191 */
        txtParams.put("entity_code", this.entityCode);
        /* 192 */
        txtParams.put("entity_name", this.entityName);
        /* 193 */
        txtParams.put("entity_type", this.entityType);
        /* 194 */
        txtParams.put("isv_code", this.isvCode);
        /* 195 */
        txtParams.put("json_data", this.jsonData);
        /* 196 */
        txtParams.put("org_code", this.orgCode);
        /* 197 */
        if (this.udfParams != null) {
            /* 198 */
            txtParams.putAll(this.udfParams);

        }
        /* 200 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 204 */
        if (this.udfParams == null) {
            /* 205 */
            this.udfParams = new AlipayHashMap();

        }
        /* 207 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayEcapiprodDataPutResponse> getResponseClass() {
        /* 211 */
        return AlipayEcapiprodDataPutResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 217 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 223 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayEcapiprodDataPutRequest
 * JD-Core Version:    0.6.0
 */