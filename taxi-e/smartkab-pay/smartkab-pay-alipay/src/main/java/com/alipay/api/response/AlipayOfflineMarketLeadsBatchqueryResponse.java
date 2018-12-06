package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.LeadsQueryResponse;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayOfflineMarketLeadsBatchqueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 6372846193492928649L;

    @ApiField("current_page_no")
    private Long currentPageNo;

    @ApiListField("leads_query_responses")
    @ApiField("leads_query_response")
    private List<LeadsQueryResponse> leadsQueryResponses;

    @ApiField("page_size")
    private Long pageSize;

    @ApiField("total_items")
    private Long totalItems;

    @ApiField("total_page_no")
    private Long totalPageNo;

    public Long getCurrentPageNo() {
        /* 55 */
        return this.currentPageNo;
    }

    public void setCurrentPageNo(Long currentPageNo) {
        /* 52 */
        this.currentPageNo = currentPageNo;
    }

    public List<LeadsQueryResponse> getLeadsQueryResponses() {
        /* 62 */
        return this.leadsQueryResponses;
    }

    public void setLeadsQueryResponses(List<LeadsQueryResponse> leadsQueryResponses) {
        /* 59 */
        this.leadsQueryResponses = leadsQueryResponses;
    }

    public Long getPageSize() {
        /* 69 */
        return this.pageSize;
    }

    public void setPageSize(Long pageSize) {
        /* 66 */
        this.pageSize = pageSize;
    }

    public Long getTotalItems() {
        /* 76 */
        return this.totalItems;
    }

    public void setTotalItems(Long totalItems) {
        /* 73 */
        this.totalItems = totalItems;
    }

    public Long getTotalPageNo() {
        /* 83 */
        return this.totalPageNo;
    }

    public void setTotalPageNo(Long totalPageNo) {
        /* 80 */
        this.totalPageNo = totalPageNo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOfflineMarketLeadsBatchqueryResponse
 * JD-Core Version:    0.6.0
 */