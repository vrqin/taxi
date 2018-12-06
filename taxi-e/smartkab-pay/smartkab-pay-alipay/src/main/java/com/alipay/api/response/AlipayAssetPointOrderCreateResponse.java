package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayAssetPointOrderCreateResponse extends AlipayResponse {
    private static final long serialVersionUID = 8555145854397462448L;

    @ApiField("alipay_order_no")
    private String alipayOrderNo;

    public String getAlipayOrderNo() {
        /* 27 */
        return this.alipayOrderNo;
    }

    public void setAlipayOrderNo(String alipayOrderNo) {
        /* 24 */
        this.alipayOrderNo = alipayOrderNo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayAssetPointOrderCreateResponse
 * JD-Core Version:    0.6.0
 */