package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;


public class ExRefRateInfoVO extends AlipayObject {
    private static final long serialVersionUID = 8448752299728441246L;


    @ApiField("currency_pair")
    private String currencyPair;


    @ApiField("datum_currency")
    private String datumCurrency;


    @ApiField("price_type")
    private String priceType;


    @ApiField("pub_date")
    private String pubDate;


    @ApiField("pub_time")
    private Date pubTime;


    @ApiField("rate")
    private String rate;


    @ApiField("target_currency")
    private String targetCurrency;


    public String getCurrencyPair() {
        /*  61 */
        return this.currencyPair;

    }


    public void setCurrencyPair(String currencyPair) {
        /*  64 */
        this.currencyPair = currencyPair;

    }


    public String getDatumCurrency() {
        /*  68 */
        return this.datumCurrency;

    }


    public void setDatumCurrency(String datumCurrency) {
        /*  71 */
        this.datumCurrency = datumCurrency;

    }


    public String getPriceType() {
        /*  75 */
        return this.priceType;

    }


    public void setPriceType(String priceType) {
        /*  78 */
        this.priceType = priceType;

    }


    public String getPubDate() {
        /*  82 */
        return this.pubDate;

    }


    public void setPubDate(String pubDate) {
        /*  85 */
        this.pubDate = pubDate;

    }


    public Date getPubTime() {
        /*  89 */
        return this.pubTime;

    }


    public void setPubTime(Date pubTime) {
        /*  92 */
        this.pubTime = pubTime;

    }


    public String getRate() {
        /*  96 */
        return this.rate;

    }


    public void setRate(String rate) {
        /*  99 */
        this.rate = rate;

    }


    public String getTargetCurrency() {
        /* 103 */
        return this.targetCurrency;

    }


    public void setTargetCurrency(String targetCurrency) {
        /* 106 */
        this.targetCurrency = targetCurrency;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.ExRefRateInfoVO
 * JD-Core Version:    0.6.0
 */