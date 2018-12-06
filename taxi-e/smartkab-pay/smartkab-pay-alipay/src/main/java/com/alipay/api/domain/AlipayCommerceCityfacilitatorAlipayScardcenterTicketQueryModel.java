package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayCommerceCityfacilitatorAlipayScardcenterTicketQueryModel extends AlipayObject {
    private static final long serialVersionUID = 6561876873984742449L;

    @ApiField("city_code")
    private String cityCode;

    @ApiField("ticket_no")
    private String ticketNo;

    @ApiField("trade_no")
    private String tradeNo;

    public String getCityCode() {
        /* 35 */
        return this.cityCode;
    }

    public void setCityCode(String cityCode) {
        /* 38 */
        this.cityCode = cityCode;
    }

    public String getTicketNo() {
        /* 42 */
        return this.ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        /* 45 */
        this.ticketNo = ticketNo;
    }

    public String getTradeNo() {
        /* 49 */
        return this.tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        /* 52 */
        this.tradeNo = tradeNo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayCommerceCityfacilitatorAlipayScardcenterTicketQueryModel
 * JD-Core Version:    0.6.0
 */