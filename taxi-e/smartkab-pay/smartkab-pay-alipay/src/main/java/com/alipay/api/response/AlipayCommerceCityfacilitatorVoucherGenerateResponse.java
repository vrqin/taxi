package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayCommerceCityfacilitatorVoucherGenerateResponse extends AlipayResponse {
    private static final long serialVersionUID = 2472469435237892347L;

    @ApiField("expired_date")
    private String expiredDate;

    @ApiField("qr_code_no")
    private String qrCodeNo;

    @ApiField("ticket_no")
    private String ticketNo;

    public String getExpiredDate() {
        /* 39 */
        return this.expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        /* 36 */
        this.expiredDate = expiredDate;
    }

    public String getQrCodeNo() {
        /* 46 */
        return this.qrCodeNo;
    }

    public void setQrCodeNo(String qrCodeNo) {
        /* 43 */
        this.qrCodeNo = qrCodeNo;
    }

    public String getTicketNo() {
        /* 53 */
        return this.ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        /* 50 */
        this.ticketNo = ticketNo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayCommerceCityfacilitatorVoucherGenerateResponse
 * JD-Core Version:    0.6.0
 */