package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayEcardEduPublicBindResponse;

import java.util.Map;


public class AlipayEcardEduPublicBindRequest implements AlipayRequest<AlipayEcardEduPublicBindResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String agentCode;
    private String agreementId;
    private String alipayUserId;
    private String cardName;
    private String cardNo;
    private String publicId;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /*  96 */   private boolean needEncrypt = false;


    public String getAgentCode() {
        /*  54 */
        return this.agentCode;

    }


    public void setAgentCode(String agentCode) {
        /*  51 */
        this.agentCode = agentCode;

    }


    public String getAgreementId() {
        /*  61 */
        return this.agreementId;

    }


    public void setAgreementId(String agreementId) {
        /*  58 */
        this.agreementId = agreementId;

    }


    public String getAlipayUserId() {
        /*  68 */
        return this.alipayUserId;

    }


    public void setAlipayUserId(String alipayUserId) {
        /*  65 */
        this.alipayUserId = alipayUserId;

    }


    public String getCardName() {
        /*  75 */
        return this.cardName;

    }


    public void setCardName(String cardName) {
        /*  72 */
        this.cardName = cardName;

    }


    public String getCardNo() {
        /*  82 */
        return this.cardNo;

    }


    public void setCardNo(String cardNo) {
        /*  79 */
        this.cardNo = cardNo;

    }


    public String getPublicId() {
        /*  89 */
        return this.publicId;

    }


    public void setPublicId(String publicId) {
        /*  86 */
        this.publicId = publicId;

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
        return "alipay.ecard.edu.public.bind";

    }


    public Map<String, String> getTextParams() {
        /* 151 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 152 */
        txtParams.put("agent_code", this.agentCode);
        /* 153 */
        txtParams.put("agreement_id", this.agreementId);
        /* 154 */
        txtParams.put("alipay_user_id", this.alipayUserId);
        /* 155 */
        txtParams.put("card_name", this.cardName);
        /* 156 */
        txtParams.put("card_no", this.cardNo);
        /* 157 */
        txtParams.put("public_id", this.publicId);
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


    public Class<AlipayEcardEduPublicBindResponse> getResponseClass() {
        /* 172 */
        return AlipayEcardEduPublicBindResponse.class;

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
 * Qualified Name:     com.alipay.api.request.AlipayEcardEduPublicBindRequest
 * JD-Core Version:    0.6.0
 */