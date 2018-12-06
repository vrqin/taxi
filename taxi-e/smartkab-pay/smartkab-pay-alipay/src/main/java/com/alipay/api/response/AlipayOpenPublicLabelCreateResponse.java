package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOpenPublicLabelCreateResponse extends AlipayResponse {
    private static final long serialVersionUID = 8168419676544252389L;

    @ApiField("id")
    private Long id;

    @ApiField("name")
    private String name;

    public Long getId() {
        /* 33 */
        return this.id;
    }

    public void setId(Long id) {
        /* 30 */
        this.id = id;
    }

    public String getName() {
        /* 40 */
        return this.name;
    }

    public void setName(String name) {
        /* 37 */
        this.name = name;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOpenPublicLabelCreateResponse
 * JD-Core Version:    0.6.0
 */