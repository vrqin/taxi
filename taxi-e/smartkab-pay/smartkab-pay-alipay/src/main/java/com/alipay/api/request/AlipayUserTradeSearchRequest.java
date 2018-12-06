package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayUserTradeSearchResponse;

import java.util.Map;


public class AlipayUserTradeSearchRequest implements AlipayRequest<AlipayUserTradeSearchResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String alipayOrderNo;
    private String endTime;
    private String merchantOrderNo;
    private String orderFrom;
    private String orderStatus;
    private String orderType;
    private String pageNo;
    private String pageSize;
    private String startTime;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /* 132 */   private boolean needEncrypt = false;


    public String getAlipayOrderNo() {
        /*  69 */
        return this.alipayOrderNo;

    }


    public void setAlipayOrderNo(String alipayOrderNo) {
        /*  66 */
        this.alipayOrderNo = alipayOrderNo;

    }


    public String getEndTime() {
        /*  76 */
        return this.endTime;

    }


    public void setEndTime(String endTime) {
        /*  73 */
        this.endTime = endTime;

    }


    public String getMerchantOrderNo() {
        /*  83 */
        return this.merchantOrderNo;

    }


    public void setMerchantOrderNo(String merchantOrderNo) {
        /*  80 */
        this.merchantOrderNo = merchantOrderNo;

    }


    public String getOrderFrom() {
        /*  90 */
        return this.orderFrom;

    }


    public void setOrderFrom(String orderFrom) {
        /*  87 */
        this.orderFrom = orderFrom;

    }


    public String getOrderStatus() {
        /*  97 */
        return this.orderStatus;

    }


    public void setOrderStatus(String orderStatus) {
        /*  94 */
        this.orderStatus = orderStatus;

    }


    public String getOrderType() {
        /* 104 */
        return this.orderType;

    }


    public void setOrderType(String orderType) {
        /* 101 */
        this.orderType = orderType;

    }


    public String getPageNo() {
        /* 111 */
        return this.pageNo;

    }


    public void setPageNo(String pageNo) {
        /* 108 */
        this.pageNo = pageNo;

    }


    public String getPageSize() {
        /* 118 */
        return this.pageSize;

    }


    public void setPageSize(String pageSize) {
        /* 115 */
        this.pageSize = pageSize;

    }


    public String getStartTime() {
        /* 125 */
        return this.startTime;

    }


    public void setStartTime(String startTime) {
        /* 122 */
        this.startTime = startTime;

    }


    public String getNotifyUrl() {
        /* 135 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /* 139 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /* 143 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /* 147 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /* 151 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /* 155 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /* 163 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /* 159 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /* 171 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /* 167 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /* 179 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 175 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 183 */
        return "alipay.user.trade.search";

    }


    public Map<String, String> getTextParams() {
        /* 187 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 188 */
        txtParams.put("alipay_order_no", this.alipayOrderNo);
        /* 189 */
        txtParams.put("end_time", this.endTime);
        /* 190 */
        txtParams.put("merchant_order_no", this.merchantOrderNo);
        /* 191 */
        txtParams.put("order_from", this.orderFrom);
        /* 192 */
        txtParams.put("order_status", this.orderStatus);
        /* 193 */
        txtParams.put("order_type", this.orderType);
        /* 194 */
        txtParams.put("page_no", this.pageNo);
        /* 195 */
        txtParams.put("page_size", this.pageSize);
        /* 196 */
        txtParams.put("start_time", this.startTime);
        /* 197 */
        if (this.udfParams != null) {
            /* 198 */
            txtParams.putAll(this.udfParams);

        }
        /* 200 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 204 */
        if (this.udfParams == null) {
            /* 205 */
            this.udfParams = new AlipayHashMap();

        }
        /* 207 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayUserTradeSearchResponse> getResponseClass() {
        /* 211 */
        return AlipayUserTradeSearchResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 217 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 223 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayUserTradeSearchRequest
 * JD-Core Version:    0.6.0
 */