package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.UnfreezeOrderDetail;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMicropayOrderUnfreezeResponse extends AlipayResponse {
    private static final long serialVersionUID = 8335376815292179483L;

    @ApiField("unfreeze_order_detail")
    private UnfreezeOrderDetail unfreezeOrderDetail;

    public UnfreezeOrderDetail getUnfreezeOrderDetail() {
        /* 28 */
        return this.unfreezeOrderDetail;
    }

    public void setUnfreezeOrderDetail(UnfreezeOrderDetail unfreezeOrderDetail) {
        /* 25 */
        this.unfreezeOrderDetail = unfreezeOrderDetail;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMicropayOrderUnfreezeResponse
 * JD-Core Version:    0.6.0
 */