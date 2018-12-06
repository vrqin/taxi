package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayEbppBillPayurlGetResponse;

import java.util.Map;


public class AlipayEbppBillPayurlGetRequest implements AlipayRequest<AlipayEbppBillPayurlGetResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String alipayOrderNo;
    private String callbackUrl;
    private String merchantOrderNo;
    private String orderType;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /*  72 */   private boolean needEncrypt = false;


    public String getAlipayOrderNo() {
        /*  44 */
        return this.alipayOrderNo;

    }


    public void setAlipayOrderNo(String alipayOrderNo) {
        /*  41 */
        this.alipayOrderNo = alipayOrderNo;

    }


    public String getCallbackUrl() {
        /*  51 */
        return this.callbackUrl;

    }


    public void setCallbackUrl(String callbackUrl) {
        /*  48 */
        this.callbackUrl = callbackUrl;

    }


    public String getMerchantOrderNo() {
        /*  58 */
        return this.merchantOrderNo;

    }


    public void setMerchantOrderNo(String merchantOrderNo) {
        /*  55 */
        this.merchantOrderNo = merchantOrderNo;

    }


    public String getOrderType() {
        /*  65 */
        return this.orderType;

    }


    public void setOrderType(String orderType) {
        /*  62 */
        this.orderType = orderType;

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
        return "alipay.ebpp.bill.payurl.get";

    }


    public Map<String, String> getTextParams() {
        /* 127 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 128 */
        txtParams.put("alipay_order_no", this.alipayOrderNo);
        /* 129 */
        txtParams.put("callback_url", this.callbackUrl);
        /* 130 */
        txtParams.put("merchant_order_no", this.merchantOrderNo);
        /* 131 */
        txtParams.put("order_type", this.orderType);
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


    public Class<AlipayEbppBillPayurlGetResponse> getResponseClass() {
        /* 146 */
        return AlipayEbppBillPayurlGetResponse.class;

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
 * Qualified Name:     com.alipay.api.request.AlipayEbppBillPayurlGetRequest
 * JD-Core Version:    0.6.0
 */