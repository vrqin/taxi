package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayEcoCplifeBillBatchUploadResponse extends AlipayResponse {
    private static final long serialVersionUID = 1582469319391649882L;

    @ApiField("batch_id")
    private String batchId;

    public String getBatchId() {
        /* 27 */
        return this.batchId;
    }

    public void setBatchId(String batchId) {
        /* 24 */
        this.batchId = batchId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayEcoCplifeBillBatchUploadResponse
 * JD-Core Version:    0.6.0
 */