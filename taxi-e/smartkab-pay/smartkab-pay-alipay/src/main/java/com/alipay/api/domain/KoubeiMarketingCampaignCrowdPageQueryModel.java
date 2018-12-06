package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class KoubeiMarketingCampaignCrowdPageQueryModel extends AlipayObject {
    private static final long serialVersionUID = 2385619788163677729L;

    @ApiField("name")
    private String name;

    @ApiField("page_number")
    private String pageNumber;

    @ApiField("page_size")
    private String pageSize;

    public String getName() {
        /* 35 */
        return this.name;
    }

    public void setName(String name) {
        /* 38 */
        this.name = name;
    }

    public String getPageNumber() {
        /* 42 */
        return this.pageNumber;
    }

    public void setPageNumber(String pageNumber) {
        /* 45 */
        this.pageNumber = pageNumber;
    }

    public String getPageSize() {
        /* 49 */
        return this.pageSize;
    }

    public void setPageSize(String pageSize) {
        /* 52 */
        this.pageSize = pageSize;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMarketingCampaignCrowdPageQueryModel
 * JD-Core Version:    0.6.0
 */