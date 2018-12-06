package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayAcquireCancelResponse;

import java.util.Map;


public class AlipayAcquireCancelRequest implements AlipayRequest<AlipayAcquireCancelResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String operatorId;
    private String operatorType;
    private String outTradeNo;
    private String tradeNo;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /*  77 */   private boolean needEncrypt = false;


    public String getOperatorId() {
        /*  49 */
        return this.operatorId;

    }


    public void setOperatorId(String operatorId) {
        /*  46 */
        this.operatorId = operatorId;

    }


    public String getOperatorType() {
        /*  56 */
        return this.operatorType;

    }


    public void setOperatorType(String operatorType) {
        /*  53 */
        this.operatorType = operatorType;

    }


    public String getOutTradeNo() {
        /*  63 */
        return this.outTradeNo;

    }


    public void setOutTradeNo(String outTradeNo) {
        /*  60 */
        this.outTradeNo = outTradeNo;

    }


    public String getTradeNo() {
        /*  70 */
        return this.tradeNo;

    }


    public void setTradeNo(String tradeNo) {
        /*  67 */
        this.tradeNo = tradeNo;

    }


    public String getNotifyUrl() {
        /*  80 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /*  84 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /*  88 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /*  92 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /*  96 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /* 100 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /* 108 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /* 104 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /* 116 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /* 112 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /* 124 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 120 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 128 */
        return "alipay.acquire.cancel";

    }


    public Map<String, String> getTextParams() {
        /* 132 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 133 */
        txtParams.put("operator_id", this.operatorId);
        /* 134 */
        txtParams.put("operator_type", this.operatorType);
        /* 135 */
        txtParams.put("out_trade_no", this.outTradeNo);
        /* 136 */
        txtParams.put("trade_no", this.tradeNo);
        /* 137 */
        if (this.udfParams != null) {
            /* 138 */
            txtParams.putAll(this.udfParams);

        }
        /* 140 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 144 */
        if (this.udfParams == null) {
            /* 145 */
            this.udfParams = new AlipayHashMap();

        }
        /* 147 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayAcquireCancelResponse> getResponseClass() {
        /* 151 */
        return AlipayAcquireCancelResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 157 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 163 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayAcquireCancelRequest
 * JD-Core Version:    0.6.0
 */