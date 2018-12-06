package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class OpenApiRoyaltyDetailInfoPojo extends AlipayObject {
    private static final long serialVersionUID = 2327573874755321868L;

    @ApiField("amount")
    private Long amount;

    @ApiField("amount_percentage")
    private Long amountPercentage;

    @ApiField("desc")
    private String desc;

    @ApiField("trans_in")
    private String transIn;

    @ApiField("trans_out")
    private String transOut;

    public Long getAmount() {
        /* 47 */
        return this.amount;
    }

    public void setAmount(Long amount) {
        /* 50 */
        this.amount = amount;
    }

    public Long getAmountPercentage() {
        /* 54 */
        return this.amountPercentage;
    }

    public void setAmountPercentage(Long amountPercentage) {
        /* 57 */
        this.amountPercentage = amountPercentage;
    }

    public String getDesc() {
        /* 61 */
        return this.desc;
    }

    public void setDesc(String desc) {
        /* 64 */
        this.desc = desc;
    }

    public String getTransIn() {
        /* 68 */
        return this.transIn;
    }

    public void setTransIn(String transIn) {
        /* 71 */
        this.transIn = transIn;
    }

    public String getTransOut() {
        /* 75 */
        return this.transOut;
    }

    public void setTransOut(String transOut) {
        /* 78 */
        this.transOut = transOut;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.OpenApiRoyaltyDetailInfoPojo
 * JD-Core Version:    0.6.0
 */