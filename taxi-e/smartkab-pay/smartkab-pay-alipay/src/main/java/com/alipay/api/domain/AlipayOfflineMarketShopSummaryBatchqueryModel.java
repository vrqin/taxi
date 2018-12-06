package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayOfflineMarketShopSummaryBatchqueryModel extends AlipayObject {
    private static final long serialVersionUID = 5457836992739933911L;


    @ApiField("op_role")
    private String opRole;


    @ApiField("page_no")
    private Long pageNo;


    @ApiField("page_size")
    private Long pageSize;


    @ApiField("query_type")
    private String queryType;


    @ApiField("related_partner_id")
    private String relatedPartnerId;


    @ApiField("shop_id")
    private String shopId;


    @ApiField("shop_status")
    private String shopStatus;


    public String getOpRole() {
        /*  64 */
        return this.opRole;

    }


    public void setOpRole(String opRole) {
        /*  67 */
        this.opRole = opRole;

    }


    public Long getPageNo() {
        /*  71 */
        return this.pageNo;

    }


    public void setPageNo(Long pageNo) {
        /*  74 */
        this.pageNo = pageNo;

    }


    public Long getPageSize() {
        /*  78 */
        return this.pageSize;

    }


    public void setPageSize(Long pageSize) {
        /*  81 */
        this.pageSize = pageSize;

    }


    public String getQueryType() {
        /*  85 */
        return this.queryType;

    }


    public void setQueryType(String queryType) {
        /*  88 */
        this.queryType = queryType;

    }


    public String getRelatedPartnerId() {
        /*  92 */
        return this.relatedPartnerId;

    }


    public void setRelatedPartnerId(String relatedPartnerId) {
        /*  95 */
        this.relatedPartnerId = relatedPartnerId;

    }


    public String getShopId() {
        /*  99 */
        return this.shopId;

    }


    public void setShopId(String shopId) {
        /* 102 */
        this.shopId = shopId;

    }


    public String getShopStatus() {
        /* 106 */
        return this.shopStatus;

    }


    public void setShopStatus(String shopStatus) {
        /* 109 */
        this.shopStatus = shopStatus;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOfflineMarketShopSummaryBatchqueryModel
 * JD-Core Version:    0.6.0
 */