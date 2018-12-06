package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.TicketDetailInfo;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayCommerceCityfacilitatorVoucherBatchqueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 2841946348335591853L;

    @ApiListField("tickets")
    @ApiField("ticket_detail_info")
    private List<TicketDetailInfo> tickets;

    public List<TicketDetailInfo> getTickets() {
        /* 31 */
        return this.tickets;
    }

    public void setTickets(List<TicketDetailInfo> tickets) {
        /* 28 */
        this.tickets = tickets;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayCommerceCityfacilitatorVoucherBatchqueryResponse
 * JD-Core Version:    0.6.0
 */