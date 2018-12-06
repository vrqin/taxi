package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.CustomReportCondition;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class KoubeiMarketingDataCustomreportBatchqueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 1141397895777748591L;

    @ApiListField("report_condition_list")
    @ApiField("custom_report_condition")
    private List<CustomReportCondition> reportConditionList;

    public List<CustomReportCondition> getReportConditionList() {
        /* 31 */
        return this.reportConditionList;
    }

    public void setReportConditionList(List<CustomReportCondition> reportConditionList) {
        /* 28 */
        this.reportConditionList = reportConditionList;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.KoubeiMarketingDataCustomreportBatchqueryResponse
 * JD-Core Version:    0.6.0
 */