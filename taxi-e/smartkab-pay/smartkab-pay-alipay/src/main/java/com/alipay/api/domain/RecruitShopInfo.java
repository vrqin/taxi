package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class RecruitShopInfo extends AlipayObject {
    private static final long serialVersionUID = 4655479165177693118L;

    @ApiField("confirm_status")
    private String confirmStatus;

    @ApiField("shop_category")
    private String shopCategory;

    @ApiField("shop_id")
    private String shopId;

    @ApiField("shop_name")
    private String shopName;

    public String getConfirmStatus() {
        /* 41 */
        return this.confirmStatus;
    }

    public void setConfirmStatus(String confirmStatus) {
        /* 44 */
        this.confirmStatus = confirmStatus;
    }

    public String getShopCategory() {
        /* 48 */
        return this.shopCategory;
    }

    public void setShopCategory(String shopCategory) {
        /* 51 */
        this.shopCategory = shopCategory;
    }

    public String getShopId() {
        /* 55 */
        return this.shopId;
    }

    public void setShopId(String shopId) {
        /* 58 */
        this.shopId = shopId;
    }

    public String getShopName() {
        /* 62 */
        return this.shopName;
    }

    public void setShopName(String shopName) {
        /* 65 */
        this.shopName = shopName;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.RecruitShopInfo
 * JD-Core Version:    0.6.0
 */