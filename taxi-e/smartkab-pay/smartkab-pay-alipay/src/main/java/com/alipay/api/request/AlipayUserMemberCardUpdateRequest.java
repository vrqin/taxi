package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayUserMemberCardUpdateResponse;

import java.util.Map;


public class AlipayUserMemberCardUpdateRequest implements AlipayRequest<AlipayUserMemberCardUpdateResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String balance;
    private String bizCardNo;
    private String cardMerchantInfo;
    private String extInfo;
    private String externalCardNo;
    private String issuerType;
    private String level;
    private String orrurTime;
    private Long point;
    private String requestFrom;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /* 159 */   private boolean needEncrypt = false;


    public String getBalance() {
        /*  89 */
        return this.balance;

    }


    public void setBalance(String balance) {
        /*  86 */
        this.balance = balance;

    }


    public String getBizCardNo() {
        /*  96 */
        return this.bizCardNo;

    }


    public void setBizCardNo(String bizCardNo) {
        /*  93 */
        this.bizCardNo = bizCardNo;

    }


    public String getCardMerchantInfo() {
        /* 103 */
        return this.cardMerchantInfo;

    }


    public void setCardMerchantInfo(String cardMerchantInfo) {
        /* 100 */
        this.cardMerchantInfo = cardMerchantInfo;

    }


    public String getExtInfo() {
        /* 110 */
        return this.extInfo;

    }


    public void setExtInfo(String extInfo) {
        /* 107 */
        this.extInfo = extInfo;

    }


    public String getExternalCardNo() {
        /* 117 */
        return this.externalCardNo;

    }


    public void setExternalCardNo(String externalCardNo) {
        /* 114 */
        this.externalCardNo = externalCardNo;

    }


    public String getIssuerType() {
        /* 124 */
        return this.issuerType;

    }


    public void setIssuerType(String issuerType) {
        /* 121 */
        this.issuerType = issuerType;

    }


    public String getLevel() {
        /* 131 */
        return this.level;

    }


    public void setLevel(String level) {
        /* 128 */
        this.level = level;

    }


    public String getOrrurTime() {
        /* 138 */
        return this.orrurTime;

    }


    public void setOrrurTime(String orrurTime) {
        /* 135 */
        this.orrurTime = orrurTime;

    }


    public Long getPoint() {
        /* 145 */
        return this.point;

    }


    public void setPoint(Long point) {
        /* 142 */
        this.point = point;

    }


    public String getRequestFrom() {
        /* 152 */
        return this.requestFrom;

    }


    public void setRequestFrom(String requestFrom) {
        /* 149 */
        this.requestFrom = requestFrom;

    }


    public String getNotifyUrl() {
        /* 162 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /* 166 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /* 170 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /* 174 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /* 178 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /* 182 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /* 190 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /* 186 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /* 198 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /* 194 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /* 206 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 202 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 210 */
        return "alipay.user.member.card.update";

    }


    public Map<String, String> getTextParams() {
        /* 214 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 215 */
        txtParams.put("balance", this.balance);
        /* 216 */
        txtParams.put("biz_card_no", this.bizCardNo);
        /* 217 */
        txtParams.put("card_merchant_info", this.cardMerchantInfo);
        /* 218 */
        txtParams.put("ext_info", this.extInfo);
        /* 219 */
        txtParams.put("external_card_no", this.externalCardNo);
        /* 220 */
        txtParams.put("issuer_type", this.issuerType);
        /* 221 */
        txtParams.put("level", this.level);
        /* 222 */
        txtParams.put("orrur_time", this.orrurTime);
        /* 223 */
        txtParams.put("point", this.point);
        /* 224 */
        txtParams.put("request_from", this.requestFrom);
        /* 225 */
        if (this.udfParams != null) {
            /* 226 */
            txtParams.putAll(this.udfParams);

        }
        /* 228 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 232 */
        if (this.udfParams == null) {
            /* 233 */
            this.udfParams = new AlipayHashMap();

        }
        /* 235 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayUserMemberCardUpdateResponse> getResponseClass() {
        /* 239 */
        return AlipayUserMemberCardUpdateResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 245 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 251 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayUserMemberCardUpdateRequest
 * JD-Core Version:    0.6.0
 */