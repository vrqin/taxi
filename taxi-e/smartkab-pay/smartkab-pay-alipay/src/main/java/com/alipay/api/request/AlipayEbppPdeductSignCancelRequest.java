package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayEbppPdeductSignCancelResponse;

import java.util.Map;


public class AlipayEbppPdeductSignCancelRequest implements AlipayRequest<AlipayEbppPdeductSignCancelResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String agentChannel;
    private String agentCode;
    private String agreementId;
    private String payPasswordToken;
    private String userId;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /*  84 */   private boolean needEncrypt = false;


    public String getAgentChannel() {
        /*  49 */
        return this.agentChannel;

    }


    public void setAgentChannel(String agentChannel) {
        /*  46 */
        this.agentChannel = agentChannel;

    }


    public String getAgentCode() {
        /*  56 */
        return this.agentCode;

    }


    public void setAgentCode(String agentCode) {
        /*  53 */
        this.agentCode = agentCode;

    }


    public String getAgreementId() {
        /*  63 */
        return this.agreementId;

    }


    public void setAgreementId(String agreementId) {
        /*  60 */
        this.agreementId = agreementId;

    }


    public String getPayPasswordToken() {
        /*  70 */
        return this.payPasswordToken;

    }


    public void setPayPasswordToken(String payPasswordToken) {
        /*  67 */
        this.payPasswordToken = payPasswordToken;

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
        return "alipay.ebpp.pdeduct.sign.cancel";

    }


    public Map<String, String> getTextParams() {
        /* 139 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 140 */
        txtParams.put("agent_channel", this.agentChannel);
        /* 141 */
        txtParams.put("agent_code", this.agentCode);
        /* 142 */
        txtParams.put("agreement_id", this.agreementId);
        /* 143 */
        txtParams.put("pay_password_token", this.payPasswordToken);
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


    public Class<AlipayEbppPdeductSignCancelResponse> getResponseClass() {
        /* 159 */
        return AlipayEbppPdeductSignCancelResponse.class;

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
 * Qualified Name:     com.alipay.api.request.AlipayEbppPdeductSignCancelRequest
 * JD-Core Version:    0.6.0
 */