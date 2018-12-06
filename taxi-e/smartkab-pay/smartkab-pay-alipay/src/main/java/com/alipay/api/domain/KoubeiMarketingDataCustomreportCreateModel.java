package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiMarketingDataCustomreportCreateModel extends AlipayObject {
    private static final long serialVersionUID = 5285829396355264872L;

    @ApiField("report_condition_info")
    private CustomReportCondition reportConditionInfo;

    public CustomReportCondition getReportConditionInfo() {
        /* 23 */
        return this.reportConditionInfo;
    }

    public void setReportConditionInfo(CustomReportCondition reportConditionInfo) {
        /* 26 */
        this.reportConditionInfo = reportConditionInfo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMarketingDataCustomreportCreateModel
 * JD-Core Version:    0.6.0
 */