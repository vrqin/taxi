package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.Date;
import java.util.List;


public class AlipayMarketingCardConsumenotifyModel extends AlipayObject {
    private static final long serialVersionUID = 2183119297864356266L;


    @ApiField("act_pay_amount")
    private String actPayAmount;


    @ApiField("card_info")
    private MerchantCard cardInfo;


    @ApiListField("gain_benefit_list")

    @ApiField("benefit_info_detail")
    private List<BenefitInfoDetail> gainBenefitList;


    @ApiField("memo")
    private String memo;


    @ApiField("shop_code")
    private String shopCode;


    @ApiField("swipe_cert_type")
    private String swipeCertType;


    @ApiField("target_card_no")
    private String targetCardNo;


    @ApiField("target_card_no_type")
    private String targetCardNoType;


    @ApiField("trade_amount")
    private String tradeAmount;


    @ApiField("trade_name")
    private String tradeName;


    @ApiField("trade_no")
    private String tradeNo;


    @ApiField("trade_time")
    private Date tradeTime;


    @ApiField("trade_type")
    private String tradeType;


    @ApiListField("use_benefit_list")

    @ApiField("benefit_info_detail")
    private List<BenefitInfoDetail> useBenefitList;


    public String getActPayAmount() {
        /* 118 */
        return this.actPayAmount;

    }


    public void setActPayAmount(String actPayAmount) {
        /* 121 */
        this.actPayAmount = actPayAmount;

    }


    public MerchantCard getCardInfo() {
        /* 125 */
        return this.cardInfo;

    }


    public void setCardInfo(MerchantCard cardInfo) {
        /* 128 */
        this.cardInfo = cardInfo;

    }


    public List<BenefitInfoDetail> getGainBenefitList() {
        /* 132 */
        return this.gainBenefitList;

    }


    public void setGainBenefitList(List<BenefitInfoDetail> gainBenefitList) {
        /* 135 */
        this.gainBenefitList = gainBenefitList;

    }


    public String getMemo() {
        /* 139 */
        return this.memo;

    }


    public void setMemo(String memo) {
        /* 142 */
        this.memo = memo;

    }


    public String getShopCode() {
        /* 146 */
        return this.shopCode;

    }


    public void setShopCode(String shopCode) {
        /* 149 */
        this.shopCode = shopCode;

    }


    public String getSwipeCertType() {
        /* 153 */
        return this.swipeCertType;

    }


    public void setSwipeCertType(String swipeCertType) {
        /* 156 */
        this.swipeCertType = swipeCertType;

    }


    public String getTargetCardNo() {
        /* 160 */
        return this.targetCardNo;

    }


    public void setTargetCardNo(String targetCardNo) {
        /* 163 */
        this.targetCardNo = targetCardNo;

    }


    public String getTargetCardNoType() {
        /* 167 */
        return this.targetCardNoType;

    }


    public void setTargetCardNoType(String targetCardNoType) {
        /* 170 */
        this.targetCardNoType = targetCardNoType;

    }


    public String getTradeAmount() {
        /* 174 */
        return this.tradeAmount;

    }


    public void setTradeAmount(String tradeAmount) {
        /* 177 */
        this.tradeAmount = tradeAmount;

    }


    public String getTradeName() {
        /* 181 */
        return this.tradeName;

    }


    public void setTradeName(String tradeName) {
        /* 184 */
        this.tradeName = tradeName;

    }


    public String getTradeNo() {
        /* 188 */
        return this.tradeNo;

    }


    public void setTradeNo(String tradeNo) {
        /* 191 */
        this.tradeNo = tradeNo;

    }


    public Date getTradeTime() {
        /* 195 */
        return this.tradeTime;

    }


    public void setTradeTime(Date tradeTime) {
        /* 198 */
        this.tradeTime = tradeTime;

    }


    public String getTradeType() {
        /* 202 */
        return this.tradeType;

    }


    public void setTradeType(String tradeType) {
        /* 205 */
        this.tradeType = tradeType;

    }


    public List<BenefitInfoDetail> getUseBenefitList() {
        /* 209 */
        return this.useBenefitList;

    }


    public void setUseBenefitList(List<BenefitInfoDetail> useBenefitList) {
        /* 212 */
        this.useBenefitList = useBenefitList;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayMarketingCardConsumenotifyModel
 * JD-Core Version:    0.6.0
 */