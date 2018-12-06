package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayPassSyncAddResponse;

import java.util.Map;


public class AlipayPassSyncAddRequest implements AlipayRequest<AlipayPassSyncAddResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String fileContent;
    private String outTradeNo;
    private String partnerId;
    private String userId;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /*  72 */   private boolean needEncrypt = false;


    public String getFileContent() {
        /*  44 */
        return this.fileContent;

    }


    public void setFileContent(String fileContent) {
        /*  41 */
        this.fileContent = fileContent;

    }


    public String getOutTradeNo() {
        /*  51 */
        return this.outTradeNo;

    }


    public void setOutTradeNo(String outTradeNo) {
        /*  48 */
        this.outTradeNo = outTradeNo;

    }


    public String getPartnerId() {
        /*  58 */
        return this.partnerId;

    }


    public void setPartnerId(String partnerId) {
        /*  55 */
        this.partnerId = partnerId;

    }


    public String getUserId() {
        /*  65 */
        return this.userId;

    }


    public void setUserId(String userId) {
        /*  62 */
        this.userId = userId;

    }


    public String getNotifyUrl() {
        /*  75 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /*  79 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /*  83 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /*  87 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /*  91 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /*  95 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /* 103 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /*  99 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /* 111 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /* 107 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /* 119 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 115 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 123 */
        return "alipay.pass.sync.add";

    }


    public Map<String, String> getTextParams() {
        /* 127 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 128 */
        txtParams.put("file_content", this.fileContent);
        /* 129 */
        txtParams.put("out_trade_no", this.outTradeNo);
        /* 130 */
        txtParams.put("partner_id", this.partnerId);
        /* 131 */
        txtParams.put("user_id", this.userId);
        /* 132 */
        if (this.udfParams != null) {
            /* 133 */
            txtParams.putAll(this.udfParams);

        }
        /* 135 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 139 */
        if (this.udfParams == null) {
            /* 140 */
            this.udfParams = new AlipayHashMap();

        }
        /* 142 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayPassSyncAddResponse> getResponseClass() {
        /* 146 */
        return AlipayPassSyncAddResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 152 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 158 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayPassSyncAddRequest
 * JD-Core Version:    0.6.0
 */