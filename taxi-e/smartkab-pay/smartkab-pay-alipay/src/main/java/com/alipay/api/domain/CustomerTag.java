package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class CustomerTag extends AlipayObject {
    private static final long serialVersionUID = 4478342173915352684L;

    @ApiField("col_name")
    private String colName;

    @ApiField("column_type")
    private String columnType;

    @ApiField("id")
    private String id;

    @ApiField("name")
    private String name;

    public String getColName() {
        /* 41 */
        return this.colName;
    }

    public void setColName(String colName) {
        /* 44 */
        this.colName = colName;
    }

    public String getColumnType() {
        /* 48 */
        return this.columnType;
    }

    public void setColumnType(String columnType) {
        /* 51 */
        this.columnType = columnType;
    }

    public String getId() {
        /* 55 */
        return this.id;
    }

    public void setId(String id) {
        /* 58 */
        this.id = id;
    }

    public String getName() {
        /* 62 */
        return this.name;
    }

    public void setName(String name) {
        /* 65 */
        this.name = name;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.CustomerTag
 * JD-Core Version:    0.6.0
 */