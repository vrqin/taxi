package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayTradeMergePrecreateModel extends AlipayObject {
    private static final long serialVersionUID = 4549345365119258217L;

    @ApiListField("order_details")
    @ApiField("order_detail")
    private List<OrderDetail> orderDetails;

    @ApiField("out_merge_no")
    private String outMergeNo;

    @ApiField("timeout_express")
    private String timeoutExpress;

    public List<OrderDetail> getOrderDetails() {
        /* 40 */
        return this.orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        /* 43 */
        this.orderDetails = orderDetails;
    }

    public String getOutMergeNo() {
        /* 47 */
        return this.outMergeNo;
    }

    public void setOutMergeNo(String outMergeNo) {
        /* 50 */
        this.outMergeNo = outMergeNo;
    }

    public String getTimeoutExpress() {
        /* 54 */
        return this.timeoutExpress;
    }

    public void setTimeoutExpress(String timeoutExpress) {
        /* 57 */
        this.timeoutExpress = timeoutExpress;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayTradeMergePrecreateModel
 * JD-Core Version:    0.6.0
 */