package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayPassTplContentUpdateResponse;

import java.util.Map;


public class AlipayPassTplContentUpdateRequest implements AlipayRequest<AlipayPassTplContentUpdateResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String channelId;
    private String serialNumber;
    private String status;
    private String tplParams;
    private String verifyCode;
    private String verifyType;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /*  96 */   private boolean needEncrypt = false;


    public String getChannelId() {
        /*  54 */
        return this.channelId;

    }


    public void setChannelId(String channelId) {
        /*  51 */
        this.channelId = channelId;

    }


    public String getSerialNumber() {
        /*  61 */
        return this.serialNumber;

    }


    public void setSerialNumber(String serialNumber) {
        /*  58 */
        this.serialNumber = serialNumber;

    }


    public String getStatus() {
        /*  68 */
        return this.status;

    }


    public void setStatus(String status) {
        /*  65 */
        this.status = status;

    }


    public String getTplParams() {
        /*  75 */
        return this.tplParams;

    }


    public void setTplParams(String tplParams) {
        /*  72 */
        this.tplParams = tplParams;

    }


    public String getVerifyCode() {
        /*  82 */
        return this.verifyCode;

    }


    public void setVerifyCode(String verifyCode) {
        /*  79 */
        this.verifyCode = verifyCode;

    }


    public String getVerifyType() {
        /*  89 */
        return this.verifyType;

    }


    public void setVerifyType(String verifyType) {
        /*  86 */
        this.verifyType = verifyType;

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
        return "alipay.pass.tpl.content.update";

    }


    public Map<String, String> getTextParams() {
        /* 151 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 152 */
        txtParams.put("channel_id", this.channelId);
        /* 153 */
        txtParams.put("serial_number", this.serialNumber);
        /* 154 */
        txtParams.put("status", this.status);
        /* 155 */
        txtParams.put("tpl_params", this.tplParams);
        /* 156 */
        txtParams.put("verify_code", this.verifyCode);
        /* 157 */
        txtParams.put("verify_type", this.verifyType);
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


    public Class<AlipayPassTplContentUpdateResponse> getResponseClass() {
        /* 172 */
        return AlipayPassTplContentUpdateResponse.class;

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
 * Qualified Name:     com.alipay.api.request.AlipayPassTplContentUpdateRequest
 * JD-Core Version:    0.6.0
 */