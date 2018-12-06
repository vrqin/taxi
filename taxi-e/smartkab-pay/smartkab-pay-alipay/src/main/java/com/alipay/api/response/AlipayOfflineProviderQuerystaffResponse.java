package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.StaffDTO;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayOfflineProviderQuerystaffResponse extends AlipayResponse {
    private static final long serialVersionUID = 2586169126582229349L;

    @ApiField("current_page")
    private Long currentPage;

    @ApiField("items_per_page")
    private Long itemsPerPage;

    @ApiListField("query_result")
    @ApiField("staff_d_t_o")
    private List<StaffDTO> queryResult;

    @ApiField("total_count")
    private Long totalCount;

    @ApiField("total_pages")
    private Long totalPages;

    public Long getCurrentPage() {
        /* 55 */
        return this.currentPage;
    }

    public void setCurrentPage(Long currentPage) {
        /* 52 */
        this.currentPage = currentPage;
    }

    public Long getItemsPerPage() {
        /* 62 */
        return this.itemsPerPage;
    }

    public void setItemsPerPage(Long itemsPerPage) {
        /* 59 */
        this.itemsPerPage = itemsPerPage;
    }

    public List<StaffDTO> getQueryResult() {
        /* 69 */
        return this.queryResult;
    }

    public void setQueryResult(List<StaffDTO> queryResult) {
        /* 66 */
        this.queryResult = queryResult;
    }

    public Long getTotalCount() {
        /* 76 */
        return this.totalCount;
    }

    public void setTotalCount(Long totalCount) {
        /* 73 */
        this.totalCount = totalCount;
    }

    public Long getTotalPages() {
        /* 83 */
        return this.totalPages;
    }

    public void setTotalPages(Long totalPages) {
        /* 80 */
        this.totalPages = totalPages;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOfflineProviderQuerystaffResponse
 * JD-Core Version:    0.6.0
 */