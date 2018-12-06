package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.TradeRecord;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayUserTradeSearchResponse extends AlipayResponse {
    private static final long serialVersionUID = 1162932844415159299L;

    @ApiField("total_pages")
    private String totalPages;

    @ApiField("total_results")
    private String totalResults;

    @ApiListField("trade_records")
    @ApiField("trade_record")
    private List<TradeRecord> tradeRecords;

    public String getTotalPages() {
        /* 43 */
        return this.totalPages;
    }

    public void setTotalPages(String totalPages) {
        /* 40 */
        this.totalPages = totalPages;
    }

    public String getTotalResults() {
        /* 50 */
        return this.totalResults;
    }

    public void setTotalResults(String totalResults) {
        /* 47 */
        this.totalResults = totalResults;
    }

    public List<TradeRecord> getTradeRecords() {
        /* 57 */
        return this.tradeRecords;
    }

    public void setTradeRecords(List<TradeRecord> tradeRecords) {
        /* 54 */
        this.tradeRecords = tradeRecords;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayUserTradeSearchResponse
 * JD-Core Version:    0.6.0
 */