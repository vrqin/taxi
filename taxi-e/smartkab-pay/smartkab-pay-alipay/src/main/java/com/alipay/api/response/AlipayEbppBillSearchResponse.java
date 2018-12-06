package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.QueryInstBillInfo;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayEbppBillSearchResponse extends AlipayResponse {
    private static final long serialVersionUID = 3449169849614298825L;

    @ApiField("cachekey")
    private String cachekey;

    @ApiListField("inst_bill_info_list")
    @ApiField("query_inst_bill_info")
    private List<QueryInstBillInfo> instBillInfoList;

    public String getCachekey() {
        /* 37 */
        return this.cachekey;
    }

    public void setCachekey(String cachekey) {
        /* 34 */
        this.cachekey = cachekey;
    }

    public List<QueryInstBillInfo> getInstBillInfoList() {
        /* 44 */
        return this.instBillInfoList;
    }

    public void setInstBillInfoList(List<QueryInstBillInfo> instBillInfoList) {
        /* 41 */
        this.instBillInfoList = instBillInfoList;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayEbppBillSearchResponse
 * JD-Core Version:    0.6.0
 */