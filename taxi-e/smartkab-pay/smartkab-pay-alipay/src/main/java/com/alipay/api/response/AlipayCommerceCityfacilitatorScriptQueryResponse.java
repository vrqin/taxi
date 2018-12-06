package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayCommerceCityfacilitatorScriptQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 3185259571112595483L;

    @ApiField("content")
    private String content;

    @ApiField("gmt_modified")
    private String gmtModified;

    public String getContent() {
        /* 33 */
        return this.content;
    }

    public void setContent(String content) {
        /* 30 */
        this.content = content;
    }

    public String getGmtModified() {
        /* 40 */
        return this.gmtModified;
    }

    public void setGmtModified(String gmtModified) {
        /* 37 */
        this.gmtModified = gmtModified;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayCommerceCityfacilitatorScriptQueryResponse
 * JD-Core Version:    0.6.0
 */