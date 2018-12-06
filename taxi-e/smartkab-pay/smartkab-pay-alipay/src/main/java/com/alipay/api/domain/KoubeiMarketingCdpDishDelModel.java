package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiMarketingCdpDishDelModel extends AlipayObject {
    private static final long serialVersionUID = 3345423557749938318L;

    @ApiField("dish_id")
    private String dishId;

    public String getDishId() {
        /* 23 */
        return this.dishId;
    }

    public void setDishId(String dishId) {
        /* 26 */
        this.dishId = dishId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMarketingCdpDishDelModel
 * JD-Core Version:    0.6.0
 */