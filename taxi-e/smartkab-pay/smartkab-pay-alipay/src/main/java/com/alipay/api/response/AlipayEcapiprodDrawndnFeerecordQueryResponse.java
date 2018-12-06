package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.FeeRecords;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayEcapiprodDrawndnFeerecordQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 1787526896118925316L;

    @ApiListField("fee_records")
    @ApiField("fee_records")
    private List<FeeRecords> feeRecords;

    @ApiField("request_id")
    private String requestId;

    public List<FeeRecords> getFeeRecords() {
        /* 37 */
        return this.feeRecords;
    }

    public void setFeeRecords(List<FeeRecords> feeRecords) {
        /* 34 */
        this.feeRecords = feeRecords;
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
 * Qualified Name:     com.alipay.api.response.AlipayEcapiprodDrawndnFeerecordQueryResponse
 * JD-Core Version:    0.6.0
 */