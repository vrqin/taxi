package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayEbppPdeductSignAddResponse;

import java.util.Map;


public class AlipayEbppPdeductSignAddRequest implements AlipayRequest<AlipayEbppPdeductSignAddResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String agentChannel;
    private String agentCode;
    private String billKey;
    private String bizType;
    private String chargeInst;
    private String deductType;
    private String extendField;
    private String notifyConfig;
    private String outAgreementId;
    private String ownerName;
    private String payConfig;
    private String payPasswordToken;
    private String pid;
    private String signExpireDate;
    private String subBizType;
    private String userId;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /* 230 */   private boolean needEncrypt = false;


    public String getAgentChannel() {
        /* 118 */
        return this.agentChannel;

    }


    public void setAgentChannel(String agentChannel) {
        /* 115 */
        this.agentChannel = agentChannel;

    }


    public String getAgentCode() {
        /* 125 */
        return this.agentCode;

    }


    public void setAgentCode(String agentCode) {
        /* 122 */
        this.agentCode = agentCode;

    }


    public String getBillKey() {
        /* 132 */
        return this.billKey;

    }


    public void setBillKey(String billKey) {
        /* 129 */
        this.billKey = billKey;

    }


    public String getBizType() {
        /* 139 */
        return this.bizType;

    }


    public void setBizType(String bizType) {
        /* 136 */
        this.bizType = bizType;

    }


    public String getChargeInst() {
        /* 146 */
        return this.chargeInst;

    }


    public void setChargeInst(String chargeInst) {
        /* 143 */
        this.chargeInst = chargeInst;

    }


    public String getDeductType() {
        /* 153 */
        return this.deductType;

    }


    public void setDeductType(String deductType) {
        /* 150 */
        this.deductType = deductType;

    }


    public String getExtendField() {
        /* 160 */
        return this.extendField;

    }


    public void setExtendField(String extendField) {
        /* 157 */
        this.extendField = extendField;

    }


    public String getNotifyConfig() {
        /* 167 */
        return this.notifyConfig;

    }


    public void setNotifyConfig(String notifyConfig) {
        /* 164 */
        this.notifyConfig = notifyConfig;

    }


    public String getOutAgreementId() {
        /* 174 */
        return this.outAgreementId;

    }


    public void setOutAgreementId(String outAgreementId) {
        /* 171 */
        this.outAgreementId = outAgreementId;

    }


    public String getOwnerName() {
        /* 181 */
        return this.ownerName;

    }


    public void setOwnerName(String ownerName) {
        /* 178 */
        this.ownerName = ownerName;

    }


    public String getPayConfig() {
        /* 188 */
        return this.payConfig;

    }


    public void setPayConfig(String payConfig) {
        /* 185 */
        this.payConfig = payConfig;

    }


    public String getPayPasswordToken() {
        /* 195 */
        return this.payPasswordToken;

    }


    public void setPayPasswordToken(String payPasswordToken) {
        /* 192 */
        this.payPasswordToken = payPasswordToken;

    }


    public String getPid() {
        /* 202 */
        return this.pid;

    }


    public void setPid(String pid) {
        /* 199 */
        this.pid = pid;

    }


    public String getSignExpireDate() {
        /* 209 */
        return this.signExpireDate;

    }


    public void setSignExpireDate(String signExpireDate) {
        /* 206 */
        this.signExpireDate = signExpireDate;

    }


    public String getSubBizType() {
        /* 216 */
        return this.subBizType;

    }


    public void setSubBizType(String subBizType) {
        /* 213 */
        this.subBizType = subBizType;

    }


    public String getUserId() {
        /* 223 */
        return this.userId;

    }


    public void setUserId(String userId) {
        /* 220 */
        this.userId = userId;

    }


    public String getNotifyUrl() {
        /* 233 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /* 237 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /* 241 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /* 245 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /* 249 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /* 253 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /* 261 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /* 257 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /* 269 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /* 265 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /* 277 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 273 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 281 */
        return "alipay.ebpp.pdeduct.sign.add";

    }


    public Map<String, String> getTextParams() {
        /* 285 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 286 */
        txtParams.put("agent_channel", this.agentChannel);
        /* 287 */
        txtParams.put("agent_code", this.agentCode);
        /* 288 */
        txtParams.put("bill_key", this.billKey);
        /* 289 */
        txtParams.put("biz_type", this.bizType);
        /* 290 */
        txtParams.put("charge_inst", this.chargeInst);
        /* 291 */
        txtParams.put("deduct_type", this.deductType);
        /* 292 */
        txtParams.put("extend_field", this.extendField);
        /* 293 */
        txtParams.put("notify_config", this.notifyConfig);
        /* 294 */
        txtParams.put("out_agreement_id", this.outAgreementId);
        /* 295 */
        txtParams.put("owner_name", this.ownerName);
        /* 296 */
        txtParams.put("pay_config", this.payConfig);
        /* 297 */
        txtParams.put("pay_password_token", this.payPasswordToken);
        /* 298 */
        txtParams.put("pid", this.pid);
        /* 299 */
        txtParams.put("sign_expire_date", this.signExpireDate);
        /* 300 */
        txtParams.put("sub_biz_type", this.subBizType);
        /* 301 */
        txtParams.put("user_id", this.userId);
        /* 302 */
        if (this.udfParams != null) {
            /* 303 */
            txtParams.putAll(this.udfParams);

        }
        /* 305 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 309 */
        if (this.udfParams == null) {
            /* 310 */
            this.udfParams = new AlipayHashMap();

        }
        /* 312 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayEbppPdeductSignAddResponse> getResponseClass() {
        /* 316 */
        return AlipayEbppPdeductSignAddResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 322 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 328 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayEbppPdeductSignAddRequest
 * JD-Core Version:    0.6.0
 */