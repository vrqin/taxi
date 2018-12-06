package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class ReportDataItem extends AlipayObject {
    private static final long serialVersionUID = 2154971995489841123L;

    @ApiField("row_data")
    private String rowData;

    public String getRowData() {
        /* 23 */
        return this.rowData;
    }

    public void setRowData(String rowData) {
        /* 26 */
        this.rowData = rowData;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.ReportDataItem
 * JD-Core Version:    0.6.0
 */