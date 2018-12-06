package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.RepaymentRecords;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayEcapiprodDrawndnRepaymentrecordQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 3641155824846376126L;

    @ApiListField("repayment_records")
    @ApiField("repayment_records")
    private List<RepaymentRecords> repaymentRecords;

    @ApiField("request_id")
    private String requestId;

    public List<RepaymentRecords> getRepaymentRecords() {
        /* 37 */
        return this.repaymentRecords;
    }

    public void setRepaymentRecords(List<RepaymentRecords> repaymentRecords) {
        /* 34 */
        this.repaymentRecords = repaymentRecords;
    }

    public String getRequestId() {
        /* 44 */
        return this.requestId;
    }

    public void setRequestId(String requestId) {
        /* 41 */
        this.requestId = requestId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayEcapiprodDrawndnRepaymentrecordQueryResponse
 * JD-Core Version:    0.6.0
 */