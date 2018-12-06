package com.alipay.api.response;


import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayEbppBillGetResponse extends AlipayResponse {
    private static final long serialVersionUID = 1138571995167616195L;


    @ApiField("alipay_order_no")
    private String alipayOrderNo;


    @ApiField("bill_date")
    private String billDate;


    @ApiField("bill_key")
    private String billKey;


    @ApiField("charge_inst")
    private String chargeInst;


    @ApiField("charge_inst_name")
    private String chargeInstName;


    @ApiField("merchant_order_no")
    private String merchantOrderNo;


    @ApiField("order_status")
    private String orderStatus;


    @ApiField("order_type")
    private String orderType;


    @ApiField("owner_name")
    private String ownerName;


    @ApiField("pay_amount")
    private String payAmount;


    @ApiField("pay_time")
    private String payTime;


    @ApiField("service_amount")
    private String serviceAmount;


    @ApiField("sub_order_type")
    private String subOrderType;


    @ApiField("traffic_location")
    private String trafficLocation;


    @ApiField("traffic_regulations")
    private String trafficRegulations;


    public String getAlipayOrderNo() {
        /* 111 */
        return this.alipayOrderNo;

    }


    public void setAlipayOrderNo(String alipayOrderNo) {
        /* 108 */
        this.alipayOrderNo = alipayOrderNo;

    }


    public String getBillDate() {
        /* 118 */
        return this.billDate;

    }


    public void setBillDate(String billDate) {
        /* 115 */
        this.billDate = billDate;

    }


    public String getBillKey() {
        /* 125 */
        return this.billKey;

    }


    public void setBillKey(String billKey) {
        /* 122 */
        this.billKey = billKey;

    }


    public String getChargeInst() {
        /* 132 */
        return this.chargeInst;

    }


    public void setChargeInst(String chargeInst) {
        /* 129 */
        this.chargeInst = chargeInst;

    }


    public String getChargeInstName() {
        /* 139 */
        return this.chargeInstName;

    }


    public void setChargeInstName(String chargeInstName) {
        /* 136 */
        this.chargeInstName = chargeInstName;

    }


    public String getMerchantOrderNo() {
        /* 146 */
        return this.merchantOrderNo;

    }


    public void setMerchantOrderNo(String merchantOrderNo) {
        /* 143 */
        this.merchantOrderNo = merchantOrderNo;

    }


    public String getOrderStatus() {
        /* 153 */
        return this.orderStatus;

    }


    public void setOrderStatus(String orderStatus) {
        /* 150 */
        this.orderStatus = orderStatus;

    }


    public String getOrderType() {
        /* 160 */
        return this.orderType;

    }


    public void setOrderType(String orderType) {
        /* 157 */
        this.orderType = orderType;

    }


    public String getOwnerName() {
        /* 167 */
        return this.ownerName;

    }


    public void setOwnerName(String ownerName) {
        /* 164 */
        this.ownerName = ownerName;

    }


    public String getPayAmount() {
        /* 174 */
        return this.payAmount;

    }


    public void setPayAmount(String payAmount) {
        /* 171 */
        this.payAmount = payAmount;

    }


    public String getPayTime() {
        /* 181 */
        return this.payTime;

    }


    public void setPayTime(String payTime) {
        /* 178 */
        this.payTime = payTime;

    }


    public String getServiceAmount() {
        /* 188 */
        return this.serviceAmount;

    }


    public void setServiceAmount(String serviceAmount) {
        /* 185 */
        this.serviceAmount = serviceAmount;

    }


    public String getSubOrderType() {
        /* 195 */
        return this.subOrderType;

    }


    public void setSubOrderType(String subOrderType) {
        /* 192 */
        this.subOrderType = subOrderType;

    }


    public String getTrafficLocation() {
        /* 202 */
        return this.trafficLocation;

    }


    public void setTrafficLocation(String trafficLocation) {
        /* 199 */
        this.trafficLocation = trafficLocation;

    }


    public String getTrafficRegulations() {
        /* 209 */
        return this.trafficRegulations;

    }


    public void setTrafficRegulations(String trafficRegulations) {
        /* 206 */
        this.trafficRegulations = trafficRegulations;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayEbppBillGetResponse
 * JD-Core Version:    0.6.0
 */