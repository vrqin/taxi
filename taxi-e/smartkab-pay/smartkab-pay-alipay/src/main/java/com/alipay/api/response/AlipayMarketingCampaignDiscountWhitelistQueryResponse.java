package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMarketingCampaignDiscountWhitelistQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 8442142274428932343L;

    @ApiField("camp_id")
    private String campId;

    @ApiField("user_white_list")
    private String userWhiteList;

    public String getCampId() {
        /* 33 */
        return this.campId;
    }

    public void setCampId(String campId) {
        /* 30 */
        this.campId = campId;
    }

    public String getUserWhiteList() {
        /* 40 */
        return this.userWhiteList;
    }

    public void setUserWhiteList(String userWhiteList) {
        /* 37 */
        this.userWhiteList = userWhiteList;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMarketingCampaignDiscountWhitelistQueryResponse
 * JD-Core Version:    0.6.0
 */