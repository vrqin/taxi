package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayPointOrderGetResponse;

import java.util.Map;


public class AlipayPointOrderGetRequest implements AlipayRequest<AlipayPointOrderGetResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String merchantOrderNo;
    private String userSymbol;
    private String userSymbolType;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /*  60 */   private boolean needEncrypt = false;


    public String getMerchantOrderNo() {
        /*  39 */
        return this.merchantOrderNo;

    }


    public void setMerchantOrderNo(String merchantOrderNo) {
        /*  36 */
        this.merchantOrderNo = merchantOrderNo;

    }


    public String getUserSymbol() {
        /*  46 */
        return this.userSymbol;

    }


    public void setUserSymbol(String userSymbol) {
        /*  43 */
        this.userSymbol = userSymbol;

    }


    public String getUserSymbolType() {
        /*  53 */
        return this.userSymbolType;

    }


    public void setUserSymbolType(String userSymbolType) {
        /*  50 */
        this.userSymbolType = userSymbolType;

    }


    public String getNotifyUrl() {
        /*  63 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /*  67 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /*  71 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /*  75 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /*  79 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /*  83 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /*  91 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /*  87 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /*  99 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /*  95 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /* 107 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 103 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 111 */
        return "alipay.point.order.get";

    }


    public Map<String, String> getTextParams() {
        /* 115 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 116 */
        txtParams.put("merchant_order_no", this.merchantOrderNo);
        /* 117 */
        txtParams.put("user_symbol", this.userSymbol);
        /* 118 */
        txtParams.put("user_symbol_type", this.userSymbolType);
        /* 119 */
        if (this.udfParams != null) {
            /* 120 */
            txtParams.putAll(this.udfParams);

        }
        /* 122 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 126 */
        if (this.udfParams == null) {
            /* 127 */
            this.udfParams = new AlipayHashMap();

        }
        /* 129 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayPointOrderGetResponse> getResponseClass() {
        /* 133 */
        return AlipayPointOrderGetResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 139 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 145 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayPointOrderGetRequest
 * JD-Core Version:    0.6.0
 */