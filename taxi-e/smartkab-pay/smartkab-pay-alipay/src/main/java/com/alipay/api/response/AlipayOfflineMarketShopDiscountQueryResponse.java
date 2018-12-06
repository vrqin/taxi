package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.ShopDiscountInfo;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayOfflineMarketShopDiscountQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 7459194693728197933L;

    @ApiListField("discount_list")
    @ApiField("shop_discount_info")
    private List<ShopDiscountInfo> discountList;

    @ApiListField("item_list")
    @ApiField("shop_discount_info")
    private List<ShopDiscountInfo> itemList;

    public List<ShopDiscountInfo> getDiscountList() {
        /* 38 */
        return this.discountList;
    }

    public void setDiscountList(List<ShopDiscountInfo> discountList) {
        /* 35 */
        this.discountList = discountList;
    }

    public List<ShopDiscountInfo> getItemList() {
        /* 45 */
        return this.itemList;
    }

    public void setItemList(List<ShopDiscountInfo> itemList) {
        /* 42 */
        this.itemList = itemList;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOfflineMarketShopDiscountQueryResponse
 * JD-Core Version:    0.6.0
 */