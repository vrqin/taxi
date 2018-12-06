package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayAcquireQueryResponse;

import java.util.Map;


public class AlipayAcquireQueryRequest implements AlipayRequest<AlipayAcquireQueryResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String outTradeNo;
    private String tradeNo;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /*  50 */   private boolean needEncrypt = false;


    public String getOutTradeNo() {
        /*  36 */
        return this.outTradeNo;

    }


    public void setOutTradeNo(String outTradeNo) {
        /*  33 */
        this.outTradeNo = outTradeNo;

    }


    public String getTradeNo() {
        /*  43 */
        return this.tradeNo;

    }


    public void setTradeNo(String tradeNo) {
        /*  40 */
        this.tradeNo = tradeNo;

    }


    public String getNotifyUrl() {
        /*  53 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /*  57 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /*  61 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /*  65 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /*  69 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /*  73 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /*  81 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /*  77 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /*  89 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /*  85 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /*  97 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /*  93 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 101 */
        return "alipay.acquire.query";

    }


    public Map<String, String> getTextParams() {
        /* 105 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 106 */
        txtParams.put("out_trade_no", this.outTradeNo);
        /* 107 */
        txtParams.put("trade_no", this.tradeNo);
        /* 108 */
        if (this.udfParams != null) {
            /* 109 */
            txtParams.putAll(this.udfParams);

        }
        /* 111 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 115 */
        if (this.udfParams == null) {
            /* 116 */
            this.udfParams = new AlipayHashMap();

        }
        /* 118 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayAcquireQueryResponse> getResponseClass() {
        /* 122 */
        return AlipayAcquireQueryResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 128 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 134 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayAcquireQueryRequest
 * JD-Core Version:    0.6.0
 */