package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayAccount extends AlipayObject {
    private static final long serialVersionUID = 2484247586729339792L;

    @ApiField("alipay_user_id")
    private String alipayUserId;

    @ApiField("available_amount")
    private String availableAmount;

    @ApiField("freeze_amount")
    private String freezeAmount;

    @ApiField("total_amount")
    private String totalAmount;

    public String getAlipayUserId() {
        /* 41 */
        return this.alipayUserId;
    }

    public void setAlipayUserId(String alipayUserId) {
        /* 44 */
        this.alipayUserId = alipayUserId;
    }

    public String getAvailableAmount() {
        /* 48 */
        return this.availableAmount;
    }

    public void setAvailableAmount(String availableAmount) {
        /* 51 */
        this.availableAmount = availableAmount;
    }

    public String getFreezeAmount() {
        /* 55 */
        return this.freezeAmount;
    }

    public void setFreezeAmount(String freezeAmount) {
        /* 58 */
        this.freezeAmount = freezeAmount;
    }

    public String getTotalAmount() {
        /* 62 */
        return this.totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        /* 65 */
        this.totalAmount = totalAmount;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayAccount
 * JD-Core Version:    0.6.0
 */