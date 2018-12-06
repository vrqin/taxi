package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class BenefitInfoDetail extends AlipayObject {
    private static final long serialVersionUID = 3362419785496791752L;

    @ApiField("amount")
    private String amount;

    @ApiField("benefit_type")
    private String benefitType;

    @ApiField("count")
    private String count;

    @ApiField("description")
    private String description;

    public String getAmount() {
        /* 44 */
        return this.amount;
    }

    public void setAmount(String amount) {
        /* 47 */
        this.amount = amount;
    }

    public String getBenefitType() {
        /* 51 */
        return this.benefitType;
    }

    public void setBenefitType(String benefitType) {
        /* 54 */
        this.benefitType = benefitType;
    }

    public String getCount() {
        /* 58 */
        return this.count;
    }

    public void setCount(String count) {
        /* 61 */
        this.count = count;
    }

    public String getDescription() {
        /* 65 */
        return this.description;
    }

    public void setDescription(String description) {
        /* 68 */
        this.description = description;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.BenefitInfoDetail
 * JD-Core Version:    0.6.0
 */