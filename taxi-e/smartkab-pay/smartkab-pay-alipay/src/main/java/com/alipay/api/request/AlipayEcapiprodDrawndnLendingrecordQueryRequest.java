package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayEcapiprodDrawndnLendingrecordQueryResponse;

import java.util.Map;


public class AlipayEcapiprodDrawndnLendingrecordQueryRequest implements AlipayRequest<AlipayEcapiprodDrawndnLendingrecordQueryResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String drawndnNo;
    private String end;
    private String entityCode;
    private String entityName;
    private String isvCode;
    private String orgCode;
    private String start;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /* 108 */   private boolean needEncrypt = false;


    public String getDrawndnNo() {
        /*  59 */
        return this.drawndnNo;

    }


    public void setDrawndnNo(String drawndnNo) {
        /*  56 */
        this.drawndnNo = drawndnNo;

    }


    public String getEnd() {
        /*  66 */
        return this.end;

    }


    public void setEnd(String end) {
        /*  63 */
        this.end = end;

    }


    public String getEntityCode() {
        /*  73 */
        return this.entityCode;

    }


    public void setEntityCode(String entityCode) {
        /*  70 */
        this.entityCode = entityCode;

    }


    public String getEntityName() {
        /*  80 */
        return this.entityName;

    }


    public void setEntityName(String entityName) {
        /*  77 */
        this.entityName = entityName;

    }


    public String getIsvCode() {
        /*  87 */
        return this.isvCode;

    }


    public void setIsvCode(String isvCode) {
        /*  84 */
        this.isvCode = isvCode;

    }


    public String getOrgCode() {
        /*  94 */
        return this.orgCode;

    }


    public void setOrgCode(String orgCode) {
        /*  91 */
        this.orgCode = orgCode;

    }


    public String getStart() {
        /* 101 */
        return this.start;

    }


    public void setStart(String start) {
        /*  98 */
        this.start = start;

    }


    public String getNotifyUrl() {
        /* 111 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /* 115 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /* 119 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /* 123 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /* 127 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /* 131 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /* 139 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /* 135 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /* 147 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /* 143 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /* 155 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 151 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 159 */
        return "alipay.ecapiprod.drawndn.lendingrecord.query";

    }


    public Map<String, String> getTextParams() {
        /* 163 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 164 */
        txtParams.put("drawndn_no", this.drawndnNo);
        /* 165 */
        txtParams.put("end", this.end);
        /* 166 */
        txtParams.put("entity_code", this.entityCode);
        /* 167 */
        txtParams.put("entity_name", this.entityName);
        /* 168 */
        txtParams.put("isv_code", this.isvCode);
        /* 169 */
        txtParams.put("org_code", this.orgCode);
        /* 170 */
        txtParams.put("start", this.start);
        /* 171 */
        if (this.udfParams != null) {
            /* 172 */
            txtParams.putAll(this.udfParams);

        }
        /* 174 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 178 */
        if (this.udfParams == null) {
            /* 179 */
            this.udfParams = new AlipayHashMap();

        }
        /* 181 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayEcapiprodDrawndnLendingrecordQueryResponse> getResponseClass() {
        /* 185 */
        return AlipayEcapiprodDrawndnLendingrecordQueryResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 191 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 197 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayEcapiprodDrawndnLendingrecordQueryRequest
 * JD-Core Version:    0.6.0
 */