package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.CustomerEntity;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayZdataassetsMetadataResponse extends AlipayResponse {
    private static final long serialVersionUID = 7446357659463446331L;

    @ApiListField("result")
    @ApiField("customer_entity")
    private List<CustomerEntity> result;

    public List<CustomerEntity> getResult() {
        /* 31 */
        return this.result;
    }

    public void setResult(List<CustomerEntity> result) {
        /* 28 */
        this.result = result;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayZdataassetsMetadataResponse
 * JD-Core Version:    0.6.0
 */