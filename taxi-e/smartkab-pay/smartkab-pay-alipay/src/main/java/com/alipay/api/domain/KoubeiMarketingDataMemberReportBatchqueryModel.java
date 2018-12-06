package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiMarketingDataMemberReportBatchqueryModel extends AlipayObject {
    private static final long serialVersionUID = 1212282458268683832L;

    @ApiField("biz_date")
    private String bizDate;

    public String getBizDate() {
        /* 23 */
        return this.bizDate;
    }

    public void setBizDate(String bizDate) {
        /* 26 */
        this.bizDate = bizDate;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMarketingDataMemberReportBatchqueryModel
 * JD-Core Version:    0.6.0
 */