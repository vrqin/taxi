package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class LabelFilter extends AlipayObject {
    private static final long serialVersionUID = 3699627947159181576L;

    @ApiField("column_name")
    private String columnName;

    @ApiField("op")
    private String op;

    @ApiListField("values")
    @ApiField("string")
    private List<String> values;

    public String getColumnName() {
        /* 39 */
        return this.columnName;
    }

    public void setColumnName(String columnName) {
        /* 42 */
        this.columnName = columnName;
    }

    public String getOp() {
        /* 46 */
        return this.op;
    }

    public void setOp(String op) {
        /* 49 */
        this.op = op;
    }

    public List<String> getValues() {
        /* 53 */
        return this.values;
    }

    public void setValues(List<String> values) {
        /* 56 */
        this.values = values;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.LabelFilter
 * JD-Core Version:    0.6.0
 */