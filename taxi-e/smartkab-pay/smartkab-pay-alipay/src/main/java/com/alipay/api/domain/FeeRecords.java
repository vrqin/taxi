package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;

public class FeeRecords extends AlipayObject {
    private static final long serialVersionUID = 8184682269466583543L;

    @ApiField("balance")
    private String balance;

    @ApiField("date")
    private Date date;

    @ApiField("remark")
    private String remark;

    @ApiField("total_amount")
    private String totalAmount;

    public String getBalance() {
        /* 43 */
        return this.balance;
    }

    public void setBalance(String balance) {
        /* 46 */
        this.balance = balance;
    }

    public Date getDate() {
        /* 50 */
        return this.date;
    }

    public void setDate(Date date) {
        /* 53 */
        this.date = date;
    }

    public String getRemark() {
        /* 57 */
        return this.remark;
    }

    public void setRemark(String remark) {
        /* 60 */
        this.remark = remark;
    }

    public String getTotalAmount() {
        /* 64 */
        return this.totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        /* 67 */
        this.totalAmount = totalAmount;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.FeeRecords
 * JD-Core Version:    0.6.0
 */