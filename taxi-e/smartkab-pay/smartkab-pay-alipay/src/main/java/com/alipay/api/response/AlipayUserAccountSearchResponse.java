package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.AccountRecord;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayUserAccountSearchResponse extends AlipayResponse {
    private static final long serialVersionUID = 3833696211115356923L;

    @ApiListField("account_records")
    @ApiField("account_record")
    private List<AccountRecord> accountRecords;

    @ApiField("total_pages")
    private Long totalPages;

    @ApiField("total_results")
    private Long totalResults;

    public List<AccountRecord> getAccountRecords() {
        /* 43 */
        return this.accountRecords;
    }

    public void setAccountRecords(List<AccountRecord> accountRecords) {
        /* 40 */
        this.accountRecords = accountRecords;
    }

    public Long getTotalPages() {
        /* 50 */
        return this.totalPages;
    }

    public void setTotalPages(Long totalPages) {
        /* 47 */
        this.totalPages = totalPages;
    }

    public Long getTotalResults() {
        /* 57 */
        return this.totalResults;
    }

    public void setTotalResults(Long totalResults) {
        /* 54 */
        this.totalResults = totalResults;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayUserAccountSearchResponse
 * JD-Core Version:    0.6.0
 */