package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMarketingCardDeleteResponse extends AlipayResponse {
    private static final long serialVersionUID = 5111926683777461991L;

    @ApiField("biz_serial_no")
    private String bizSerialNo;

    public String getBizSerialNo() {
        /* 27 */
        return this.bizSerialNo;
    }

    public void setBizSerialNo(String bizSerialNo) {
        /* 24 */
        this.bizSerialNo = bizSerialNo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMarketingCardDeleteResponse
 * JD-Core Version:    0.6.0
 */