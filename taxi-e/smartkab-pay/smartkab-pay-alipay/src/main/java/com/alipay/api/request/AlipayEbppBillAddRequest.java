package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayEbppBillAddResponse;

import java.util.Map;


public class AlipayEbppBillAddRequest implements AlipayRequest<AlipayEbppBillAddResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String bankBillNo;
    private String billDate;
    private String billKey;
    private String chargeInst;
    private String extendField;
    private String merchantOrderNo;
    private String mobile;
    private String orderType;
    private String ownerName;
    private String payAmount;
    private String serviceAmount;
    private String subOrderType;
    private String trafficLocation;
    private String trafficRegulations;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /* 192 */   private boolean needEncrypt = false;


    public String getBankBillNo() {
        /*  94 */
        return this.bankBillNo;

    }


    public void setBankBillNo(String bankBillNo) {
        /*  91 */
        this.bankBillNo = bankBillNo;

    }


    public String getBillDate() {
        /* 101 */
        return this.billDate;

    }


    public void setBillDate(String billDate) {
        /*  98 */
        this.billDate = billDate;

    }


    public String getBillKey() {
        /* 108 */
        return this.billKey;

    }


    public void setBillKey(String billKey) {
        /* 105 */
        this.billKey = billKey;

    }


    public String getChargeInst() {
        /* 115 */
        return this.chargeInst;

    }


    public void setChargeInst(String chargeInst) {
        /* 112 */
        this.chargeInst = chargeInst;

    }


    public String getExtendField() {
        /* 122 */
        return this.extendField;

    }


    public void setExtendField(String extendField) {
        /* 119 */
        this.extendField = extendField;

    }


    public String getMerchantOrderNo() {
        /* 129 */
        return this.merchantOrderNo;

    }


    public void setMerchantOrderNo(String merchantOrderNo) {
        /* 126 */
        this.merchantOrderNo = merchantOrderNo;

    }


    public String getMobile() {
        /* 136 */
        return this.mobile;

    }


    public void setMobile(String mobile) {
        /* 133 */
        this.mobile = mobile;

    }


    public String getOrderType() {
        /* 143 */
        return this.orderType;

    }


    public void setOrderType(String orderType) {
        /* 140 */
        this.orderType = orderType;

    }


    public String getOwnerName() {
        /* 150 */
        return this.ownerName;

    }


    public void setOwnerName(String ownerName) {
        /* 147 */
        this.ownerName = ownerName;

    }


    public String getPayAmount() {
        /* 157 */
        return this.payAmount;

    }


    public void setPayAmount(String payAmount) {
        /* 154 */
        this.payAmount = payAmount;

    }


    public String getServiceAmount() {
        /* 164 */
        return this.serviceAmount;

    }


    public void setServiceAmount(String serviceAmount) {
        /* 161 */
        this.serviceAmount = serviceAmount;

    }


    public String getSubOrderType() {
        /* 171 */
        return this.subOrderType;

    }


    public void setSubOrderType(String subOrderType) {
        /* 168 */
        this.subOrderType = subOrderType;

    }


    public String getTrafficLocation() {
        /* 178 */
        return this.trafficLocation;

    }


    public void setTrafficLocation(String trafficLocation) {
        /* 175 */
        this.trafficLocation = trafficLocation;

    }


    public String getTrafficRegulations() {
        /* 185 */
        return this.trafficRegulations;

    }


    public void setTrafficRegulations(String trafficRegulations) {
        /* 182 */
        this.trafficRegulations = trafficRegulations;

    }


    public String getNotifyUrl() {
        /* 195 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /* 199 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /* 203 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /* 207 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /* 211 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /* 215 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /* 223 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /* 219 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /* 231 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /* 227 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /* 239 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 235 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 243 */
        return "alipay.ebpp.bill.add";

    }


    public Map<String, String> getTextParams() {
        /* 247 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 248 */
        txtParams.put("bank_bill_no", this.bankBillNo);
        /* 249 */
        txtParams.put("bill_date", this.billDate);
        /* 250 */
        txtParams.put("bill_key", this.billKey);
        /* 251 */
        txtParams.put("charge_inst", this.chargeInst);
        /* 252 */
        txtParams.put("extend_field", this.extendField);
        /* 253 */
        txtParams.put("merchant_order_no", this.merchantOrderNo);
        /* 254 */
        txtParams.put("mobile", this.mobile);
        /* 255 */
        txtParams.put("order_type", this.orderType);
        /* 256 */
        txtParams.put("owner_name", this.ownerName);
        /* 257 */
        txtParams.put("pay_amount", this.payAmount);
        /* 258 */
        txtParams.put("service_amount", this.serviceAmount);
        /* 259 */
        txtParams.put("sub_order_type", this.subOrderType);
        /* 260 */
        txtParams.put("traffic_location", this.trafficLocation);
        /* 261 */
        txtParams.put("traffic_regulations", this.trafficRegulations);
        /* 262 */
        if (this.udfParams != null) {
            /* 263 */
            txtParams.putAll(this.udfParams);

        }
        /* 265 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 269 */
        if (this.udfParams == null) {
            /* 270 */
            this.udfParams = new AlipayHashMap();

        }
        /* 272 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayEbppBillAddResponse> getResponseClass() {
        /* 276 */
        return AlipayEbppBillAddResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 282 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 288 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayEbppBillAddRequest
 * JD-Core Version:    0.6.0
 */