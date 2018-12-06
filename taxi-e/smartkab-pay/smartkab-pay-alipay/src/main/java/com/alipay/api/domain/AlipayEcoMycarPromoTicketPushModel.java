package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayEcoMycarPromoTicketPushModel extends AlipayObject {
    private static final long serialVersionUID = 5185475445852765223L;

    @ApiField("apply_no")
    private String applyNo;

    @ApiField("apply_status")
    private String applyStatus;

    @ApiField("code_no")
    private String codeNo;

    @ApiField("ticket_id")
    private String ticketId;

    public String getApplyNo() {
        /* 41 */
        return this.applyNo;
    }

    public void setApplyNo(String applyNo) {
        /* 44 */
        this.applyNo = applyNo;
    }

    public String getApplyStatus() {
        /* 48 */
        return this.applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        /* 51 */
        this.applyStatus = applyStatus;
    }

    public String getCodeNo() {
        /* 55 */
        return this.codeNo;
    }

    public void setCodeNo(String codeNo) {
        /* 58 */
        this.codeNo = codeNo;
    }

    public String getTicketId() {
        /* 62 */
        return this.ticketId;
    }

    public void setTicketId(String ticketId) {
        /* 65 */
        this.ticketId = ticketId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayEcoMycarPromoTicketPushModel
 * JD-Core Version:    0.6.0
 */