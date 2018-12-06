package com.alipay.api.response;


import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayEcoMycarParkingOrderstatusQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 8759655436713713472L;


    @ApiField("alipay_order_id")
    private String alipayOrderId;


    @ApiField("car_order_id")
    private String carOrderId;


    @ApiField("equipment_order_id")
    private String equipmentOrderId;


    @ApiField("pay_money")
    private String payMoney;


    @ApiField("pay_status")
    private String payStatus;


    @ApiField("pay_time")
    private String payTime;


    @ApiField("pay_type")
    private String payType;


    @ApiField("status")
    private String status;


    public String getAlipayOrderId() {
        /*  69 */
        return this.alipayOrderId;

    }


    public void setAlipayOrderId(String alipayOrderId) {
        /*  66 */
        this.alipayOrderId = alipayOrderId;

    }


    public String getCarOrderId() {
        /*  76 */
        return this.carOrderId;

    }


    public void setCarOrderId(String carOrderId) {
        /*  73 */
        this.carOrderId = carOrderId;

    }


    public String getEquipmentOrderId() {
        /*  83 */
        return this.equipmentOrderId;

    }


    public void setEquipmentOrderId(String equipmentOrderId) {
        /*  80 */
        this.equipmentOrderId = equipmentOrderId;

    }


    public String getPayMoney() {
        /*  90 */
        return this.payMoney;

    }


    public void setPayMoney(String payMoney) {
        /*  87 */
        this.payMoney = payMoney;

    }


    public String getPayStatus() {
        /*  97 */
        return this.payStatus;

    }


    public void setPayStatus(String payStatus) {
        /*  94 */
        this.payStatus = payStatus;

    }


    public String getPayTime() {
        /* 104 */
        return this.payTime;

    }


    public void setPayTime(String payTime) {
        /* 101 */
        this.payTime = payTime;

    }


    public String getPayType() {
        /* 111 */
        return this.payType;

    }


    public void setPayType(String payType) {
        /* 108 */
        this.payType = payType;

    }


    public String getStatus() {
        /* 118 */
        return this.status;

    }


    public void setStatus(String status) {
        /* 115 */
        this.status = status;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayEcoMycarParkingOrderstatusQueryResponse
 * JD-Core Version:    0.6.0
 */