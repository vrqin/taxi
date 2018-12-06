package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class Condition extends AlipayObject {
    private static final long serialVersionUID = 5592648647927725283L;

    @ApiField("field_name")
    private String fieldName;

    @ApiField("field_value")
    private String fieldValue;

    @ApiField("operator")
    private String operator;

    public String getFieldName() {
        /* 39 */
        return this.fieldName;
    }

    public void setFieldName(String fieldName) {
        /* 42 */
        this.fieldName = fieldName;
    }

    public String getFieldValue() {
        /* 46 */
        return this.fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        /* 49 */
        this.fieldValue = fieldValue;
    }

    public String getOperator() {
        /* 53 */
        return this.operator;
    }

    public void setOperator(String operator) {
        /* 56 */
        this.operator = operator;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.Condition
 * JD-Core Version:    0.6.0
 */