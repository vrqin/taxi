package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayCommerceTransportOfflinepayRecordVerifyModel extends AlipayObject {
    private static final long serialVersionUID = 7378372982851844785L;

    @ApiField("record")
    private String record;

    public String getRecord() {
        /* 23 */
        return this.record;
    }

    public void setRecord(String record) {
        /* 26 */
        this.record = record;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayCommerceTransportOfflinepayRecordVerifyModel
 * JD-Core Version:    0.6.0
 */