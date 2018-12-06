package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMarketingCampaignPromocoreQueryModel extends AlipayObject {
    private static final long serialVersionUID = 4644234715788372627L;

    @ApiField("camp_id")
    private String campId;

    public String getCampId() {
        /* 23 */
        return this.campId;
    }

    public void setCampId(String campId) {
        /* 26 */
        this.campId = campId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayMarketingCampaignPromocoreQueryModel
 * JD-Core Version:    0.6.0
 */