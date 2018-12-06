package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AntMerchantExpandPersonalApplyResponse extends AlipayResponse {
    private static final long serialVersionUID = 2373553179537475541L;

    @ApiField("order_no")
    private String orderNo;

    @ApiField("out_biz_no")
    private String outBizNo;

    public String getOrderNo() {
        /* 33 */
        return this.orderNo;
    }

    public void setOrderNo(String orderNo) {
        /* 30 */
        this.orderNo = orderNo;
    }

    public String getOutBizNo() {
        /* 40 */
        return this.outBizNo;
    }

    public void setOutBizNo(String outBizNo) {
        /* 37 */
        this.outBizNo = outBizNo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AntMerchantExpandPersonalApplyResponse
 * JD-Core Version:    0.6.0
 */