package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class DiscountRandomModel extends AlipayObject {
    private static final long serialVersionUID = 6842442366231132221L;

    @ApiField("max_amount")
    private String maxAmount;

    @ApiField("min_amount")
    private String minAmount;

    @ApiField("probability")
    private String probability;

    public String getMaxAmount() {
        /* 36 */
        return this.maxAmount;
    }

    public void setMaxAmount(String maxAmount) {
        /* 39 */
        this.maxAmount = maxAmount;
    }

    public String getMinAmount() {
        /* 43 */
        return this.minAmount;
    }

    public void setMinAmount(String minAmount) {
        /* 46 */
        this.minAmount = minAmount;
    }

    public String getProbability() {
        /* 50 */
        return this.probability;
    }

    public void setProbability(String probability) {
        /* 53 */
        this.probability = probability;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.DiscountRandomModel
 * JD-Core Version:    0.6.0
 */