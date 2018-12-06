package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayEcoMycarParkingParkinglotinfoCreateResponse extends AlipayResponse {
    private static final long serialVersionUID = 3836988684531328135L;

    @ApiField("alipay_parking_id")
    private String alipayParkingId;

    @ApiField("stauts")
    private String stauts;

    public String getAlipayParkingId() {
        /* 33 */
        return this.alipayParkingId;
    }

    public void setAlipayParkingId(String alipayParkingId) {
        /* 30 */
        this.alipayParkingId = alipayParkingId;
    }

    public String getStauts() {
        /* 40 */
        return this.stauts;
    }

    public void setStauts(String stauts) {
        /* 37 */
        this.stauts = stauts;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayEcoMycarParkingParkinglotinfoCreateResponse
 * JD-Core Version:    0.6.0
 */