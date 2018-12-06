package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMarketingCampaignDstcampUpdatestatusModel extends AlipayObject {
    private static final long serialVersionUID = 2414655799873892149L;

    @ApiField("camp_id")
    private String campId;

    @ApiField("status")
    private String status;

    public String getCampId() {
        /* 29 */
        return this.campId;
    }

    public void setCampId(String campId) {
        /* 32 */
        this.campId = campId;
    }

    public String getStatus() {
        /* 36 */
        return this.status;
    }

    public void setStatus(String status) {
        /* 39 */
        this.status = status;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayMarketingCampaignDstcampUpdatestatusModel
 * JD-Core Version:    0.6.0
 */