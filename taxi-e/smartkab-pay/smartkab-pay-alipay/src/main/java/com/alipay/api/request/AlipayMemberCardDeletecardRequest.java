package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayMemberCardDeletecardResponse;

import java.util.Map;


public class AlipayMemberCardDeletecardRequest implements AlipayRequest<AlipayMemberCardDeletecardResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String bizSerialNo;
    private String cardMerchantInfo;
    private String extInfo;
    private String externalCardNo;
    private String reasonCode;
    private String requestFrom;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /* 107 */   private boolean needEncrypt = false;


    public String getBizSerialNo() {
        /*  65 */
        return this.bizSerialNo;

    }


    public void setBizSerialNo(String bizSerialNo) {
        /*  62 */
        this.bizSerialNo = bizSerialNo;

    }


    public String getCardMerchantInfo() {
        /*  72 */
        return this.cardMerchantInfo;

    }


    public void setCardMerchantInfo(String cardMerchantInfo) {
        /*  69 */
        this.cardMerchantInfo = cardMerchantInfo;

    }


    public String getExtInfo() {
        /*  79 */
        return this.extInfo;

    }


    public void setExtInfo(String extInfo) {
        /*  76 */
        this.extInfo = extInfo;

    }


    public String getExternalCardNo() {
        /*  86 */
        return this.externalCardNo;

    }


    public void setExternalCardNo(String externalCardNo) {
        /*  83 */
        this.externalCardNo = externalCardNo;

    }


    public String getReasonCode() {
        /*  93 */
        return this.reasonCode;

    }


    public void setReasonCode(String reasonCode) {
        /*  90 */
        this.reasonCode = reasonCode;

    }


    public String getRequestFrom() {
        /* 100 */
        return this.requestFrom;

    }


    public void setRequestFrom(String requestFrom) {
        /*  97 */
        this.requestFrom = requestFrom;

    }


    public String getNotifyUrl() {
        /* 110 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /* 114 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /* 118 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /* 122 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /* 126 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /* 130 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /* 138 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /* 134 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /* 146 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /* 142 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /* 154 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 150 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 158 */
        return "alipay.member.card.deletecard";

    }


    public Map<String, String> getTextParams() {
        /* 162 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 163 */
        txtParams.put("biz_serial_no", this.bizSerialNo);
        /* 164 */
        txtParams.put("card_merchant_info", this.cardMerchantInfo);
        /* 165 */
        txtParams.put("ext_info", this.extInfo);
        /* 166 */
        txtParams.put("external_card_no", this.externalCardNo);
        /* 167 */
        txtParams.put("reason_code", this.reasonCode);
        /* 168 */
        txtParams.put("request_from", this.requestFrom);
        /* 169 */
        if (this.udfParams != null) {
            /* 170 */
            txtParams.putAll(this.udfParams);

        }
        /* 172 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 176 */
        if (this.udfParams == null) {
            /* 177 */
            this.udfParams = new AlipayHashMap();

        }
        /* 179 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayMemberCardDeletecardResponse> getResponseClass() {
        /* 183 */
        return AlipayMemberCardDeletecardResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 189 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 195 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayMemberCardDeletecardRequest
 * JD-Core Version:    0.6.0
 */