package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayOpenServicemarketCommodityExtendinfoAddModel extends AlipayObject {
    private static final long serialVersionUID = 6812958921812276289L;

    @ApiListField("commodity_ext_infos")
    @ApiField("commodity_public_ext_infos")
    private List<CommodityPublicExtInfos> commodityExtInfos;

    @ApiField("commodity_id")
    private String commodityId;

    @ApiField("user_id")
    private String userId;

    public List<CommodityPublicExtInfos> getCommodityExtInfos() {
        /* 39 */
        return this.commodityExtInfos;
    }

    public void setCommodityExtInfos(List<CommodityPublicExtInfos> commodityExtInfos) {
        /* 42 */
        this.commodityExtInfos = commodityExtInfos;
    }

    public String getCommodityId() {
        /* 46 */
        return this.commodityId;
    }

    public void setCommodityId(String commodityId) {
        /* 49 */
        this.commodityId = commodityId;
    }

    public String getUserId() {
        /* 53 */
        return this.userId;
    }

    public void setUserId(String userId) {
        /* 56 */
        this.userId = userId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOpenServicemarketCommodityExtendinfoAddModel
 * JD-Core Version:    0.6.0
 */