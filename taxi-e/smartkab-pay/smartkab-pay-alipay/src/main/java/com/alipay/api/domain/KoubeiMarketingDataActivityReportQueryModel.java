package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiMarketingDataActivityReportQueryModel extends AlipayObject {
    private static final long serialVersionUID = 2439681699136425455L;

    @ApiField("biz_date")
    private String bizDate;

    @ApiField("camp_id")
    private String campId;

    public String getBizDate() {
        /* 29 */
        return this.bizDate;
    }

    public void setBizDate(String bizDate) {
        /* 32 */
        this.bizDate = bizDate;
    }

    public String getCampId() {
        /* 36 */
        return this.campId;
    }

    public void setCampId(String campId) {
        /* 39 */
        this.campId = campId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMarketingDataActivityReportQueryModel
 * JD-Core Version:    0.6.0
 */