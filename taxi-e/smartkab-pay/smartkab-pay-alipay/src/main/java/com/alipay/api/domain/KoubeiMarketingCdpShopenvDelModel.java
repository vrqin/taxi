package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiMarketingCdpShopenvDelModel extends AlipayObject {
    private static final long serialVersionUID = 4665834745457966785L;

    @ApiField("shop_pic_id")
    private String shopPicId;

    public String getShopPicId() {
        /* 23 */
        return this.shopPicId;
    }

    public void setShopPicId(String shopPicId) {
        /* 26 */
        this.shopPicId = shopPicId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMarketingCdpShopenvDelModel
 * JD-Core Version:    0.6.0
 */