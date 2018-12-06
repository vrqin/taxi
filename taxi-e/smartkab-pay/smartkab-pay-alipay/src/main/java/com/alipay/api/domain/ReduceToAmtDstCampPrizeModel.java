package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class ReduceToAmtDstCampPrizeModel extends AlipayObject {
    private static final long serialVersionUID = 6122825137138454466L;

    @ApiField("reduct_to_amt")
    private String reductToAmt;

    public String getReductToAmt() {
        /* 23 */
        return this.reductToAmt;
    }

    public void setReductToAmt(String reductToAmt) {
        /* 26 */
        this.reductToAmt = reductToAmt;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.ReduceToAmtDstCampPrizeModel
 * JD-Core Version:    0.6.0
 */