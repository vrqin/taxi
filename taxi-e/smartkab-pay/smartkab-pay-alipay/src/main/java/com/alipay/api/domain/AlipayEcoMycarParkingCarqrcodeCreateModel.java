package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayEcoMycarParkingCarqrcodeCreateModel extends AlipayObject {
    private static final long serialVersionUID = 6655686437164717936L;

    @ApiField("parking_id")
    private String parkingId;

    public String getParkingId() {
        /* 23 */
        return this.parkingId;
    }

    public void setParkingId(String parkingId) {
        /* 26 */
        this.parkingId = parkingId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayEcoMycarParkingCarqrcodeCreateModel
 * JD-Core Version:    0.6.0
 */