package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayEcoMycarDataExternalQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 7893912646647871166L;

    @ApiField("external_system_name")
    private String externalSystemName;

    @ApiField("query_result")
    private String queryResult;

    public String getExternalSystemName() {
        /* 33 */
        return this.externalSystemName;
    }

    public void setExternalSystemName(String externalSystemName) {
        /* 30 */
        this.externalSystemName = externalSystemName;
    }

    public String getQueryResult() {
        /* 40 */
        return this.queryResult;
    }

    public void setQueryResult(String queryResult) {
        /* 37 */
        this.queryResult = queryResult;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayEcoMycarDataExternalQueryResponse
 * JD-Core Version:    0.6.0
 */