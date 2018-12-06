package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class CodeNOList extends AlipayObject {
    private static final long serialVersionUID = 5539182989212441491L;

    @ApiField("amount")
    private String amount;

    @ApiField("code_no")
    private String codeNo;

    @ApiField("sub_type")
    private String subType;

    @ApiField("ticket_type")
    private String ticketType;

    @ApiField("valid_date")
    private String validDate;

    public String getAmount() {
        /* 47 */
        return this.amount;
    }

    public void setAmount(String amount) {
        /* 50 */
        this.amount = amount;
    }

    public String getCodeNo() {
        /* 54 */
        return this.codeNo;
    }

    public void setCodeNo(String codeNo) {
        /* 57 */
        this.codeNo = codeNo;
    }

    public String getSubType() {
        /* 61 */
        return this.subType;
    }

    public void setSubType(String subType) {
        /* 64 */
        this.subType = subType;
    }

    public String getTicketType() {
        /* 68 */
        return this.ticketType;
    }

    public void setTicketType(String ticketType) {
        /* 71 */
        this.ticketType = ticketType;
    }

    public String getValidDate() {
        /* 75 */
        return this.validDate;
    }

    public void setValidDate(String validDate) {
        /* 78 */
        this.validDate = validDate;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.CodeNOList
 * JD-Core Version:    0.6.0
 */