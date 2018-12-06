package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayMappprodAccountBindingSyncResponse;

import java.util.Map;


public class AlipayMappprodAccountBindingSyncRequest implements AlipayRequest<AlipayMappprodAccountBindingSyncResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String extInfo;
    private String userAccountNo;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /*  48 */   private boolean needEncrypt = false;


    public String getExtInfo() {
        /*  34 */
        return this.extInfo;

    }


    public void setExtInfo(String extInfo) {
        /*  31 */
        this.extInfo = extInfo;

    }


    public String getUserAccountNo() {
        /*  41 */
        return this.userAccountNo;

    }


    public void setUserAccountNo(String userAccountNo) {
        /*  38 */
        this.userAccountNo = userAccountNo;

    }


    public String getNotifyUrl() {
        /*  51 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /*  55 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /*  59 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /*  63 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /*  67 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /*  71 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /*  79 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /*  75 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /*  87 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /*  83 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /*  95 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /*  91 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /*  99 */
        return "alipay.mappprod.account.binding.sync";

    }


    public Map<String, String> getTextParams() {
        /* 103 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 104 */
        txtParams.put("ext_info", this.extInfo);
        /* 105 */
        txtParams.put("user_account_no", this.userAccountNo);
        /* 106 */
        if (this.udfParams != null) {
            /* 107 */
            txtParams.putAll(this.udfParams);

        }
        /* 109 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 113 */
        if (this.udfParams == null) {
            /* 114 */
            this.udfParams = new AlipayHashMap();

        }
        /* 116 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayMappprodAccountBindingSyncResponse> getResponseClass() {
        /* 120 */
        return AlipayMappprodAccountBindingSyncResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 126 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 132 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayMappprodAccountBindingSyncRequest
 * JD-Core Version:    0.6.0
 */