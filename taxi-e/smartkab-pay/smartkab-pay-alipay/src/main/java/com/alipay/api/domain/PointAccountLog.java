package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;


public class PointAccountLog extends AlipayObject {
    private static final long serialVersionUID = 6338713838416166476L;


    @ApiField("account_log_id")
    private String accountLogId;


    @ApiField("balance")
    private Long balance;


    @ApiField("order_no")
    private String orderNo;


    @ApiField("out_biz_no")
    private String outBizNo;


    @ApiField("point_amount")
    private Long pointAmount;


    @ApiField("sub_trans_code")
    private String subTransCode;


    @ApiField("sub_trans_code_cn")
    private String subTransCodeCn;


    @ApiField("trans_code")
    private String transCode;


    @ApiField("trans_date")
    private Date transDate;


    @ApiField("trans_memo")
    private String transMemo;


    public String getAccountLogId() {
        /*  79 */
        return this.accountLogId;

    }


    public void setAccountLogId(String accountLogId) {
        /*  82 */
        this.accountLogId = accountLogId;

    }


    public Long getBalance() {
        /*  86 */
        return this.balance;

    }


    public void setBalance(Long balance) {
        /*  89 */
        this.balance = balance;

    }


    public String getOrderNo() {
        /*  93 */
        return this.orderNo;

    }


    public void setOrderNo(String orderNo) {
        /*  96 */
        this.orderNo = orderNo;

    }


    public String getOutBizNo() {
        /* 100 */
        return this.outBizNo;

    }


    public void setOutBizNo(String outBizNo) {
        /* 103 */
        this.outBizNo = outBizNo;

    }


    public Long getPointAmount() {
        /* 107 */
        return this.pointAmount;

    }


    public void setPointAmount(Long pointAmount) {
        /* 110 */
        this.pointAmount = pointAmount;

    }


    public String getSubTransCode() {
        /* 114 */
        return this.subTransCode;

    }


    public void setSubTransCode(String subTransCode) {
        /* 117 */
        this.subTransCode = subTransCode;

    }


    public String getSubTransCodeCn() {
        /* 121 */
        return this.subTransCodeCn;

    }


    public void setSubTransCodeCn(String subTransCodeCn) {
        /* 124 */
        this.subTransCodeCn = subTransCodeCn;

    }


    public String getTransCode() {
        /* 128 */
        return this.transCode;

    }


    public void setTransCode(String transCode) {
        /* 131 */
        this.transCode = transCode;

    }


    public Date getTransDate() {
        /* 135 */
        return this.transDate;

    }


    public void setTransDate(Date transDate) {
        /* 138 */
        this.transDate = transDate;

    }


    public String getTransMemo() {
        /* 142 */
        return this.transMemo;

    }


    public void setTransMemo(String transMemo) {
        /* 145 */
        this.transMemo = transMemo;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.PointAccountLog
 * JD-Core Version:    0.6.0
 */