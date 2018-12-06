package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMobilePublicLabelAddResponse extends AlipayResponse {
    private static final long serialVersionUID = 6556234762857922649L;

    @ApiField("code")
    private String code;

    @ApiField("id")
    private Long id;

    @ApiField("msg")
    private String msg;

    @ApiField("name")
    private String name;

    public String getCode() {
        /* 45 */
        return this.code;
    }

    public void setCode(String code) {
        /* 42 */
        this.code = code;
    }

    public Long getId() {
        /* 52 */
        return this.id;
    }

    public void setId(Long id) {
        /* 49 */
        this.id = id;
    }

    public String getMsg() {
        /* 59 */
        return this.msg;
    }

    public void setMsg(String msg) {
        /* 56 */
        this.msg = msg;
    }

    public String getName() {
        /* 66 */
        return this.name;
    }

    public void setName(String name) {
        /* 63 */
        this.name = name;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMobilePublicLabelAddResponse
 * JD-Core Version:    0.6.0
 */