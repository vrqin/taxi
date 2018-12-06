package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayPcreditLoanRefundCreateModel extends AlipayObject {
    private static final long serialVersionUID = 2546263597693844685L;

    @ApiField("loan_apply_no")
    private String loanApplyNo;

    @ApiField("out_biz_no")
    private String outBizNo;

    @ApiField("repay_amt")
    private String repayAmt;

    @ApiField("req_id")
    private String reqId;

    public String getLoanApplyNo() {
        /* 41 */
        return this.loanApplyNo;
    }

    public void setLoanApplyNo(String loanApplyNo) {
        /* 44 */
        this.loanApplyNo = loanApplyNo;
    }

    public String getOutBizNo() {
        /* 48 */
        return this.outBizNo;
    }

    public void setOutBizNo(String outBizNo) {
        /* 51 */
        this.outBizNo = outBizNo;
    }

    public String getRepayAmt() {
        /* 55 */
        return this.repayAmt;
    }

    public void setRepayAmt(String repayAmt) {
        /* 58 */
        this.repayAmt = repayAmt;
    }

    public String getReqId() {
        /* 62 */
        return this.reqId;
    }

    public void setReqId(String reqId) {
        /* 65 */
        this.reqId = reqId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayPcreditLoanRefundCreateModel
 * JD-Core Version:    0.6.0
 */