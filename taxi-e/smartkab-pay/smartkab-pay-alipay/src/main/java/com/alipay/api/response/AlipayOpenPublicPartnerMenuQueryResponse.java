package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenPublicPartnerMenuQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 1583499129462164365L;

    @ApiField("public_menu")
    private String publicMenu;

    public String getPublicMenu() {
        /* 27 */
        return this.publicMenu;
    }

    public void setPublicMenu(String publicMenu) {
        /* 24 */
        this.publicMenu = publicMenu;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOpenPublicPartnerMenuQueryResponse
 * JD-Core Version:    0.6.0
 */