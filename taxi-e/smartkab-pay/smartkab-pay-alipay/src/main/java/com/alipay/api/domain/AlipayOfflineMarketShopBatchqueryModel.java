package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOfflineMarketShopBatchqueryModel extends AlipayObject {
    private static final long serialVersionUID = 5631129269776173936L;

    @ApiField("page_no")
    private String pageNo;

    public String getPageNo() {
        /* 23 */
        return this.pageNo;
    }

    public void setPageNo(String pageNo) {
        /* 26 */
        this.pageNo = pageNo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOfflineMarketShopBatchqueryModel
 * JD-Core Version:    0.6.0
 */