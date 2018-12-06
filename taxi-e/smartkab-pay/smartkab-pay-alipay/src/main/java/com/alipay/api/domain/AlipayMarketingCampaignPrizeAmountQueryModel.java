package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMarketingCampaignPrizeAmountQueryModel extends AlipayObject {
    private static final long serialVersionUID = 8673768855824748238L;

    @ApiField("camp_id")
    private String campId;

    @ApiField("prize_id")
    private String prizeId;

    public String getCampId() {
        /* 29 */
        return this.campId;
    }

    public void setCampId(String campId) {
        /* 32 */
        this.campId = campId;
    }

    public String getPrizeId() {
        /* 36 */
        return this.prizeId;
    }

    public void setPrizeId(String prizeId) {
        /* 39 */
        this.prizeId = prizeId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayMarketingCampaignPrizeAmountQueryModel
 * JD-Core Version:    0.6.0
 */