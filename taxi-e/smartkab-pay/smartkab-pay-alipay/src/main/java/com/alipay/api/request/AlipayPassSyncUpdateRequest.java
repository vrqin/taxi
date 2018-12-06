package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayPassSyncUpdateResponse;

import java.util.Map;


public class AlipayPassSyncUpdateRequest implements AlipayRequest<AlipayPassSyncUpdateResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String channelId;
    private String extInfo;
    private String pass;
    private String serialNumber;
    private String status;
    private String verifyCode;
    private String verifyType;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /* 108 */   private boolean needEncrypt = false;


    public String getChannelId() {
        /*  59 */
        return this.channelId;

    }


    public void setChannelId(String channelId) {
        /*  56 */
        this.channelId = channelId;

    }


    public String getExtInfo() {
        /*  66 */
        return this.extInfo;

    }


    public void setExtInfo(String extInfo) {
        /*  63 */
        this.extInfo = extInfo;

    }


    public String getPass() {
        /*  73 */
        return this.pass;

    }


    public void setPass(String pass) {
        /*  70 */
        this.pass = pass;

    }


    public String getSerialNumber() {
        /*  80 */
        return this.serialNumber;

    }


    public void setSerialNumber(String serialNumber) {
        /*  77 */
        this.serialNumber = serialNumber;

    }


    public String getStatus() {
        /*  87 */
        return this.status;

    }


    public void setStatus(String status) {
        /*  84 */
        this.status = status;

    }


    public String getVerifyCode() {
        /*  94 */
        return this.verifyCode;

    }


    public void setVerifyCode(String verifyCode) {
        /*  91 */
        this.verifyCode = verifyCode;

    }


    public String getVerifyType() {
        /* 101 */
        return this.verifyType;

    }


    public void setVerifyType(String verifyType) {
        /*  98 */
        this.verifyType = verifyType;

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
        return "alipay.pass.sync.update";

    }


    public Map<String, String> getTextParams() {
        /* 163 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 164 */
        txtParams.put("channel_id", this.channelId);
        /* 165 */
        txtParams.put("ext_info", this.extInfo);
        /* 166 */
        txtParams.put("pass", this.pass);
        /* 167 */
        txtParams.put("serial_number", this.serialNumber);
        /* 168 */
        txtParams.put("status", this.status);
        /* 169 */
        txtParams.put("verify_code", this.verifyCode);
        /* 170 */
        txtParams.put("verify_type", this.verifyType);
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


    public Class<AlipayPassSyncUpdateResponse> getResponseClass() {
        /* 185 */
        return AlipayPassSyncUpdateResponse.class;

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
 * Qualified Name:     com.alipay.api.request.AlipayPassSyncUpdateRequest
 * JD-Core Version:    0.6.0
 */