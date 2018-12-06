package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayUserCreditCard extends AlipayObject {
    private static final long serialVersionUID = 1515131976318698393L;

    @ApiField("card_no")
    private String cardNo;

    @ApiField("inst_id")
    private String instId;

    public String getCardNo() {
        /* 31 */
        return this.cardNo;
    }

    public void setCardNo(String cardNo) {
        /* 34 */
        this.cardNo = cardNo;
    }

    public String getInstId() {
        /* 38 */
        return this.instId;
    }

    public void setInstId(String instId) {
        /* 41 */
        this.instId = instId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayUserCreditCard
 * JD-Core Version:    0.6.0
 */