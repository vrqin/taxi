package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayCommerceTransportOfflinepayUserblacklistQueryModel extends AlipayObject {
    private static final long serialVersionUID = 3383442528814842537L;

    @ApiField("page_index")
    private Long pageIndex;

    @ApiField("page_size")
    private Long pageSize;

    public Long getPageIndex() {
        /* 29 */
        return this.pageIndex;
    }

    public void setPageIndex(Long pageIndex) {
        /* 32 */
        this.pageIndex = pageIndex;
    }

    public Long getPageSize() {
        /* 36 */
        return this.pageSize;
    }

    public void setPageSize(Long pageSize) {
        /* 39 */
        this.pageSize = pageSize;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayCommerceTransportOfflinepayUserblacklistQueryModel
 * JD-Core Version:    0.6.0
 */