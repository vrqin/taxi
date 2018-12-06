package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayEcoMycarParkingOutAddModel extends AlipayObject {
    private static final long serialVersionUID = 2359341132516845532L;

    @ApiField("car_number")
    private String carNumber;

    @ApiField("out_time")
    private String outTime;

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

    public String getOutTime() {
        /* 42 */
        return this.outTime;
    }

    public void setOutTime(String outTime) {
        /* 45 */
        this.outTime = outTime;
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
 * Qualified Name:     com.alipay.api.domain.AlipayEcoMycarParkingOutAddModel
 * JD-Core Version:    0.6.0
 */