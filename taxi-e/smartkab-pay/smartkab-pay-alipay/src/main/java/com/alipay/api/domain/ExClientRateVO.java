package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;


public class ExClientRateVO extends AlipayObject {
    private static final long serialVersionUID = 5429755899827215948L;


    @ApiField("agreement_id")
    private String agreementId;


    @ApiField("base_ccy")
    private String baseCcy;


    @ApiField("bid_rate")
    private String bidRate;


    @ApiField("client_bid_rate")
    private String clientBidRate;


    @ApiField("client_id")
    private String clientId;


    @ApiField("client_offer_rate")
    private String clientOfferRate;


    @ApiField("currency_pair")
    private String currencyPair;


    @ApiField("expiry_time")
    private String expiryTime;


    @ApiField("generate_date")
    private String generateDate;


    @ApiField("generate_time")
    private Date generateTime;


    @ApiField("guaranteed")
    private String guaranteed;


    @ApiField("maturity_date")
    private String maturityDate;


    @ApiField("maximum_bid_amount")
    private Long maximumBidAmount;


    @ApiField("maximum_offer_amount")
    private Long maximumOfferAmount;


    @ApiField("mid_rate")
    private String midRate;


    @ApiField("minimum_bid_amount")
    private String minimumBidAmount;


    @ApiField("minimum_offer_amount")
    private String minimumOfferAmount;


    @ApiField("offer_rate")
    private String offerRate;


    @ApiField("on_off_shore")
    private String onOffShore;


    @ApiField("origin_rate_inst")
    private String originRateInst;


    @ApiField("origin_rate_ref")
    private String originRateRef;


    @ApiField("period")
    private String period;


    @ApiField("profile_id")
    private String profileId;


    @ApiField("quote_ccy")
    private String quoteCcy;


    @ApiField("rate_ref")
    private String rateRef;


    @ApiField("rate_time")
    private String rateTime;


    @ApiField("rate_type")
    private String rateType;


    @ApiField("sp_bid")
    private String spBid;


    @ApiField("sp_mid")
    private String spMid;


    @ApiField("sp_offer")
    private String spOffer;


    @ApiField("standard_product_rate_id")
    private String standardProductRateId;


    @ApiField("start_time")
    private String startTime;


    @ApiField("sub_agreement_id")
    private String subAgreementId;


    @ApiField("threshold_time")
    private String thresholdTime;


    @ApiField("time_zone")
    private String timeZone;


    @ApiField("transaction_ccy_type")
    private String transactionCcyType;


    @ApiField("valid_time")
    private String validTime;


    public String getAgreementId() {
        /* 241 */
        return this.agreementId;

    }


    public void setAgreementId(String agreementId) {
        /* 244 */
        this.agreementId = agreementId;

    }


    public String getBaseCcy() {
        /* 248 */
        return this.baseCcy;

    }


    public void setBaseCcy(String baseCcy) {
        /* 251 */
        this.baseCcy = baseCcy;

    }


    public String getBidRate() {
        /* 255 */
        return this.bidRate;

    }


    public void setBidRate(String bidRate) {
        /* 258 */
        this.bidRate = bidRate;

    }


    public String getClientBidRate() {
        /* 262 */
        return this.clientBidRate;

    }


    public void setClientBidRate(String clientBidRate) {
        /* 265 */
        this.clientBidRate = clientBidRate;

    }


    public String getClientId() {
        /* 269 */
        return this.clientId;

    }


    public void setClientId(String clientId) {
        /* 272 */
        this.clientId = clientId;

    }


    public String getClientOfferRate() {
        /* 276 */
        return this.clientOfferRate;

    }


    public void setClientOfferRate(String clientOfferRate) {
        /* 279 */
        this.clientOfferRate = clientOfferRate;

    }


    public String getCurrencyPair() {
        /* 283 */
        return this.currencyPair;

    }


    public void setCurrencyPair(String currencyPair) {
        /* 286 */
        this.currencyPair = currencyPair;

    }


    public String getExpiryTime() {
        /* 290 */
        return this.expiryTime;

    }


    public void setExpiryTime(String expiryTime) {
        /* 293 */
        this.expiryTime = expiryTime;

    }


    public String getGenerateDate() {
        /* 297 */
        return this.generateDate;

    }


    public void setGenerateDate(String generateDate) {
        /* 300 */
        this.generateDate = generateDate;

    }


    public Date getGenerateTime() {
        /* 304 */
        return this.generateTime;

    }


    public void setGenerateTime(Date generateTime) {
        /* 307 */
        this.generateTime = generateTime;

    }


    public String getGuaranteed() {
        /* 311 */
        return this.guaranteed;

    }


    public void setGuaranteed(String guaranteed) {
        /* 314 */
        this.guaranteed = guaranteed;

    }


    public String getMaturityDate() {
        /* 318 */
        return this.maturityDate;

    }


    public void setMaturityDate(String maturityDate) {
        /* 321 */
        this.maturityDate = maturityDate;

    }


    public Long getMaximumBidAmount() {
        /* 325 */
        return this.maximumBidAmount;

    }


    public void setMaximumBidAmount(Long maximumBidAmount) {
        /* 328 */
        this.maximumBidAmount = maximumBidAmount;

    }


    public Long getMaximumOfferAmount() {
        /* 332 */
        return this.maximumOfferAmount;

    }


    public void setMaximumOfferAmount(Long maximumOfferAmount) {
        /* 335 */
        this.maximumOfferAmount = maximumOfferAmount;

    }


    public String getMidRate() {
        /* 339 */
        return this.midRate;

    }


    public void setMidRate(String midRate) {
        /* 342 */
        this.midRate = midRate;

    }


    public String getMinimumBidAmount() {
        /* 346 */
        return this.minimumBidAmount;

    }


    public void setMinimumBidAmount(String minimumBidAmount) {
        /* 349 */
        this.minimumBidAmount = minimumBidAmount;

    }


    public String getMinimumOfferAmount() {
        /* 353 */
        return this.minimumOfferAmount;

    }


    public void setMinimumOfferAmount(String minimumOfferAmount) {
        /* 356 */
        this.minimumOfferAmount = minimumOfferAmount;

    }


    public String getOfferRate() {
        /* 360 */
        return this.offerRate;

    }


    public void setOfferRate(String offerRate) {
        /* 363 */
        this.offerRate = offerRate;

    }


    public String getOnOffShore() {
        /* 367 */
        return this.onOffShore;

    }


    public void setOnOffShore(String onOffShore) {
        /* 370 */
        this.onOffShore = onOffShore;

    }


    public String getOriginRateInst() {
        /* 374 */
        return this.originRateInst;

    }


    public void setOriginRateInst(String originRateInst) {
        /* 377 */
        this.originRateInst = originRateInst;

    }


    public String getOriginRateRef() {
        /* 381 */
        return this.originRateRef;

    }


    public void setOriginRateRef(String originRateRef) {
        /* 384 */
        this.originRateRef = originRateRef;

    }


    public String getPeriod() {
        /* 388 */
        return this.period;

    }


    public void setPeriod(String period) {
        /* 391 */
        this.period = period;

    }


    public String getProfileId() {
        /* 395 */
        return this.profileId;

    }


    public void setProfileId(String profileId) {
        /* 398 */
        this.profileId = profileId;

    }


    public String getQuoteCcy() {
        /* 402 */
        return this.quoteCcy;

    }


    public void setQuoteCcy(String quoteCcy) {
        /* 405 */
        this.quoteCcy = quoteCcy;

    }


    public String getRateRef() {
        /* 409 */
        return this.rateRef;

    }


    public void setRateRef(String rateRef) {
        /* 412 */
        this.rateRef = rateRef;

    }


    public String getRateTime() {
        /* 416 */
        return this.rateTime;

    }


    public void setRateTime(String rateTime) {
        /* 419 */
        this.rateTime = rateTime;

    }


    public String getRateType() {
        /* 423 */
        return this.rateType;

    }


    public void setRateType(String rateType) {
        /* 426 */
        this.rateType = rateType;

    }


    public String getSpBid() {
        /* 430 */
        return this.spBid;

    }


    public void setSpBid(String spBid) {
        /* 433 */
        this.spBid = spBid;

    }


    public String getSpMid() {
        /* 437 */
        return this.spMid;

    }


    public void setSpMid(String spMid) {
        /* 440 */
        this.spMid = spMid;

    }


    public String getSpOffer() {
        /* 444 */
        return this.spOffer;

    }


    public void setSpOffer(String spOffer) {
        /* 447 */
        this.spOffer = spOffer;

    }


    public String getStandardProductRateId() {
        /* 451 */
        return this.standardProductRateId;

    }


    public void setStandardProductRateId(String standardProductRateId) {
        /* 454 */
        this.standardProductRateId = standardProductRateId;

    }


    public String getStartTime() {
        /* 458 */
        return this.startTime;

    }


    public void setStartTime(String startTime) {
        /* 461 */
        this.startTime = startTime;

    }


    public String getSubAgreementId() {
        /* 465 */
        return this.subAgreementId;

    }


    public void setSubAgreementId(String subAgreementId) {
        /* 468 */
        this.subAgreementId = subAgreementId;

    }


    public String getThresholdTime() {
        /* 472 */
        return this.thresholdTime;

    }


    public void setThresholdTime(String thresholdTime) {
        /* 475 */
        this.thresholdTime = thresholdTime;

    }


    public String getTimeZone() {
        /* 479 */
        return this.timeZone;

    }


    public void setTimeZone(String timeZone) {
        /* 482 */
        this.timeZone = timeZone;

    }


    public String getTransactionCcyType() {
        /* 486 */
        return this.transactionCcyType;

    }


    public void setTransactionCcyType(String transactionCcyType) {
        /* 489 */
        this.transactionCcyType = transactionCcyType;

    }


    public String getValidTime() {
        /* 493 */
        return this.validTime;

    }


    public void setValidTime(String validTime) {
        /* 496 */
        this.validTime = validTime;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.ExClientRateVO
 * JD-Core Version:    0.6.0
 */