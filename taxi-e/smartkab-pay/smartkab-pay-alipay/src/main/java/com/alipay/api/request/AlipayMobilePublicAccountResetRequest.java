package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayMobilePublicAccountResetResponse;

import java.util.Map;


public class AlipayMobilePublicAccountResetRequest implements AlipayRequest<AlipayMobilePublicAccountResetResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String agreementId;
    private String bindAccountNo;
    private String bizContent;
    private String displayName;
    private String fromUserId;
    private String realName;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /*  96 */   private boolean needEncrypt = false;


    public String getAgreementId() {
        /*  54 */
        return this.agreementId;

    }


    public void setAgreementId(String agreementId) {
        /*  51 */
        this.agreementId = agreementId;

    }


    public String getBindAccountNo() {
        /*  61 */
        return this.bindAccountNo;

    }


    public void setBindAccountNo(String bindAccountNo) {
        /*  58 */
        this.bindAccountNo = bindAccountNo;

    }


    public String getBizContent() {
        /*  68 */
        return this.bizContent;

    }


    public void setBizContent(String bizContent) {
        /*  65 */
        this.bizContent = bizContent;

    }


    public String getDisplayName() {
        /*  75 */
        return this.displayName;

    }


    public void setDisplayName(String displayName) {
        /*  72 */
        this.displayName = displayName;

    }


    public String getFromUserId() {
        /*  82 */
        return this.fromUserId;

    }


    public void setFromUserId(String fromUserId) {
        /*  79 */
        this.fromUserId = fromUserId;

    }


    public String getRealName() {
        /*  89 */
        return this.realName;

    }


    public void setRealName(String realName) {
        /*  86 */
        this.realName = realName;

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
        return "alipay.mobile.public.account.reset";

    }


    public Map<String, String> getTextParams() {
        /* 151 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 152 */
        txtParams.put("agreement_id", this.agreementId);
        /* 153 */
        txtParams.put("bind_account_no", this.bindAccountNo);
        /* 154 */
        txtParams.put("biz_content", this.bizContent);
        /* 155 */
        txtParams.put("display_name", this.displayName);
        /* 156 */
        txtParams.put("from_user_id", this.fromUserId);
        /* 157 */
        txtParams.put("real_name", this.realName);
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


    public Class<AlipayMobilePublicAccountResetResponse> getResponseClass() {
        /* 172 */
        return AlipayMobilePublicAccountResetResponse.class;

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
 * Qualified Name:     com.alipay.api.request.AlipayMobilePublicAccountResetRequest
 * JD-Core Version:    0.6.0
 */