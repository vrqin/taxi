package com.alipay.api.response;


import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayEbppBillAddResponse extends AlipayResponse {
    private static final long serialVersionUID = 4187434897239635419L;


    @ApiField("alipay_order_no")
    private String alipayOrderNo;


    @ApiField("bank_bill_no")
    private String bankBillNo;


    @ApiField("bill_date")
    private String billDate;


    @ApiField("bill_key")
    private String billKey;


    @ApiField("charge_inst")
    private String chargeInst;


    @ApiField("charge_inst_name")
    private String chargeInstName;


    @ApiField("extend_field")
    private String extendField;


    @ApiField("merchant_order_no")
    private String merchantOrderNo;


    @ApiField("order_type")
    private String orderType;


    @ApiField("owner_name")
    private String ownerName;


    @ApiField("pay_amount")
    private String payAmount;


    @ApiField("service_amount")
    private String serviceAmount;


    @ApiField("sub_order_type")
    private String subOrderType;


    public String getAlipayOrderNo() {
        /* 100 */
        return this.alipayOrderNo;

    }


    public void setAlipayOrderNo(String alipayOrderNo) {
        /*  97 */
        this.alipayOrderNo = alipayOrderNo;

    }


    public String getBankBillNo() {
        /* 107 */
        return this.bankBillNo;

    }


    public void setBankBillNo(String bankBillNo) {
        /* 104 */
        this.bankBillNo = bankBillNo;

    }


    public String getBillDate() {
        /* 114 */
        return this.billDate;

    }


    public void setBillDate(String billDate) {
        /* 111 */
        this.billDate = billDate;

    }


    public String getBillKey() {
        /* 121 */
        return this.billKey;

    }


    public void setBillKey(String billKey) {
        /* 118 */
        this.billKey = billKey;

    }


    public String getChargeInst() {
        /* 128 */
        return this.chargeInst;

    }


    public void setChargeInst(String chargeInst) {
        /* 125 */
        this.chargeInst = chargeInst;

    }


    public String getChargeInstName() {
        /* 135 */
        return this.chargeInstName;

    }


    public void setChargeInstName(String chargeInstName) {
        /* 132 */
        this.chargeInstName = chargeInstName;

    }


    public String getExtendField() {
        /* 142 */
        return this.extendField;

    }


    public void setExtendField(String extendField) {
        /* 139 */
        this.extendField = extendField;

    }


    public String getMerchantOrderNo() {
        /* 149 */
        return this.merchantOrderNo;

    }


    public void setMerchantOrderNo(String merchantOrderNo) {
        /* 146 */
        this.merchantOrderNo = merchantOrderNo;

    }


    public String getOrderType() {
        /* 156 */
        return this.orderType;

    }


    public void setOrderType(String orderType) {
        /* 153 */
        this.orderType = orderType;

    }


    public String getOwnerName() {
        /* 163 */
        return this.ownerName;

    }


    public void setOwnerName(String ownerName) {
        /* 160 */
        this.ownerName = ownerName;

    }


    public String getPayAmount() {
        /* 170 */
        return this.payAmount;

    }


    public void setPayAmount(String payAmount) {
        /* 167 */
        this.payAmount = payAmount;

    }


    public String getServiceAmount() {
        /* 177 */
        return this.serviceAmount;

    }


    public void setServiceAmount(String serviceAmount) {
        /* 174 */
        this.serviceAmount = serviceAmount;

    }


    public String getSubOrderType() {
        /* 184 */
        return this.subOrderType;

    }


    public void setSubOrderType(String subOrderType) {
        /* 181 */
        this.subOrderType = subOrderType;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayEbppBillAddResponse
 * JD-Core Version:    0.6.0
 */