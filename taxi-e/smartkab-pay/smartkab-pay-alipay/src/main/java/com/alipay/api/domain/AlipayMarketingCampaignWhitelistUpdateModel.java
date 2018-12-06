package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMarketingCampaignWhitelistUpdateModel extends AlipayObject {
    private static final long serialVersionUID = 3495932158724914593L;

    @ApiField("camp_id")
    private String campId;

    @ApiField("user_white_list")
    private String userWhiteList;

    public String getCampId() {
        /* 29 */
        return this.campId;
    }

    public void setCampId(String campId) {
        /* 32 */
        this.campId = campId;
    }

    public String getUserWhiteList() {
        /* 36 */
        return this.userWhiteList;
    }

    public void setUserWhiteList(String userWhiteList) {
        /* 39 */
        this.userWhiteList = userWhiteList;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayMarketingCampaignWhitelistUpdateModel
 * JD-Core Version:    0.6.0
 */