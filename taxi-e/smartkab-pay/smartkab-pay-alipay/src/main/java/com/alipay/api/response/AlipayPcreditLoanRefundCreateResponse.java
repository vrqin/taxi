package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayPcreditLoanRefundCreateResponse extends AlipayResponse {
    private static final long serialVersionUID = 1422863693899134721L;

    @ApiField("loan_repay_no")
    private String loanRepayNo;

    public String getLoanRepayNo() {
        /* 27 */
        return this.loanRepayNo;
    }

    public void setLoanRepayNo(String loanRepayNo) {
        /* 24 */
        this.loanRepayNo = loanRepayNo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayPcreditLoanRefundCreateResponse
 * JD-Core Version:    0.6.0
 */