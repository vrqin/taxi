package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayCommerceCityfacilitatorScardcenterTicketCancelModel extends AlipayObject {
    private static final long serialVersionUID = 4239446272644125139L;

    @ApiField("biz_info_ext")
    private String bizInfoExt;

    @ApiField("city_code")
    private String cityCode;

    @ApiField("operate_time")
    private String operateTime;

    @ApiField("ticket_no")
    private String ticketNo;

    @ApiField("trade_no")
    private String tradeNo;

    public String getBizInfoExt() {
        /* 47 */
        return this.bizInfoExt;
    }

    public void setBizInfoExt(String bizInfoExt) {
        /* 50 */
        this.bizInfoExt = bizInfoExt;
    }

    public String getCityCode() {
        /* 54 */
        return this.cityCode;
    }

    public void setCityCode(String cityCode) {
        /* 57 */
        this.cityCode = cityCode;
    }

    public String getOperateTime() {
        /* 61 */
        return this.operateTime;
    }

    public void setOperateTime(String operateTime) {
        /* 64 */
        this.operateTime = operateTime;
    }

    public String getTicketNo() {
        /* 68 */
        return this.ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        /* 71 */
        this.ticketNo = ticketNo;
    }

    public String getTradeNo() {
        /* 75 */
        return this.tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        /* 78 */
        this.tradeNo = tradeNo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayCommerceCityfacilitatorScardcenterTicketCancelModel
 * JD-Core Version:    0.6.0
 */