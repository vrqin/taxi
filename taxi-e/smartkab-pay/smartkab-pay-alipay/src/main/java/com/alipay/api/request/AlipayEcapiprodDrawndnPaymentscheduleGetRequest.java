package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayEcapiprodDrawndnPaymentscheduleGetResponse;

import java.util.Map;


public class AlipayEcapiprodDrawndnPaymentscheduleGetRequest implements AlipayRequest<AlipayEcapiprodDrawndnPaymentscheduleGetResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String drawndnNo;
    private String entityCode;
    private String entityName;
    private String isvCode;
    private String orgCode;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /*  84 */   private boolean needEncrypt = false;


    public String getDrawndnNo() {
        /*  49 */
        return this.drawndnNo;

    }


    public void setDrawndnNo(String drawndnNo) {
        /*  46 */
        this.drawndnNo = drawndnNo;

    }


    public String getEntityCode() {
        /*  56 */
        return this.entityCode;

    }


    public void setEntityCode(String entityCode) {
        /*  53 */
        this.entityCode = entityCode;

    }


    public String getEntityName() {
        /*  63 */
        return this.entityName;

    }


    public void setEntityName(String entityName) {
        /*  60 */
        this.entityName = entityName;

    }


    public String getIsvCode() {
        /*  70 */
        return this.isvCode;

    }


    public void setIsvCode(String isvCode) {
        /*  67 */
        this.isvCode = isvCode;

    }


    public String getOrgCode() {
        /*  77 */
        return this.orgCode;

    }


    public void setOrgCode(String orgCode) {
        /*  74 */
        this.orgCode = orgCode;

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
        return "alipay.ecapiprod.drawndn.paymentschedule.get";

    }


    public Map<String, String> getTextParams() {
        /* 139 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 140 */
        txtParams.put("drawndn_no", this.drawndnNo);
        /* 141 */
        txtParams.put("entity_code", this.entityCode);
        /* 142 */
        txtParams.put("entity_name", this.entityName);
        /* 143 */
        txtParams.put("isv_code", this.isvCode);
        /* 144 */
        txtParams.put("org_code", this.orgCode);
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


    public Class<AlipayEcapiprodDrawndnPaymentscheduleGetResponse> getResponseClass() {
        /* 159 */
        return AlipayEcapiprodDrawndnPaymentscheduleGetResponse.class;

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
 * Qualified Name:     com.alipay.api.request.AlipayEcapiprodDrawndnPaymentscheduleGetRequest
 * JD-Core Version:    0.6.0
 */