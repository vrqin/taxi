package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMobilePublicMenuUserQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 7462435449447798313L;

    @ApiField("code")
    private String code;

    @ApiField("menu_key")
    private String menuKey;

    @ApiField("msg")
    private String msg;

    public String getCode() {
        /* 39 */
        return this.code;
    }

    public void setCode(String code) {
        /* 36 */
        this.code = code;
    }

    public String getMenuKey() {
        /* 46 */
        return this.menuKey;
    }

    public void setMenuKey(String menuKey) {
        /* 43 */
        this.menuKey = menuKey;
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
 * Qualified Name:     com.alipay.api.response.AlipayMobilePublicMenuUserQueryResponse
 * JD-Core Version:    0.6.0
 */