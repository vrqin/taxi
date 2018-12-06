package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMobilePublicMenuGetResponse extends AlipayResponse {
    private static final long serialVersionUID = 4374895489314965523L;

    @ApiField("code")
    private String code;

    @ApiField("menu_content")
    private String menuContent;

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

    public String getMenuContent() {
        /* 46 */
        return this.menuContent;
    }

    public void setMenuContent(String menuContent) {
        /* 43 */
        this.menuContent = menuContent;
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
 * Qualified Name:     com.alipay.api.response.AlipayMobilePublicMenuGetResponse
 * JD-Core Version:    0.6.0
 */