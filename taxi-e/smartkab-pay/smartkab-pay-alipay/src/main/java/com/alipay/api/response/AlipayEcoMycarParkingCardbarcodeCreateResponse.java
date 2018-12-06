package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.QRcode;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayEcoMycarParkingCardbarcodeCreateResponse extends AlipayResponse {
    private static final long serialVersionUID = 4699481551512666546L;

    @ApiListField("qrcodes")
    @ApiField("q_rcode")
    private List<QRcode> qrcodes;

    public List<QRcode> getQrcodes() {
        /* 31 */
        return this.qrcodes;
    }

    public void setQrcodes(List<QRcode> qrcodes) {
        /* 28 */
        this.qrcodes = qrcodes;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayEcoMycarParkingCardbarcodeCreateResponse
 * JD-Core Version:    0.6.0
 */