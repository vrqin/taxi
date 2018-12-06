package com.alipay.api.response;


import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayEcoMycarOrderStatusQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 2871964173792612371L;


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
        /*  71 */
        return this.alipayOrderId;

    }


    public void setAlipayOrderId(String alipayOrderId) {
        /*  68 */
        this.alipayOrderId = alipayOrderId;

    }


    public String getCarOrderId() {
        /*  78 */
        return this.carOrderId;

    }


    public void setCarOrderId(String carOrderId) {
        /*  75 */
        this.carOrderId = carOrderId;

    }


    public String getEquipmentOrderId() {
        /*  85 */
        return this.equipmentOrderId;

    }


    public void setEquipmentOrderId(String equipmentOrderId) {
        /*  82 */
        this.equipmentOrderId = equipmentOrderId;

    }


    public String getPayMoney() {
        /*  92 */
        return this.payMoney;

    }


    public void setPayMoney(String payMoney) {
        /*  89 */
        this.payMoney = payMoney;

    }


    public String getPayStatus() {
        /*  99 */
        return this.payStatus;

    }


    public void setPayStatus(String payStatus) {
        /*  96 */
        this.payStatus = payStatus;

    }


    public String getPayTime() {
        /* 106 */
        return this.payTime;

    }


    public void setPayTime(String payTime) {
        /* 103 */
        this.payTime = payTime;

    }


    public String getPayType() {
        /* 113 */
        return this.payType;

    }


    public void setPayType(String payType) {
        /* 110 */
        this.payType = payType;

    }


    public String getStatus() {
        /* 120 */
        return this.status;

    }


    public void setStatus(String status) {
        /* 117 */
        this.status = status;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayEcoMycarOrderStatusQueryResponse
 * JD-Core Version:    0.6.0
 */