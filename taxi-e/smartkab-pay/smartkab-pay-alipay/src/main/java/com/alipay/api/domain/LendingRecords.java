package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;

public class LendingRecords extends AlipayObject {
    private static final long serialVersionUID = 6369942796438771979L;

    @ApiField("date")
    private Date date;

    @ApiField("remark")
    private String remark;

    @ApiField("total_amount")
    private String totalAmount;

    public Date getDate() {
        /* 37 */
        return this.date;
    }

    public void setDate(Date date) {
        /* 40 */
        this.date = date;
    }

    public String getRemark() {
        /* 44 */
        return this.remark;
    }

    public void setRemark(String remark) {
        /* 47 */
        this.remark = remark;
    }

    public String getTotalAmount() {
        /* 51 */
        return this.totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        /* 54 */
        this.totalAmount = totalAmount;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.LendingRecords
 * JD-Core Version:    0.6.0
 */