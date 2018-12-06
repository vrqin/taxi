package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiMarketingCampaignCrowdCountResponse extends AlipayResponse {
    private static final long serialVersionUID = 6425913912772175311L;

    @ApiField("dimension_values")
    private String dimensionValues;

    @ApiField("summary_values")
    private String summaryValues;

    public String getDimensionValues() {
        /* 33 */
        return this.dimensionValues;
    }

    public void setDimensionValues(String dimensionValues) {
        /* 30 */
        this.dimensionValues = dimensionValues;
    }

    public String getSummaryValues() {
        /* 40 */
        return this.summaryValues;
    }

    public void setSummaryValues(String summaryValues) {
        /* 37 */
        this.summaryValues = summaryValues;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.KoubeiMarketingCampaignCrowdCountResponse
 * JD-Core Version:    0.6.0
 */