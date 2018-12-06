package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayEcoMycarParkingLotbarcodeCreateResponse extends AlipayResponse {
    private static final long serialVersionUID = 4899612591886948395L;

    @ApiField("qrcode_url")
    private String qrcodeUrl;

    @ApiField("status")
    private String status;

    public String getQrcodeUrl() {
        /* 33 */
        return this.qrcodeUrl;
    }

    public void setQrcodeUrl(String qrcodeUrl) {
        /* 30 */
        this.qrcodeUrl = qrcodeUrl;
    }

    public String getStatus() {
        /* 40 */
        return this.status;
    }

    public void setStatus(String status) {
        /* 37 */
        this.status = status;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayEcoMycarParkingLotbarcodeCreateResponse
 * JD-Core Version:    0.6.0
 */