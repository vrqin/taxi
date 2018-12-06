package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMarketingCampaignPromocoreWhitelistCreateModel extends AlipayObject {
    private static final long serialVersionUID = 8618293925727478375L;

    @ApiField("camp_id")
    private String campId;

    @ApiField("user_id_list")
    private String userIdList;

    public String getCampId() {
        /* 29 */
        return this.campId;
    }

    public void setCampId(String campId) {
        /* 32 */
        this.campId = campId;
    }

    public String getUserIdList() {
        /* 36 */
        return this.userIdList;
    }

    public void setUserIdList(String userIdList) {
        /* 39 */
        this.userIdList = userIdList;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayMarketingCampaignPromocoreWhitelistCreateModel
 * JD-Core Version:    0.6.0
 */