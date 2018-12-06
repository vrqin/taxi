package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiMarketingDataActivityReportQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 3433578564298219844L;

    @ApiField("report_data")
    private String reportData;

    public String getReportData() {
        /* 27 */
        return this.reportData;
    }

    public void setReportData(String reportData) {
        /* 24 */
        this.reportData = reportData;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.KoubeiMarketingDataActivityReportQueryResponse
 * JD-Core Version:    0.6.0
 */