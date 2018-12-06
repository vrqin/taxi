package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayEbppPdeductPayResponse;

import java.util.Map;


public class AlipayEbppPdeductPayRequest implements AlipayRequest<AlipayEbppPdeductPayResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String agentChannel;
    private String agentCode;
    private String agreementId;
    private String billDate;
    private String billKey;
    private String extendField;
    private String fineAmount;
    private String memo;
    private String outOrderNo;
    private String payAmount;
    private String pid;
    private String userId;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /* 171 */   private boolean needEncrypt = false;


    public String getAgentChannel() {
        /*  87 */
        return this.agentChannel;

    }


    public void setAgentChannel(String agentChannel) {
        /*  84 */
        this.agentChannel = agentChannel;

    }


    public String getAgentCode() {
        /*  94 */
        return this.agentCode;

    }


    public void setAgentCode(String agentCode) {
        /*  91 */
        this.agentCode = agentCode;

    }


    public String getAgreementId() {
        /* 101 */
        return this.agreementId;

    }


    public void setAgreementId(String agreementId) {
        /*  98 */
        this.agreementId = agreementId;

    }


    public String getBillDate() {
        /* 108 */
        return this.billDate;

    }


    public void setBillDate(String billDate) {
        /* 105 */
        this.billDate = billDate;

    }


    public String getBillKey() {
        /* 115 */
        return this.billKey;

    }


    public void setBillKey(String billKey) {
        /* 112 */
        this.billKey = billKey;

    }


    public String getExtendField() {
        /* 122 */
        return this.extendField;

    }


    public void setExtendField(String extendField) {
        /* 119 */
        this.extendField = extendField;

    }


    public String getFineAmount() {
        /* 129 */
        return this.fineAmount;

    }


    public void setFineAmount(String fineAmount) {
        /* 126 */
        this.fineAmount = fineAmount;

    }


    public String getMemo() {
        /* 136 */
        return this.memo;

    }


    public void setMemo(String memo) {
        /* 133 */
        this.memo = memo;

    }


    public String getOutOrderNo() {
        /* 143 */
        return this.outOrderNo;

    }


    public void setOutOrderNo(String outOrderNo) {
        /* 140 */
        this.outOrderNo = outOrderNo;

    }


    public String getPayAmount() {
        /* 150 */
        return this.payAmount;

    }


    public void setPayAmount(String payAmount) {
        /* 147 */
        this.payAmount = payAmount;

    }


    public String getPid() {
        /* 157 */
        return this.pid;

    }


    public void setPid(String pid) {
        /* 154 */
        this.pid = pid;

    }


    public String getUserId() {
        /* 164 */
        return this.userId;

    }


    public void setUserId(String userId) {
        /* 161 */
        this.userId = userId;

    }


    public String getNotifyUrl() {
        /* 174 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /* 178 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /* 182 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /* 186 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /* 190 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /* 194 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /* 202 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /* 198 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /* 210 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /* 206 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /* 218 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 214 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 222 */
        return "alipay.ebpp.pdeduct.pay";

    }


    public Map<String, String> getTextParams() {
        /* 226 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 227 */
        txtParams.put("agent_channel", this.agentChannel);
        /* 228 */
        txtParams.put("agent_code", this.agentCode);
        /* 229 */
        txtParams.put("agreement_id", this.agreementId);
        /* 230 */
        txtParams.put("bill_date", this.billDate);
        /* 231 */
        txtParams.put("bill_key", this.billKey);
        /* 232 */
        txtParams.put("extend_field", this.extendField);
        /* 233 */
        txtParams.put("fine_amount", this.fineAmount);
        /* 234 */
        txtParams.put("memo", this.memo);
        /* 235 */
        txtParams.put("out_order_no", this.outOrderNo);
        /* 236 */
        txtParams.put("pay_amount", this.payAmount);
        /* 237 */
        txtParams.put("pid", this.pid);
        /* 238 */
        txtParams.put("user_id", this.userId);
        /* 239 */
        if (this.udfParams != null) {
            /* 240 */
            txtParams.putAll(this.udfParams);

        }
        /* 242 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 246 */
        if (this.udfParams == null) {
            /* 247 */
            this.udfParams = new AlipayHashMap();

        }
        /* 249 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayEbppPdeductPayResponse> getResponseClass() {
        /* 253 */
        return AlipayEbppPdeductPayResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 259 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 265 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayEbppPdeductPayRequest
 * JD-Core Version:    0.6.0
 */