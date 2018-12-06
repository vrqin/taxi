package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMobilePublicLabelDeleteResponse extends AlipayResponse {
    private static final long serialVersionUID = 1663797917415745144L;

    @ApiField("code")
    private String code;

    @ApiField("id")
    private Long id;

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

    public Long getId() {
        /* 46 */
        return this.id;
    }

    public void setId(Long id) {
        /* 43 */
        this.id = id;
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
 * Qualified Name:     com.alipay.api.response.AlipayMobilePublicLabelDeleteResponse
 * JD-Core Version:    0.6.0
 */