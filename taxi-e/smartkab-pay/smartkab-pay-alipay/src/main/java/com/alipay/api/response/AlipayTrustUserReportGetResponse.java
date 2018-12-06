package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayTrustUserReportGetResponse extends AlipayResponse {
    private static final long serialVersionUID = 5442229247122111513L;

    @ApiField("report")
    private String report;

    public String getReport() {
        /* 27 */
        return this.report;
    }

    public void setReport(String report) {
        /* 24 */
        this.report = report;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayTrustUserReportGetResponse
 * JD-Core Version:    0.6.0
 */