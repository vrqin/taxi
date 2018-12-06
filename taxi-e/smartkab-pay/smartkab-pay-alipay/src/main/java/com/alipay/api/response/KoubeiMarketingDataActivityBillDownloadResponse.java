package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiMarketingDataActivityBillDownloadResponse extends AlipayResponse {
    private static final long serialVersionUID = 6233268964299543516L;

    @ApiField("url")
    private String url;

    public String getUrl() {
        /* 27 */
        return this.url;
    }

    public void setUrl(String url) {
        /* 24 */
        this.url = url;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.KoubeiMarketingDataActivityBillDownloadResponse
 * JD-Core Version:    0.6.0
 */