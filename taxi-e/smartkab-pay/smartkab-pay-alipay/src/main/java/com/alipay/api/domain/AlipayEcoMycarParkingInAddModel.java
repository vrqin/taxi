package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayEcoMycarParkingInAddModel extends AlipayObject {
    private static final long serialVersionUID = 3364669268486133135L;

    @ApiField("car_number")
    private String carNumber;

    @ApiField("in_time")
    private String inTime;

    @ApiField("parking_id")
    private String parkingId;

    public String getCarNumber() {
        /* 35 */
        return this.carNumber;
    }

    public void setCarNumber(String carNumber) {
        /* 38 */
        this.carNumber = carNumber;
    }

    public String getInTime() {
        /* 42 */
        return this.inTime;
    }

    public void setInTime(String inTime) {
        /* 45 */
        this.inTime = inTime;
    }

    public String getParkingId() {
        /* 49 */
        return this.parkingId;
    }

    public void setParkingId(String parkingId) {
        /* 52 */
        this.parkingId = parkingId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayEcoMycarParkingInAddModel
 * JD-Core Version:    0.6.0
 */