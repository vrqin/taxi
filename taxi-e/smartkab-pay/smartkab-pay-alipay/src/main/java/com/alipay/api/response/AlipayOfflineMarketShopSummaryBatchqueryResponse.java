package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.ShopSummaryQueryResponse;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayOfflineMarketShopSummaryBatchqueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 7361518933762968354L;

    @ApiField("current_page_no")
    private String currentPageNo;

    @ApiField("page_size")
    private String pageSize;

    @ApiListField("shop_summary_infos")
    @ApiField("shop_summary_query_response")
    private List<ShopSummaryQueryResponse> shopSummaryInfos;

    @ApiField("total_items")
    private String totalItems;

    @ApiField("total_page_no")
    private String totalPageNo;

    public String getCurrentPageNo() {
        /* 55 */
        return this.currentPageNo;
    }

    public void setCurrentPageNo(String currentPageNo) {
        /* 52 */
        this.currentPageNo = currentPageNo;
    }

    public String getPageSize() {
        /* 62 */
        return this.pageSize;
    }

    public void setPageSize(String pageSize) {
        /* 59 */
        this.pageSize = pageSize;
    }

    public List<ShopSummaryQueryResponse> getShopSummaryInfos() {
        /* 69 */
        return this.shopSummaryInfos;
    }

    public void setShopSummaryInfos(List<ShopSummaryQueryResponse> shopSummaryInfos) {
        /* 66 */
        this.shopSummaryInfos = shopSummaryInfos;
    }

    public String getTotalItems() {
        /* 76 */
        return this.totalItems;
    }

    public void setTotalItems(String totalItems) {
        /* 73 */
        this.totalItems = totalItems;
    }

    public String getTotalPageNo() {
        /* 83 */
        return this.totalPageNo;
    }

    public void setTotalPageNo(String totalPageNo) {
        /* 80 */
        this.totalPageNo = totalPageNo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOfflineMarketShopSummaryBatchqueryResponse
 * JD-Core Version:    0.6.0
 */