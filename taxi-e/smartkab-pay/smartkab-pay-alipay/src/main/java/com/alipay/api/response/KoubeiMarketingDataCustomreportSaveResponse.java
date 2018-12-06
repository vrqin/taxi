package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiMarketingDataCustomreportSaveResponse extends AlipayResponse {
    private static final long serialVersionUID = 6734143515484754767L;

    @ApiField("condition_key")
    private String conditionKey;

    public String getConditionKey() {
        /* 27 */
        return this.conditionKey;
    }

    public void setConditionKey(String conditionKey) {
        /* 24 */
        this.conditionKey = conditionKey;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.KoubeiMarketingDataCustomreportSaveResponse
 * JD-Core Version:    0.6.0
 */