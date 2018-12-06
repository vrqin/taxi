package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayAcquireRefundResponse;

import java.util.Map;


public class AlipayAcquireRefundRequest implements AlipayRequest<AlipayAcquireRefundResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String operatorId;
    private String operatorType;
    private String outRequestNo;
    private String outTradeNo;
    private String refIds;
    private String refundAmount;
    private String refundReason;
    private String tradeNo;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /* 126 */   private boolean needEncrypt = false;


    public String getOperatorId() {
        /*  70 */
        return this.operatorId;

    }


    public void setOperatorId(String operatorId) {
        /*  67 */
        this.operatorId = operatorId;

    }


    public String getOperatorType() {
        /*  77 */
        return this.operatorType;

    }


    public void setOperatorType(String operatorType) {
        /*  74 */
        this.operatorType = operatorType;

    }


    public String getOutRequestNo() {
        /*  84 */
        return this.outRequestNo;

    }


    public void setOutRequestNo(String outRequestNo) {
        /*  81 */
        this.outRequestNo = outRequestNo;

    }


    public String getOutTradeNo() {
        /*  91 */
        return this.outTradeNo;

    }


    public void setOutTradeNo(String outTradeNo) {
        /*  88 */
        this.outTradeNo = outTradeNo;

    }


    public String getRefIds() {
        /*  98 */
        return this.refIds;

    }


    public void setRefIds(String refIds) {
        /*  95 */
        this.refIds = refIds;

    }


    public String getRefundAmount() {
        /* 105 */
        return this.refundAmount;

    }


    public void setRefundAmount(String refundAmount) {
        /* 102 */
        this.refundAmount = refundAmount;

    }


    public String getRefundReason() {
        /* 112 */
        return this.refundReason;

    }


    public void setRefundReason(String refundReason) {
        /* 109 */
        this.refundReason = refundReason;

    }


    public String getTradeNo() {
        /* 119 */
        return this.tradeNo;

    }


    public void setTradeNo(String tradeNo) {
        /* 116 */
        this.tradeNo = tradeNo;

    }


    public String getNotifyUrl() {
        /* 129 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /* 133 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /* 137 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /* 141 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /* 145 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /* 149 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /* 157 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /* 153 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /* 165 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /* 161 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /* 173 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 169 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 177 */
        return "alipay.acquire.refund";

    }


    public Map<String, String> getTextParams() {
        /* 181 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 182 */
        txtParams.put("operator_id", this.operatorId);
        /* 183 */
        txtParams.put("operator_type", this.operatorType);
        /* 184 */
        txtParams.put("out_request_no", this.outRequestNo);
        /* 185 */
        txtParams.put("out_trade_no", this.outTradeNo);
        /* 186 */
        txtParams.put("ref_ids", this.refIds);
        /* 187 */
        txtParams.put("refund_amount", this.refundAmount);
        /* 188 */
        txtParams.put("refund_reason", this.refundReason);
        /* 189 */
        txtParams.put("trade_no", this.tradeNo);
        /* 190 */
        if (this.udfParams != null) {
            /* 191 */
            txtParams.putAll(this.udfParams);

        }
        /* 193 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 197 */
        if (this.udfParams == null) {
            /* 198 */
            this.udfParams = new AlipayHashMap();

        }
        /* 200 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayAcquireRefundResponse> getResponseClass() {
        /* 204 */
        return AlipayAcquireRefundResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 210 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 216 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayAcquireRefundRequest
 * JD-Core Version:    0.6.0
 */