package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayCommerceCityfacilitatorScardcenterDepositQueryModel extends AlipayObject {
    private static final long serialVersionUID = 4683511753188652814L;

    @ApiField("card_no")
    private String cardNo;

    @ApiField("card_type")
    private String cardType;

    @ApiField("status")
    private String status;

    public String getCardNo() {
        /* 35 */
        return this.cardNo;
    }

    public void setCardNo(String cardNo) {
        /* 38 */
        this.cardNo = cardNo;
    }

    public String getCardType() {
        /* 42 */
        return this.cardType;
    }

    public void setCardType(String cardType) {
        /* 45 */
        this.cardType = cardType;
    }

    public String getStatus() {
        /* 49 */
        return this.status;
    }

    public void setStatus(String status) {
        /* 52 */
        this.status = status;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayCommerceCityfacilitatorScardcenterDepositQueryModel
 * JD-Core Version:    0.6.0
 */