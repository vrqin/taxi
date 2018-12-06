package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiMarketingDataCustomreportBatchqueryModel extends AlipayObject {
    private static final long serialVersionUID = 1719464683497283394L;

    @ApiField("page_no")
    private String pageNo;

    @ApiField("page_size")
    private String pageSize;

    public String getPageNo() {
        /* 29 */
        return this.pageNo;
    }

    public void setPageNo(String pageNo) {
        /* 32 */
        this.pageNo = pageNo;
    }

    public String getPageSize() {
        /* 36 */
        return this.pageSize;
    }

    public void setPageSize(String pageSize) {
        /* 39 */
        this.pageSize = pageSize;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMarketingDataCustomreportBatchqueryModel
 * JD-Core Version:    0.6.0
 */