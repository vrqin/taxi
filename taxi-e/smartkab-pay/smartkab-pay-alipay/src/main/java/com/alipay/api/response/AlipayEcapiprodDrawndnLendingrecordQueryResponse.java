package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.LendingRecords;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayEcapiprodDrawndnLendingrecordQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 4393159556821935728L;

    @ApiListField("lending_records")
    @ApiField("lending_records")
    private List<LendingRecords> lendingRecords;

    @ApiField("request_id")
    private String requestId;

    public List<LendingRecords> getLendingRecords() {
        /* 37 */
        return this.lendingRecords;
    }

    public void setLendingRecords(List<LendingRecords> lendingRecords) {
        /* 34 */
        this.lendingRecords = lendingRecords;
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
 * Qualified Name:     com.alipay.api.response.AlipayEcapiprodDrawndnLendingrecordQueryResponse
 * JD-Core Version:    0.6.0
 */