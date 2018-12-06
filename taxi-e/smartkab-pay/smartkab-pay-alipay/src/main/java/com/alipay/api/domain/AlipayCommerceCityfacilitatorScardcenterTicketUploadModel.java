package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayCommerceCityfacilitatorScardcenterTicketUploadModel extends AlipayObject {
    private static final long serialVersionUID = 5137441538446894946L;

    @ApiField("biz_info_ext")
    private String bizInfoExt;

    @ApiField("city_code")
    private String cityCode;

    @ApiField("exchange_ids")
    private String exchangeIds;

    @ApiField("operate_time")
    private String operateTime;

    @ApiField("ticket_no")
    private String ticketNo;

    @ApiField("trade_no")
    private String tradeNo;

    public String getBizInfoExt() {
        /* 53 */
        return this.bizInfoExt;
    }

    public void setBizInfoExt(String bizInfoExt) {
        /* 56 */
        this.bizInfoExt = bizInfoExt;
    }

    public String getCityCode() {
        /* 60 */
        return this.cityCode;
    }

    public void setCityCode(String cityCode) {
        /* 63 */
        this.cityCode = cityCode;
    }

    public String getExchangeIds() {
        /* 67 */
        return this.exchangeIds;
    }

    public void setExchangeIds(String exchangeIds) {
        /* 70 */
        this.exchangeIds = exchangeIds;
    }

    public String getOperateTime() {
        /* 74 */
        return this.operateTime;
    }

    public void setOperateTime(String operateTime) {
        /* 77 */
        this.operateTime = operateTime;
    }

    public String getTicketNo() {
        /* 81 */
        return this.ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        /* 84 */
        this.ticketNo = ticketNo;
    }

    public String getTradeNo() {
        /* 88 */
        return this.tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        /* 91 */
        this.tradeNo = tradeNo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayCommerceCityfacilitatorScardcenterTicketUploadModel
 * JD-Core Version:    0.6.0
 */