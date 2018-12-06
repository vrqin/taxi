package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayDataBillDownloadurlGetResponse extends AlipayResponse {
    private static final long serialVersionUID = 5354956113218781825L;

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
 * Qualified Name:     com.alipay.api.response.AlipayDataBillDownloadurlGetResponse
 * JD-Core Version:    0.6.0
 */