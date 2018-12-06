package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayEcoMycarOrderStatusQueryModel extends AlipayObject {
    private static final long serialVersionUID = 1683229693178729328L;

    @ApiField("car_number")
    private String carNumber;

    @ApiField("parking_id")
    private String parkingId;

    @ApiField("sel_time")
    private String selTime;

    @ApiField("transaction_no")
    private String transactionNo;

    public String getCarNumber() {
        /* 41 */
        return this.carNumber;
    }

    public void setCarNumber(String carNumber) {
        /* 44 */
        this.carNumber = carNumber;
    }

    public String getParkingId() {
        /* 48 */
        return this.parkingId;
    }

    public void setParkingId(String parkingId) {
        /* 51 */
        this.parkingId = parkingId;
    }

    public String getSelTime() {
        /* 55 */
        return this.selTime;
    }

    public void setSelTime(String selTime) {
        /* 58 */
        this.selTime = selTime;
    }

    public String getTransactionNo() {
        /* 62 */
        return this.transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        /* 65 */
        this.transactionNo = transactionNo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayEcoMycarOrderStatusQueryModel
 * JD-Core Version:    0.6.0
 */