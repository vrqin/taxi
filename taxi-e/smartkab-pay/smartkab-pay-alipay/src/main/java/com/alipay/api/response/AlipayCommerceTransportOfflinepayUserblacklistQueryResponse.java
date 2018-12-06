package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayCommerceTransportOfflinepayUserblacklistQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 7751414494265252735L;

    @ApiListField("black_list")
    @ApiField("string")
    private List<String> blackList;

    public List<String> getBlackList() {
        /* 30 */
        return this.blackList;
    }

    public void setBlackList(List<String> blackList) {
        /* 27 */
        this.blackList = blackList;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayCommerceTransportOfflinepayUserblacklistQueryResponse
 * JD-Core Version:    0.6.0
 */