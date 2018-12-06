package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayFundTransOrderQueryModel extends AlipayObject {
    private static final long serialVersionUID = 8494549796964267231L;

    @ApiField("order_id")
    private String orderId;

    @ApiField("out_biz_no")
    private String outBizNo;

    public String getOrderId() {
        /* 30 */
        return this.orderId;
    }

    public void setOrderId(String orderId) {
        /* 33 */
        this.orderId = orderId;
    }

    public String getOutBizNo() {
        /* 37 */
        return this.outBizNo;
    }

    public void setOutBizNo(String outBizNo) {
        /* 40 */
        this.outBizNo = outBizNo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayFundTransOrderQueryModel
 * JD-Core Version:    0.6.0
 */