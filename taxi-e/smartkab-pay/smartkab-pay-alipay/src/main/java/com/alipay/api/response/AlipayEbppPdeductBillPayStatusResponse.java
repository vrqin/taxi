package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayEbppPdeductBillPayStatusResponse extends AlipayResponse {
    private static final long serialVersionUID = 2172415323124856666L;

    @ApiField("agreement_id")
    private String agreementId;

    @ApiField("order_no")
    private String orderNo;

    @ApiField("out_order_no")
    private String outOrderNo;

    @ApiField("status")
    private String status;

    public String getAgreementId() {
        /* 48 */
        return this.agreementId;
    }

    public void setAgreementId(String agreementId) {
        /* 45 */
        this.agreementId = agreementId;
    }

    public String getOrderNo() {
        /* 55 */
        return this.orderNo;
    }

    public void setOrderNo(String orderNo) {
        /* 52 */
        this.orderNo = orderNo;
    }

    public String getOutOrderNo() {
        /* 62 */
        return this.outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        /* 59 */
        this.outOrderNo = outOrderNo;
    }

    public String getStatus() {
        /* 69 */
        return this.status;
    }

    public void setStatus(String status) {
        /* 66 */
        this.status = status;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayEbppPdeductBillPayStatusResponse
 * JD-Core Version:    0.6.0
 */