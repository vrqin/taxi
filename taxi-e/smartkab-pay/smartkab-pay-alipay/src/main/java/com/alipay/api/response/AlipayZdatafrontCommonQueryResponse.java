package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayZdatafrontCommonQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 2177527948222246776L;

    @ApiField("cache_timestamp")
    private Long cacheTimestamp;

    @ApiField("values")
    private String values;

    public Long getCacheTimestamp() {
        /* 35 */
        return this.cacheTimestamp;
    }

    public void setCacheTimestamp(Long cacheTimestamp) {
        /* 32 */
        this.cacheTimestamp = cacheTimestamp;
    }

    public String getValues() {
        /* 42 */
        return this.values;
    }

    public void setValues(String values) {
        /* 39 */
        this.values = values;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayZdatafrontCommonQueryResponse
 * JD-Core Version:    0.6.0
 */