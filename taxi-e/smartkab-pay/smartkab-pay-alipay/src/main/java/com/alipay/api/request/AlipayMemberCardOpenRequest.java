package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayMemberCardOpenResponse;

import java.util.Map;


public class AlipayMemberCardOpenRequest implements AlipayRequest<AlipayMemberCardOpenResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String bizSerialNo;
    private String cardMerchantInfo;
    private String cardUserInfo;
    private String extInfo;
    private String externalCardNo;
    private String requestFrom;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /* 115 */   private boolean needEncrypt = false;


    public String getBizSerialNo() {
        /*  73 */
        return this.bizSerialNo;

    }


    public void setBizSerialNo(String bizSerialNo) {
        /*  70 */
        this.bizSerialNo = bizSerialNo;

    }


    public String getCardMerchantInfo() {
        /*  80 */
        return this.cardMerchantInfo;

    }


    public void setCardMerchantInfo(String cardMerchantInfo) {
        /*  77 */
        this.cardMerchantInfo = cardMerchantInfo;

    }


    public String getCardUserInfo() {
        /*  87 */
        return this.cardUserInfo;

    }


    public void setCardUserInfo(String cardUserInfo) {
        /*  84 */
        this.cardUserInfo = cardUserInfo;

    }


    public String getExtInfo() {
        /*  94 */
        return this.extInfo;

    }


    public void setExtInfo(String extInfo) {
        /*  91 */
        this.extInfo = extInfo;

    }


    public String getExternalCardNo() {
        /* 101 */
        return this.externalCardNo;

    }


    public void setExternalCardNo(String externalCardNo) {
        /*  98 */
        this.externalCardNo = externalCardNo;

    }


    public String getRequestFrom() {
        /* 108 */
        return this.requestFrom;

    }


    public void setRequestFrom(String requestFrom) {
        /* 105 */
        this.requestFrom = requestFrom;

    }


    public String getNotifyUrl() {
        /* 118 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /* 122 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /* 126 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /* 130 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /* 134 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /* 138 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /* 146 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /* 142 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /* 154 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /* 150 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /* 162 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 158 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 166 */
        return "alipay.member.card.open";

    }


    public Map<String, String> getTextParams() {
        /* 170 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 171 */
        txtParams.put("biz_serial_no", this.bizSerialNo);
        /* 172 */
        txtParams.put("card_merchant_info", this.cardMerchantInfo);
        /* 173 */
        txtParams.put("card_user_info", this.cardUserInfo);
        /* 174 */
        txtParams.put("ext_info", this.extInfo);
        /* 175 */
        txtParams.put("external_card_no", this.externalCardNo);
        /* 176 */
        txtParams.put("request_from", this.requestFrom);
        /* 177 */
        if (this.udfParams != null) {
            /* 178 */
            txtParams.putAll(this.udfParams);

        }
        /* 180 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 184 */
        if (this.udfParams == null) {
            /* 185 */
            this.udfParams = new AlipayHashMap();

        }
        /* 187 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayMemberCardOpenResponse> getResponseClass() {
        /* 191 */
        return AlipayMemberCardOpenResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 197 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 203 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayMemberCardOpenRequest
 * JD-Core Version:    0.6.0
 */