package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.CreditResult;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayEcapiprodCreditGetResponse extends AlipayResponse {
    private static final long serialVersionUID = 7616819546582162148L;

    @ApiField("credit_result")
    private CreditResult creditResult;

    @ApiField("request_id")
    private String requestId;

    public CreditResult getCreditResult() {
        /* 34 */
        return this.creditResult;
    }

    public void setCreditResult(CreditResult creditResult) {
        /* 31 */
        this.creditResult = creditResult;
    }

    public String getRequestId() {
        /* 41 */
        return this.requestId;
    }

    public void setRequestId(String requestId) {
        /* 38 */
        this.requestId = requestId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayEcapiprodCreditGetResponse
 * JD-Core Version:    0.6.0
 */