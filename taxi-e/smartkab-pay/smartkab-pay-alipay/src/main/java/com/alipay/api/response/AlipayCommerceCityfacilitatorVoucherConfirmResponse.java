package com.alipay.api.response;


import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayCommerceCityfacilitatorVoucherConfirmResponse extends AlipayResponse {
    private static final long serialVersionUID = 5728175573543264665L;


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
        /*  81 */
        return this.amount;

    }


    public void setAmount(String amount) {
        /*  78 */
        this.amount = amount;

    }


    public String getEndStation() {
        /*  88 */
        return this.endStation;

    }


    public void setEndStation(String endStation) {
        /*  85 */
        this.endStation = endStation;

    }


    public String getEndStationName() {
        /*  95 */
        return this.endStationName;

    }


    public void setEndStationName(String endStationName) {
        /*  92 */
        this.endStationName = endStationName;

    }


    public String getQuantity() {
        /* 102 */
        return this.quantity;

    }


    public void setQuantity(String quantity) {
        /*  99 */
        this.quantity = quantity;

    }


    public String getStartStation() {
        /* 109 */
        return this.startStation;

    }


    public void setStartStation(String startStation) {
        /* 106 */
        this.startStation = startStation;

    }


    public String getStartStationName() {
        /* 116 */
        return this.startStationName;

    }


    public void setStartStationName(String startStationName) {
        /* 113 */
        this.startStationName = startStationName;

    }


    public String getStatus() {
        /* 123 */
        return this.status;

    }


    public void setStatus(String status) {
        /* 120 */
        this.status = status;

    }


    public String getTicketPrice() {
        /* 130 */
        return this.ticketPrice;

    }


    public void setTicketPrice(String ticketPrice) {
        /* 127 */
        this.ticketPrice = ticketPrice;

    }


    public String getTicketType() {
        /* 137 */
        return this.ticketType;

    }


    public void setTicketType(String ticketType) {
        /* 134 */
        this.ticketType = ticketType;

    }


    public String getTradeNo() {
        /* 144 */
        return this.tradeNo;

    }


    public void setTradeNo(String tradeNo) {
        /* 141 */
        this.tradeNo = tradeNo;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayCommerceCityfacilitatorVoucherConfirmResponse
 * JD-Core Version:    0.6.0
 */