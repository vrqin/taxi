package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMarketingCampaignPromocoreTriggerModel extends AlipayObject {
    private static final long serialVersionUID = 2163524424665197656L;

    @ApiField("camp_id")
    private String campId;

    @ApiField("user_id")
    private String userId;

    public String getCampId() {
        /* 29 */
        return this.campId;
    }

    public void setCampId(String campId) {
        /* 32 */
        this.campId = campId;
    }

    public String getUserId() {
        /* 36 */
        return this.userId;
    }

    public void setUserId(String userId) {
        /* 39 */
        this.userId = userId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayMarketingCampaignPromocoreTriggerModel
 * JD-Core Version:    0.6.0
 */