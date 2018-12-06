package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOfflineMarketLeadsQrcodeQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 8366978214256994287L;

    @ApiField("qr_code")
    private String qrCode;

    public String getQrCode() {
        /* 27 */
        return this.qrCode;
    }

    public void setQrCode(String qrCode) {
        /* 24 */
        this.qrCode = qrCode;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOfflineMarketLeadsQrcodeQueryResponse
 * JD-Core Version:    0.6.0
 */