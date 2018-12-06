package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiMarketingDataIndicatorQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 3128388238945246311L;

    @ApiField("indicator_infos")
    private String indicatorInfos;

    @ApiField("total_size")
    private String totalSize;

    public String getIndicatorInfos() {
        /* 33 */
        return this.indicatorInfos;
    }

    public void setIndicatorInfos(String indicatorInfos) {
        /* 30 */
        this.indicatorInfos = indicatorInfos;
    }

    public String getTotalSize() {
        /* 40 */
        return this.totalSize;
    }

    public void setTotalSize(String totalSize) {
        /* 37 */
        this.totalSize = totalSize;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.KoubeiMarketingDataIndicatorQueryResponse
 * JD-Core Version:    0.6.0
 */