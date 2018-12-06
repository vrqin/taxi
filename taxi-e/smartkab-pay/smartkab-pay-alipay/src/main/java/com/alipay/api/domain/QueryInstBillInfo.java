package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;


public class QueryInstBillInfo extends AlipayObject {
    private static final long serialVersionUID = 2861396315146472619L;


    @ApiField("amount")
    private String amount;


    @ApiField("balance")
    private String balance;


    @ApiField("bill_date")
    private String billDate;


    @ApiListField("bill_detail")

    @ApiField("query_inst_bill_detail")
    private List<QueryInstBillDetail> billDetail;


    @ApiField("bill_fines")
    private String billFines;


    @ApiField("bill_key")
    private String billKey;


    @ApiField("bill_user_name")
    private String billUserName;


    @ApiField("charge_inst")
    private String chargeInst;


    @ApiField("charge_uniq_id")
    private String chargeUniqId;


    @ApiField("chargeoff_inst")
    private String chargeoffInst;


    @ApiField("company_id")
    private String companyId;


    @ApiField("extend")
    private String extend;


    @ApiField("order_type")
    private String orderType;


    @ApiField("out_id")
    private String outId;


    @ApiField("return_message")
    private String returnMessage;


    @ApiField("sub_order_type")
    private String subOrderType;


    public String getAmount() {
        /* 117 */
        return this.amount;

    }


    public void setAmount(String amount) {
        /* 120 */
        this.amount = amount;

    }


    public String getBalance() {
        /* 124 */
        return this.balance;

    }


    public void setBalance(String balance) {
        /* 127 */
        this.balance = balance;

    }


    public String getBillDate() {
        /* 131 */
        return this.billDate;

    }


    public void setBillDate(String billDate) {
        /* 134 */
        this.billDate = billDate;

    }


    public List<QueryInstBillDetail> getBillDetail() {
        /* 138 */
        return this.billDetail;

    }


    public void setBillDetail(List<QueryInstBillDetail> billDetail) {
        /* 141 */
        this.billDetail = billDetail;

    }


    public String getBillFines() {
        /* 145 */
        return this.billFines;

    }


    public void setBillFines(String billFines) {
        /* 148 */
        this.billFines = billFines;

    }


    public String getBillKey() {
        /* 152 */
        return this.billKey;

    }


    public void setBillKey(String billKey) {
        /* 155 */
        this.billKey = billKey;

    }


    public String getBillUserName() {
        /* 159 */
        return this.billUserName;

    }


    public void setBillUserName(String billUserName) {
        /* 162 */
        this.billUserName = billUserName;

    }


    public String getChargeInst() {
        /* 166 */
        return this.chargeInst;

    }


    public void setChargeInst(String chargeInst) {
        /* 169 */
        this.chargeInst = chargeInst;

    }


    public String getChargeUniqId() {
        /* 173 */
        return this.chargeUniqId;

    }


    public void setChargeUniqId(String chargeUniqId) {
        /* 176 */
        this.chargeUniqId = chargeUniqId;

    }


    public String getChargeoffInst() {
        /* 180 */
        return this.chargeoffInst;

    }


    public void setChargeoffInst(String chargeoffInst) {
        /* 183 */
        this.chargeoffInst = chargeoffInst;

    }


    public String getCompanyId() {
        /* 187 */
        return this.companyId;

    }


    public void setCompanyId(String companyId) {
        /* 190 */
        this.companyId = companyId;

    }


    public String getExtend() {
        /* 194 */
        return this.extend;

    }


    public void setExtend(String extend) {
        /* 197 */
        this.extend = extend;

    }


    public String getOrderType() {
        /* 201 */
        return this.orderType;

    }


    public void setOrderType(String orderType) {
        /* 204 */
        this.orderType = orderType;

    }


    public String getOutId() {
        /* 208 */
        return this.outId;

    }


    public void setOutId(String outId) {
        /* 211 */
        this.outId = outId;

    }


    public String getReturnMessage() {
        /* 215 */
        return this.returnMessage;

    }


    public void setReturnMessage(String returnMessage) {
        /* 218 */
        this.returnMessage = returnMessage;

    }


    public String getSubOrderType() {
        /* 222 */
        return this.subOrderType;

    }


    public void setSubOrderType(String subOrderType) {
        /* 225 */
        this.subOrderType = subOrderType;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.QueryInstBillInfo
 * JD-Core Version:    0.6.0
 */