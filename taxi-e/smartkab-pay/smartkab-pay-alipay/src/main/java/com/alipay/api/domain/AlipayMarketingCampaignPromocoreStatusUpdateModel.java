package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMarketingCampaignPromocoreStatusUpdateModel extends AlipayObject {
    private static final long serialVersionUID = 1623447898575323555L;

    @ApiField("camp_id")
    private String campId;

    @ApiField("camp_status")
    private String campStatus;

    public String getCampId() {
        /* 29 */
        return this.campId;
    }

    public void setCampId(String campId) {
        /* 32 */
        this.campId = campId;
    }

    public String getCampStatus() {
        /* 36 */
        return this.campStatus;
    }

    public void setCampStatus(String campStatus) {
        /* 39 */
        this.campStatus = campStatus;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayMarketingCampaignPromocoreStatusUpdateModel
 * JD-Core Version:    0.6.0
 */