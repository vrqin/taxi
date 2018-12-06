package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiMarketingDataCustomreportDetailQueryModel extends AlipayObject {
    private static final long serialVersionUID = 3789212914361318834L;

    @ApiField("condition_key")
    private String conditionKey;

    public String getConditionKey() {
        /* 23 */
        return this.conditionKey;
    }

    public void setConditionKey(String conditionKey) {
        /* 26 */
        this.conditionKey = conditionKey;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMarketingDataCustomreportDetailQueryModel
 * JD-Core Version:    0.6.0
 */