package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMarketingCdpRecommendQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 1278418529198998942L;

    @ApiField("recommend_id")
    private String recommendId;

    @ApiField("shop_info")
    private String shopInfo;

    public String getRecommendId() {
        /* 33 */
        return this.recommendId;
    }

    public void setRecommendId(String recommendId) {
        /* 30 */
        this.recommendId = recommendId;
    }

    public String getShopInfo() {
        /* 40 */
        return this.shopInfo;
    }

    public void setShopInfo(String shopInfo) {
        /* 37 */
        this.shopInfo = shopInfo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMarketingCdpRecommendQueryResponse
 * JD-Core Version:    0.6.0
 */