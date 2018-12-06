package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenPublicMenuQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 6336113699431879263L;

    @ApiField("menu_content")
    private String menuContent;

    public String getMenuContent() {
        /* 27 */
        return this.menuContent;
    }

    public void setMenuContent(String menuContent) {
        /* 24 */
        this.menuContent = menuContent;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOpenPublicMenuQueryResponse
 * JD-Core Version:    0.6.0
 */