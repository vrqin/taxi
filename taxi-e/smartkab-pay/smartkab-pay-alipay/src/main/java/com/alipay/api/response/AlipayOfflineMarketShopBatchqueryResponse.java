package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayOfflineMarketShopBatchqueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 7295376378274723442L;

    @ApiField("current_pageno")
    private String currentPageno;

    @ApiListField("shop_ids")
    @ApiField("string")
    private List<String> shopIds;

    @ApiField("total_pageno")
    private String totalPageno;

    public String getCurrentPageno() {
        /* 42 */
        return this.currentPageno;
    }

    public void setCurrentPageno(String currentPageno) {
        /* 39 */
        this.currentPageno = currentPageno;
    }

    public List<String> getShopIds() {
        /* 49 */
        return this.shopIds;
    }

    public void setShopIds(List<String> shopIds) {
        /* 46 */
        this.shopIds = shopIds;
    }

    public String getTotalPageno() {
        /* 56 */
        return this.totalPageno;
    }

    public void setTotalPageno(String totalPageno) {
        /* 53 */
        this.totalPageno = totalPageno;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOfflineMarketShopBatchqueryResponse
 * JD-Core Version:    0.6.0
 */