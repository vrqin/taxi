package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.ReportDataItem;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class KoubeiMarketingDataCustomreportQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 6442687391952386663L;

    @ApiField("count")
    private String count;

    @ApiListField("report_data")
    @ApiField("report_data_item")
    private List<ReportDataItem> reportData;

    public String getCount() {
        /* 37 */
        return this.count;
    }

    public void setCount(String count) {
        /* 34 */
        this.count = count;
    }

    public List<ReportDataItem> getReportData() {
        /* 44 */
        return this.reportData;
    }

    public void setReportData(List<ReportDataItem> reportData) {
        /* 41 */
        this.reportData = reportData;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.KoubeiMarketingDataCustomreportQueryResponse
 * JD-Core Version:    0.6.0
 */