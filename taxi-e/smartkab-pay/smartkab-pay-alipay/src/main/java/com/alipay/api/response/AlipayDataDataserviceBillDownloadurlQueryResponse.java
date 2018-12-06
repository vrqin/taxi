package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayDataDataserviceBillDownloadurlQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 6333346686314297163L;

    @ApiField("bill_download_url")
    private String billDownloadUrl;

    public String getBillDownloadUrl() {
        /* 27 */
        return this.billDownloadUrl;
    }

    public void setBillDownloadUrl(String billDownloadUrl) {
        /* 24 */
        this.billDownloadUrl = billDownloadUrl;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayDataDataserviceBillDownloadurlQueryResponse
 * JD-Core Version:    0.6.0
 */