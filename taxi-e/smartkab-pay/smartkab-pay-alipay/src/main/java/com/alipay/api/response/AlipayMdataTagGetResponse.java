package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMdataTagGetResponse extends AlipayResponse {
    private static final long serialVersionUID = 2755978491625184233L;

    @ApiField("tag_values")
    private String tagValues;

    public String getTagValues() {
        /* 27 */
        return this.tagValues;
    }

    public void setTagValues(String tagValues) {
        /* 24 */
        this.tagValues = tagValues;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMdataTagGetResponse
 * JD-Core Version:    0.6.0
 */