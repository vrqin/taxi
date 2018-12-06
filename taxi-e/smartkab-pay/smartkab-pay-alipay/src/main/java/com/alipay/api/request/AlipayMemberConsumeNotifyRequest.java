package com.alipay.api.request;


import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayMemberConsumeNotifyResponse;

import java.util.Map;


public class AlipayMemberConsumeNotifyRequest implements AlipayRequest<AlipayMemberConsumeNotifyResponse> {
    private AlipayHashMap udfParams;
    /*  18 */   private String apiVersion = "1.0";
    private String actPayAmount;
    private String bizCardNo;
    private String cardInfo;
    private String externalCardNo;
    private String gainBenefitList;
    private String memo;
    private String shopCode;
    private String swipeCertType;
    private String tradeAmount;
    private String tradeName;
    private String tradeNo;
    private String tradeTime;
    private String tradeType;
    private String useBenefitList;
    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    /* 220 */   private boolean needEncrypt = false;


    public String getActPayAmount() {
        /* 122 */
        return this.actPayAmount;

    }


    public void setActPayAmount(String actPayAmount) {
        /* 119 */
        this.actPayAmount = actPayAmount;

    }


    public String getBizCardNo() {
        /* 129 */
        return this.bizCardNo;

    }


    public void setBizCardNo(String bizCardNo) {
        /* 126 */
        this.bizCardNo = bizCardNo;

    }


    public String getCardInfo() {
        /* 136 */
        return this.cardInfo;

    }


    public void setCardInfo(String cardInfo) {
        /* 133 */
        this.cardInfo = cardInfo;

    }


    public String getExternalCardNo() {
        /* 143 */
        return this.externalCardNo;

    }


    public void setExternalCardNo(String externalCardNo) {
        /* 140 */
        this.externalCardNo = externalCardNo;

    }


    public String getGainBenefitList() {
        /* 150 */
        return this.gainBenefitList;

    }


    public void setGainBenefitList(String gainBenefitList) {
        /* 147 */
        this.gainBenefitList = gainBenefitList;

    }


    public String getMemo() {
        /* 157 */
        return this.memo;

    }


    public void setMemo(String memo) {
        /* 154 */
        this.memo = memo;

    }


    public String getShopCode() {
        /* 164 */
        return this.shopCode;

    }


    public void setShopCode(String shopCode) {
        /* 161 */
        this.shopCode = shopCode;

    }


    public String getSwipeCertType() {
        /* 171 */
        return this.swipeCertType;

    }


    public void setSwipeCertType(String swipeCertType) {
        /* 168 */
        this.swipeCertType = swipeCertType;

    }


    public String getTradeAmount() {
        /* 178 */
        return this.tradeAmount;

    }


    public void setTradeAmount(String tradeAmount) {
        /* 175 */
        this.tradeAmount = tradeAmount;

    }


    public String getTradeName() {
        /* 185 */
        return this.tradeName;

    }


    public void setTradeName(String tradeName) {
        /* 182 */
        this.tradeName = tradeName;

    }


    public String getTradeNo() {
        /* 192 */
        return this.tradeNo;

    }


    public void setTradeNo(String tradeNo) {
        /* 189 */
        this.tradeNo = tradeNo;

    }


    public String getTradeTime() {
        /* 199 */
        return this.tradeTime;

    }


    public void setTradeTime(String tradeTime) {
        /* 196 */
        this.tradeTime = tradeTime;

    }


    public String getTradeType() {
        /* 206 */
        return this.tradeType;

    }


    public void setTradeType(String tradeType) {
        /* 203 */
        this.tradeType = tradeType;

    }


    public String getUseBenefitList() {
        /* 213 */
        return this.useBenefitList;

    }


    public void setUseBenefitList(String useBenefitList) {
        /* 210 */
        this.useBenefitList = useBenefitList;

    }


    public String getNotifyUrl() {
        /* 223 */
        return this.notifyUrl;

    }


    public void setNotifyUrl(String notifyUrl) {
        /* 227 */
        this.notifyUrl = notifyUrl;

    }


    public String getReturnUrl() {
        /* 231 */
        return this.returnUrl;

    }


    public void setReturnUrl(String returnUrl) {
        /* 235 */
        this.returnUrl = returnUrl;

    }


    public String getApiVersion() {
        /* 239 */
        return this.apiVersion;

    }


    public void setApiVersion(String apiVersion) {
        /* 243 */
        this.apiVersion = apiVersion;

    }


    public String getTerminalType() {
        /* 251 */
        return this.terminalType;

    }


    public void setTerminalType(String terminalType) {
        /* 247 */
        this.terminalType = terminalType;

    }


    public String getTerminalInfo() {
        /* 259 */
        return this.terminalInfo;

    }


    public void setTerminalInfo(String terminalInfo) {
        /* 255 */
        this.terminalInfo = terminalInfo;

    }


    public String getProdCode() {
        /* 267 */
        return this.prodCode;

    }


    public void setProdCode(String prodCode) {
        /* 263 */
        this.prodCode = prodCode;

    }


    public String getApiMethodName() {
        /* 271 */
        return "alipay.member.consume.notify";

    }


    public Map<String, String> getTextParams() {
        /* 275 */
        AlipayHashMap txtParams = new AlipayHashMap();
        /* 276 */
        txtParams.put("act_pay_amount", this.actPayAmount);
        /* 277 */
        txtParams.put("biz_card_no", this.bizCardNo);
        /* 278 */
        txtParams.put("card_info", this.cardInfo);
        /* 279 */
        txtParams.put("external_card_no", this.externalCardNo);
        /* 280 */
        txtParams.put("gain_benefit_list", this.gainBenefitList);
        /* 281 */
        txtParams.put("memo", this.memo);
        /* 282 */
        txtParams.put("shop_code", this.shopCode);
        /* 283 */
        txtParams.put("swipe_cert_type", this.swipeCertType);
        /* 284 */
        txtParams.put("trade_amount", this.tradeAmount);
        /* 285 */
        txtParams.put("trade_name", this.tradeName);
        /* 286 */
        txtParams.put("trade_no", this.tradeNo);
        /* 287 */
        txtParams.put("trade_time", this.tradeTime);
        /* 288 */
        txtParams.put("trade_type", this.tradeType);
        /* 289 */
        txtParams.put("use_benefit_list", this.useBenefitList);
        /* 290 */
        if (this.udfParams != null) {
            /* 291 */
            txtParams.putAll(this.udfParams);

        }
        /* 293 */
        return txtParams;

    }


    public void putOtherTextParam(String key, String value) {
        /* 297 */
        if (this.udfParams == null) {
            /* 298 */
            this.udfParams = new AlipayHashMap();

        }
        /* 300 */
        this.udfParams.put(key, value);

    }


    public Class<AlipayMemberConsumeNotifyResponse> getResponseClass() {
        /* 304 */
        return AlipayMemberConsumeNotifyResponse.class;

    }


    public boolean isNeedEncrypt() {
        /* 310 */
        return this.needEncrypt;

    }


    public void setNeedEncrypt(boolean needEncrypt) {
        /* 316 */
        this.needEncrypt = needEncrypt;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.request.AlipayMemberConsumeNotifyRequest
 * JD-Core Version:    0.6.0
 */