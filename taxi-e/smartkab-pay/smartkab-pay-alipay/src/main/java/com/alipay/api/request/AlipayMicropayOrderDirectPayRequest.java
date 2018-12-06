package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayMicropayOrderDirectPayResponse;

import java.util.Map;


public class AlipayMicropayOrderDirectPayRequest implements AlipayRequest<AlipayMicropayOrderDirectPayResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String alipayOrderNo;
    private String amount;
    private String memo;
    private String receiveUserId;
    private String transferOutOrderNo;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /*  84 */   private boolean needEncrypt = false;


    public String getAlipayOrderNo() {
        /*  49 */
        return this.alipayOrderNo;

    }


    public void setAlipayOrderNo(String alipayOrderNo) {
        /*  46 */
        this.alipayOrderNo = alipayOrderNo;

    }


    public String getAmount() {
        /*  56 */
        return this.amount;

    }


    public void setAmount(String amount) {
        /*  53 */
        this.amount = amount;

    }


    public String getMemo() {
        /*  63 */
        return this.memo;

    }


    public void setMemo(String memo) {
        /*  60 */
        this.memo = memo;

    }


    public String getReceiveUserId() {
        /*  70 */
        return this.receiveUserId;

    }


    public void setReceiveUserId(String receiveUserId) {
        /*  67 */
        this.receiveUserId = receiveUserId;

    }


    public String getTransferOutOrderNo() {
        /*  77 */
        return this.transferOutOrderNo;

    }


    public void setTransferOutOrderNo(String transferOutOrderNo) {
        /*  74 */
        this.transferOutOrderNo = transferOutOrderNo;

    }


    public String getNotifyUrl() {
        /*  87 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /*  91 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /*  95 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /*  99 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /* 103 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /* 107 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /* 115 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /* 111 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /* 123 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /* 119 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /* 131 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 127 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 135 */
        return "alipay.micropay.order.direct.pay";

    }


    public Map<String, String> getTextParams() {
        /* 139 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 140 */
        txtParams.put("alipay_order_no", this.alipayOrderNo);
        /* 141 */
        txtParams.put("amount", this.amount);
        /* 142 */
        txtParams.put("memo", this.memo);
        /* 143 */
        txtParams.put("receive_user_id", this.receiveUserId);
        /* 144 */
        txtParams.put("transfer_out_order_no", this.transferOutOrderNo);
        /* 145 */
        if (this.udfParams != null) {
            /* 146 */
            txtParams.putAll(this.udfParams);

        }
        /* 148 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 152 */
        if (this.udfParams == null) {
            /* 153 */
            this.udfParams = new AlipayHashMap();

        }
        /* 155 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayMicropayOrderDirectPayResponse> getResponseClass() {
        /* 159 */
        return AlipayMicropayOrderDirectPayResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 165 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 171 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayMicropayOrderDirectPayRequest
 * JD-Core Version:    0.6.0
 */