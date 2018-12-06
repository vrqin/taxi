package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiMemberBrandownerNameQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 8631596469773775264L;

    @ApiField("name")
    private String name;

    public String getName() {
        /* 27 */
        return this.name;
    }

    public void setName(String name) {
        /* 24 */
        this.name = name;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.KoubeiMemberBrandownerNameQueryResponse
 * JD-Core Version:    0.6.0
 */