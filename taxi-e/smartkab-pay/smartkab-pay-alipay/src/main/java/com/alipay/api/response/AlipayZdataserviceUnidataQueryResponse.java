package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayZdataserviceUnidataQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 3398556255743719135L;

    @ApiField("query_result")
    private String queryResult;

    @ApiField("result_code")
    private String resultCode;

    @ApiField("success")
    private String success;

    public String getQueryResult() {
        /* 39 */
        return this.queryResult;
    }

    public void setQueryResult(String queryResult) {
        /* 36 */
        this.queryResult = queryResult;
    }

    public String getResultCode() {
        /* 46 */
        return this.resultCode;
    }

    public void setResultCode(String resultCode) {
        /* 43 */
        this.resultCode = resultCode;
    }

    public String getSuccess() {
        /* 53 */
        return this.success;
    }

    public void setSuccess(String success) {
        /* 50 */
        this.success = success;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayZdataserviceUnidataQueryResponse
 * JD-Core Version:    0.6.0
 */