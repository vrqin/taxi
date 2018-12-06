package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMobileStdPublicMenuQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 2841331455976189343L;

    @ApiField("all_menu_list")
    private String allMenuList;

    public String getAllMenuList() {
        /* 27 */
        return this.allMenuList;
    }

    public void setAllMenuList(String allMenuList) {
        /* 24 */
        this.allMenuList = allMenuList;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMobileStdPublicMenuQueryResponse
 * JD-Core Version:    0.6.0
 */