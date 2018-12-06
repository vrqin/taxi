package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayDataItemLimitPeriodInfo extends AlipayObject {
    private static final long serialVersionUID = 8541171426686234211L;

    @ApiField("rule")
    private String rule;

    @ApiField("unit")
    private String unit;

    @ApiListField("value")
    @ApiField("number")
    private List<Long> value;

    public String getRule() {
        /* 46 */
        return this.rule;
    }

    public void setRule(String rule) {
        /* 49 */
        this.rule = rule;
    }

    public String getUnit() {
        /* 53 */
        return this.unit;
    }

    public void setUnit(String unit) {
        /* 56 */
        this.unit = unit;
    }

    public List<Long> getValue() {
        /* 60 */
        return this.value;
    }

    public void setValue(List<Long> value) {
        /* 63 */
        this.value = value;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayDataItemLimitPeriodInfo
 * JD-Core Version:    0.6.0
 */