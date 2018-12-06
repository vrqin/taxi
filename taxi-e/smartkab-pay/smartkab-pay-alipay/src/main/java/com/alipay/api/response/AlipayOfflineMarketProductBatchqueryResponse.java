package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayOfflineMarketProductBatchqueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 2352163139862336978L;

    @ApiField("current_pageno")
    private Long currentPageno;

    @ApiListField("item_ids")
    @ApiField("string")
    private List<String> itemIds;

    @ApiField("total_pageno")
    private Long totalPageno;

    public Long getCurrentPageno() {
        /* 42 */
        return this.currentPageno;
    }

    public void setCurrentPageno(Long currentPageno) {
        /* 39 */
        this.currentPageno = currentPageno;
    }

    public List<String> getItemIds() {
        /* 49 */
        return this.itemIds;
    }

    public void setItemIds(List<String> itemIds) {
        /* 46 */
        this.itemIds = itemIds;
    }

    public Long getTotalPageno() {
        /* 56 */
        return this.totalPageno;
    }

    public void setTotalPageno(Long totalPageno) {
        /* 53 */
        this.totalPageno = totalPageno;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOfflineMarketProductBatchqueryResponse
 * JD-Core Version:    0.6.0
 */