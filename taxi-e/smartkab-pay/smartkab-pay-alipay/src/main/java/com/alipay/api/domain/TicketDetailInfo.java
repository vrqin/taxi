package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class TicketDetailInfo extends AlipayObject {
    private static final long serialVersionUID = 2641475587982737918L;


    @ApiField("amount")
    private String amount;


    @ApiField("end_station")
    private String endStation;


    @ApiField("end_station_name")
    private String endStationName;


    @ApiField("quantity")
    private String quantity;


    @ApiField("start_station")
    private String startStation;


    @ApiField("start_station_name")
    private String startStationName;


    @ApiField("status")
    private String status;


    @ApiField("ticket_price")
    private String ticketPrice;


    @ApiField("ticket_type")
    private String ticketType;


    @ApiField("trade_no")
    private String tradeNo;


    public String getAmount() {
        /*  77 */
        return this.amount;

    }


    public void setAmount(String amount) {
        /*  80 */
        this.amount = amount;

    }


    public String getEndStation() {
        /*  84 */
        return this.endStation;

    }


    public void setEndStation(String endStation) {
        /*  87 */
        this.endStation = endStation;

    }


    public String getEndStationName() {
        /*  91 */
        return this.endStationName;

    }


    public void setEndStationName(String endStationName) {
        /*  94 */
        this.endStationName = endStationName;

    }


    public String getQuantity() {
        /*  98 */
        return this.quantity;

    }


    public void setQuantity(String quantity) {
        /* 101 */
        this.quantity = quantity;

    }


    public String getStartStation() {
        /* 105 */
        return this.startStation;

    }


    public void setStartStation(String startStation) {
        /* 108 */
        this.startStation = startStation;

    }


    public String getStartStationName() {
        /* 112 */
        return this.startStationName;

    }


    public void setStartStationName(String startStationName) {
        /* 115 */
        this.startStationName = startStationName;

    }


    public String getStatus() {
        /* 119 */
        return this.status;

    }


    public void setStatus(String status) {
        /* 122 */
        this.status = status;

    }


    public String getTicketPrice() {
        /* 126 */
        return this.ticketPrice;

    }


    public void setTicketPrice(String ticketPrice) {
        /* 129 */
        this.ticketPrice = ticketPrice;

    }


    public String getTicketType() {
        /* 133 */
        return this.ticketType;

    }


    public void setTicketType(String ticketType) {
        /* 136 */
        this.ticketType = ticketType;

    }


    public String getTradeNo() {
        /* 140 */
        return this.tradeNo;

    }


    public void setTradeNo(String tradeNo) {
        /* 143 */
        this.tradeNo = tradeNo;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.TicketDetailInfo
 * JD-Core Version:    0.6.0
 */