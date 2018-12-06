package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayEbppBillBatchPayurlGetResponse;

import java.util.List;
import java.util.Map;


public class AlipayEbppBillBatchPayurlGetRequest implements AlipayRequest<AlipayEbppBillBatchPayurlGetResponse> {
    private AlipayHashMap udfParams;
    /*  19 */   private String apiVersion = "1.0";
    private String callbackUrl;
    private String orderType;
    private List<String> payBillList;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /*  61 */   private boolean needEncrypt = false;


    public String getCallbackUrl() {
        /*  40 */
        return this.callbackUrl;

    }


    public void setCallbackUrl(String callbackUrl) {
        /*  37 */
        this.callbackUrl = callbackUrl;

    }


    public String getOrderType() {
        /*  47 */
        return this.orderType;

    }


    public void setOrderType(String orderType) {
        /*  44 */
        this.orderType = orderType;

    }


    public List<String> getPayBillList() {
        /*  54 */
        return this.payBillList;

    }


    public void setPayBillList(List<String> payBillList) {
        /*  51 */
        this.payBillList = payBillList;

    }


    public String getNotifyUrl() {
        /*  64 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /*  68 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /*  72 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /*  76 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /*  80 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /*  84 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /*  92 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /*  88 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /* 100 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /*  96 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /* 108 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 104 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 112 */
        return "alipay.ebpp.bill.batch.payurl.get";

    }


    public Map<String, String> getTextParams() {
        /* 116 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 117 */
        txtParams.put("callback_url", this.callbackUrl);
        /* 118 */
        txtParams.put("order_type", this.orderType);
        /* 119 */
        txtParams.put("pay_bill_list", this.payBillList);
        /* 120 */
        if (this.udfParams != null) {
            /* 121 */
            txtParams.putAll(this.udfParams);

        }
        /* 123 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 127 */
        if (this.udfParams == null) {
            /* 128 */
            this.udfParams = new AlipayHashMap();

        }
        /* 130 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayEbppBillBatchPayurlGetResponse> getResponseClass() {
        /* 134 */
        return AlipayEbppBillBatchPayurlGetResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 140 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 146 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayEbppBillBatchPayurlGetRequest
 * JD-Core Version:    0.6.0
 */