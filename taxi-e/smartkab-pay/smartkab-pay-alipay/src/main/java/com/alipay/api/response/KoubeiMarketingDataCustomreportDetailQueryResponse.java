package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.CustomReportCondition;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiMarketingDataCustomreportDetailQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 7529614478287374971L;

    @ApiField("report_condition_info")
    private CustomReportCondition reportConditionInfo;

    public CustomReportCondition getReportConditionInfo() {
        /* 28 */
        return this.reportConditionInfo;
    }

    public void setReportConditionInfo(CustomReportCondition reportConditionInfo) {
        /* 25 */
        this.reportConditionInfo = reportConditionInfo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.KoubeiMarketingDataCustomreportDetailQueryResponse
 * JD-Core Version:    0.6.0
 */