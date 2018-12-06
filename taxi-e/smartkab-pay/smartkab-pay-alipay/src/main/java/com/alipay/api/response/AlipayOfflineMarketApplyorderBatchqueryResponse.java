package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.BizOrderQueryResponse;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayOfflineMarketApplyorderBatchqueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 6698587877674525998L;

    @ApiListField("biz_order_infos")
    @ApiField("biz_order_query_response")
    private List<BizOrderQueryResponse> bizOrderInfos;

    @ApiField("current_page_no")
    private Long currentPageNo;

    @ApiField("page_size")
    private Long pageSize;

    @ApiField("total_items")
    private Long totalItems;

    @ApiField("total_page_no")
    private Long totalPageNo;

    public List<BizOrderQueryResponse> getBizOrderInfos() {
        /* 55 */
        return this.bizOrderInfos;
    }

    public void setBizOrderInfos(List<BizOrderQueryResponse> bizOrderInfos) {
        /* 52 */
        this.bizOrderInfos = bizOrderInfos;
    }

    public Long getCurrentPageNo() {
        /* 62 */
        return this.currentPageNo;
    }

    public void setCurrentPageNo(Long currentPageNo) {
        /* 59 */
        this.currentPageNo = currentPageNo;
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
 * Qualified Name:     com.alipay.api.response.AlipayOfflineMarketApplyorderBatchqueryResponse
 * JD-Core Version:    0.6.0
 */