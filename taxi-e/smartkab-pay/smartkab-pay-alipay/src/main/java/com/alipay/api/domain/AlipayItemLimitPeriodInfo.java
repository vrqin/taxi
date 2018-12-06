package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayItemLimitPeriodInfo extends AlipayObject {
    private static final long serialVersionUID = 7451143667876858892L;

    @ApiField("rule")
    private String rule;

    @ApiField("unit")
    private String unit;

    @ApiListField("value")
    @ApiField("number")
    private List<Long> value;

    public String getRule() {
        /* 48 */
        return this.rule;
    }

    public void setRule(String rule) {
        /* 51 */
        this.rule = rule;
    }

    public String getUnit() {
        /* 55 */
        return this.unit;
    }

    public void setUnit(String unit) {
        /* 58 */
        this.unit = unit;
    }

    public List<Long> getValue() {
        /* 62 */
        return this.value;
    }

    public void setValue(List<Long> value) {
        /* 65 */
        this.value = value;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayItemLimitPeriodInfo
 * JD-Core Version:    0.6.0
 */