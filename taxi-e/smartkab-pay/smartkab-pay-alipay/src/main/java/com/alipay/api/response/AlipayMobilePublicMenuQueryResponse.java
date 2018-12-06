package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMobilePublicMenuQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 7355425974163236219L;

    @ApiField("all_menu_list")
    private String allMenuList;

    @ApiField("code")
    private String code;

    @ApiField("msg")
    private String msg;

    public String getAllMenuList() {
        /* 39 */
        return this.allMenuList;
    }

    public void setAllMenuList(String allMenuList) {
        /* 36 */
        this.allMenuList = allMenuList;
    }

    public String getCode() {
        /* 46 */
        return this.code;
    }

    public void setCode(String code) {
        /* 43 */
        this.code = code;
    }

    public String getMsg() {
        /* 53 */
        return this.msg;
    }

    public void setMsg(String msg) {
        /* 50 */
        this.msg = msg;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMobilePublicMenuQueryResponse
 * JD-Core Version:    0.6.0
 */