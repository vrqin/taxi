package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.RecruitShopInfo;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class KoubeiMarketingCampaignRecruitShopQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 7677365937124274158L;

    @ApiField("plan_id")
    private String planId;

    @ApiField("shop_count")
    private String shopCount;

    @ApiListField("shop_info")
    @ApiField("recruit_shop_info")
    private List<RecruitShopInfo> shopInfo;

    public String getPlanId() {
        /* 43 */
        return this.planId;
    }

    public void setPlanId(String planId) {
        /* 40 */
        this.planId = planId;
    }

    public String getShopCount() {
        /* 50 */
        return this.shopCount;
    }

    public void setShopCount(String shopCount) {
        /* 47 */
        this.shopCount = shopCount;
    }

    public List<RecruitShopInfo> getShopInfo() {
        /* 57 */
        return this.shopInfo;
    }

    public void setShopInfo(List<RecruitShopInfo> shopInfo) {
        /* 54 */
        this.shopInfo = shopInfo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.KoubeiMarketingCampaignRecruitShopQueryResponse
 * JD-Core Version:    0.6.0
 */