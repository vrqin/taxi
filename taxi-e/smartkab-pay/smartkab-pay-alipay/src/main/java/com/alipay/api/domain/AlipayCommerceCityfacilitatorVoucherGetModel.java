package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayCommerceCityfacilitatorVoucherGetModel extends AlipayObject {
    private static final long serialVersionUID = 1226758716328782843L;


    @ApiField("city_code")
    private String cityCode;


    @ApiField("site_begin")
    private String siteBegin;


    @ApiField("site_end")
    private String siteEnd;


    @ApiField("ticket_num")
    private String ticketNum;


    @ApiField("ticket_price")
    private String ticketPrice;


    @ApiField("ticket_type")
    private String ticketType;


    @ApiField("total_fee")
    private String totalFee;


    @ApiField("trade_no")
    private String tradeNo;


    public String getCityCode() {
        /*  66 */
        return this.cityCode;

    }


    public void setCityCode(String cityCode) {
        /*  69 */
        this.cityCode = cityCode;

    }


    public String getSiteBegin() {
        /*  73 */
        return this.siteBegin;

    }


    public void setSiteBegin(String siteBegin) {
        /*  76 */
        this.siteBegin = siteBegin;

    }


    public String getSiteEnd() {
        /*  80 */
        return this.siteEnd;

    }


    public void setSiteEnd(String siteEnd) {
        /*  83 */
        this.siteEnd = siteEnd;

    }


    public String getTicketNum() {
        /*  87 */
        return this.ticketNum;

    }


    public void setTicketNum(String ticketNum) {
        /*  90 */
        this.ticketNum = ticketNum;

    }


    public String getTicketPrice() {
        /*  94 */
        return this.ticketPrice;

    }


    public void setTicketPrice(String ticketPrice) {
        /*  97 */
        this.ticketPrice = ticketPrice;

    }


    public String getTicketType() {
        /* 101 */
        return this.ticketType;

    }


    public void setTicketType(String ticketType) {
        /* 104 */
        this.ticketType = ticketType;

    }


    public String getTotalFee() {
        /* 108 */
        return this.totalFee;

    }


    public void setTotalFee(String totalFee) {
        /* 111 */
        this.totalFee = totalFee;

    }


    public String getTradeNo() {
        /* 115 */
        return this.tradeNo;

    }


    public void setTradeNo(String tradeNo) {
        /* 118 */
        this.tradeNo = tradeNo;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayCommerceCityfacilitatorVoucherGetModel
 * JD-Core Version:    0.6.0
 */