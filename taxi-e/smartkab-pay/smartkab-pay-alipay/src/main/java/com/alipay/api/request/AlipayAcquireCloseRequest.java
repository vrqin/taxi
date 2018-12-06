package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayAcquireCloseResponse;

import java.util.Map;


public class AlipayAcquireCloseRequest implements AlipayRequest<AlipayAcquireCloseResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String operatorId;
    private String outTradeNo;
    private String tradeNo;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /*  62 */   private boolean needEncrypt = false;


    public String getOperatorId() {
        /*  41 */
        return this.operatorId;

    }


    public void setOperatorId(String operatorId) {
        /*  38 */
        this.operatorId = operatorId;

    }


    public String getOutTradeNo() {
        /*  48 */
        return this.outTradeNo;

    }


    public void setOutTradeNo(String outTradeNo) {
        /*  45 */
        this.outTradeNo = outTradeNo;

    }


    public String getTradeNo() {
        /*  55 */
        return this.tradeNo;

    }


    public void setTradeNo(String tradeNo) {
        /*  52 */
        this.tradeNo = tradeNo;

    }


    public String getNotifyUrl() {
        /*  65 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /*  69 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /*  73 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /*  77 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /*  81 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /*  85 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /*  93 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /*  89 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /* 101 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /*  97 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /* 109 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 105 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 113 */
        return "alipay.acquire.close";

    }


    public Map<String, String> getTextParams() {
        /* 117 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 118 */
        txtParams.put("operator_id", this.operatorId);
        /* 119 */
        txtParams.put("out_trade_no", this.outTradeNo);
        /* 120 */
        txtParams.put("trade_no", this.tradeNo);
        /* 121 */
        if (this.udfParams != null) {
            /* 122 */
            txtParams.putAll(this.udfParams);

        }
        /* 124 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 128 */
        if (this.udfParams == null) {
            /* 129 */
            this.udfParams = new AlipayHashMap();

        }
        /* 131 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayAcquireCloseResponse> getResponseClass() {
        /* 135 */
        return AlipayAcquireCloseResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 141 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 147 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayAcquireCloseRequest
 * JD-Core Version:    0.6.0
 */