package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayMemberCardQueryResponse;

import java.util.Map;


public class AlipayMemberCardQueryRequest implements AlipayRequest<AlipayMemberCardQueryResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String bizCardNo;
    private String cardMerchantInfo;
    private String cardUserInfo;
    private String extInfo;
    private String requestFrom;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /* 108 */   private boolean needEncrypt = false;


    public String getBizCardNo() {
        /*  73 */
        return this.bizCardNo;

    }


    public void setBizCardNo(String bizCardNo) {
        /*  70 */
        this.bizCardNo = bizCardNo;

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


    public String getRequestFrom() {
        /* 101 */
        return this.requestFrom;

    }


    public void setRequestFrom(String requestFrom) {
        /*  98 */
        this.requestFrom = requestFrom;

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
        return "alipay.member.card.query";

    }


    public Map<String, String> getTextParams() {
        /* 163 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 164 */
        txtParams.put("biz_card_no", this.bizCardNo);
        /* 165 */
        txtParams.put("card_merchant_info", this.cardMerchantInfo);
        /* 166 */
        txtParams.put("card_user_info", this.cardUserInfo);
        /* 167 */
        txtParams.put("ext_info", this.extInfo);
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


    public Class<AlipayMemberCardQueryResponse> getResponseClass() {
        /* 183 */
        return AlipayMemberCardQueryResponse.class;

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
 * Qualified Name:     com.alipay.api.request.AlipayMemberCardQueryRequest
 * JD-Core Version:    0.6.0
 */