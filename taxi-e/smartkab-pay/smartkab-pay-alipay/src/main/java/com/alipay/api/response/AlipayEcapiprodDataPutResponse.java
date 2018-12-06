package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayEcapiprodDataPutResponse extends AlipayResponse {
    private static final long serialVersionUID = 8657885957516556479L;

    @ApiField("data_version")
    private String dataVersion;

    public String getDataVersion() {
        /* 27 */
        return this.dataVersion;
    }

    public void setDataVersion(String dataVersion) {
        /* 24 */
        this.dataVersion = dataVersion;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayEcapiprodDataPutResponse
 * JD-Core Version:    0.6.0
 */