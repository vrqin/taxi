package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayCommerceCityfacilitatorVoucherRefundModel extends AlipayObject {
    private static final long serialVersionUID = 5269617657179169452L;

    @ApiField("city_code")
    private String cityCode;

    @ApiField("trade_no")
    private String tradeNo;

    public String getCityCode() {
        /* 30 */
        return this.cityCode;
    }

    public void setCityCode(String cityCode) {
        /* 33 */
        this.cityCode = cityCode;
    }

    public String getTradeNo() {
        /* 37 */
        return this.tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        /* 40 */
        this.tradeNo = tradeNo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayCommerceCityfacilitatorVoucherRefundModel
 * JD-Core Version:    0.6.0
 */