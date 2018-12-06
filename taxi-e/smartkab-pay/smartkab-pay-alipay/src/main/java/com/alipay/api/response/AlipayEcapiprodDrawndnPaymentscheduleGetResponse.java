package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.PaymentSchedule;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayEcapiprodDrawndnPaymentscheduleGetResponse extends AlipayResponse {
    private static final long serialVersionUID = 5344126814493272963L;

    @ApiListField("payment_schedules")
    @ApiField("payment_schedule")
    private List<PaymentSchedule> paymentSchedules;

    @ApiField("request_id")
    private String requestId;

    public List<PaymentSchedule> getPaymentSchedules() {
        /* 37 */
        return this.paymentSchedules;
    }

    public void setPaymentSchedules(List<PaymentSchedule> paymentSchedules) {
        /* 34 */
        this.paymentSchedules = paymentSchedules;
    }

    public String getRequestId() {
        /* 44 */
        return this.requestId;
    }

    public void setRequestId(String requestId) {
        /* 41 */
        this.requestId = requestId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayEcapiprodDrawndnPaymentscheduleGetResponse
 * JD-Core Version:    0.6.0
 */