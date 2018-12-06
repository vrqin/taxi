package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.AlipayOfflinePayMasterKey;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayCommerceTransportOfflinepayKeyQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 2118541996168149156L;

    @ApiListField("keys")
    @ApiField("alipay_offline_pay_master_key")
    private List<AlipayOfflinePayMasterKey> keys;

    public List<AlipayOfflinePayMasterKey> getKeys() {
        /* 31 */
        return this.keys;
    }

    public void setKeys(List<AlipayOfflinePayMasterKey> keys) {
        /* 28 */
        this.keys = keys;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayCommerceTransportOfflinepayKeyQueryResponse
 * JD-Core Version:    0.6.0
 */