package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiMarketingCdpMenuDelModel extends AlipayObject {
    private static final long serialVersionUID = 6751327957878947512L;

    @ApiField("menu_id")
    private String menuId;

    public String getMenuId() {
        /* 23 */
        return this.menuId;
    }

    public void setMenuId(String menuId) {
        /* 26 */
        this.menuId = menuId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMarketingCdpMenuDelModel
 * JD-Core Version:    0.6.0
 */