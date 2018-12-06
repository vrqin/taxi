package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayTradePageMergePayModel extends AlipayObject {
    private static final long serialVersionUID = 8636394746214258942L;

    @ApiListField("order_details")
    @ApiField("order_detail")
    private List<OrderDetail> orderDetails;

    @ApiField("out_merge_no")
    private String outMergeNo;

    @ApiField("timeout_express")
    private String timeoutExpress;

    public List<OrderDetail> getOrderDetails() {
        /* 39 */
        return this.orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        /* 42 */
        this.orderDetails = orderDetails;
    }

    public String getOutMergeNo() {
        /* 46 */
        return this.outMergeNo;
    }

    public void setOutMergeNo(String outMergeNo) {
        /* 49 */
        this.outMergeNo = outMergeNo;
    }

    public String getTimeoutExpress() {
        /* 53 */
        return this.timeoutExpress;
    }

    public void setTimeoutExpress(String timeoutExpress) {
        /* 56 */
        this.timeoutExpress = timeoutExpress;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayTradePageMergePayModel
 * JD-Core Version:    0.6.0
 */