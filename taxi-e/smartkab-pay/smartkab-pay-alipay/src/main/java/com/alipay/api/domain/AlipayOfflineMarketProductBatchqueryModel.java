package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOfflineMarketProductBatchqueryModel extends AlipayObject {
    private static final long serialVersionUID = 3815329518434376474L;

    @ApiField("op_role")
    private String opRole;

    @ApiField("page_no")
    private String pageNo;

    @ApiField("shop_id")
    private String shopId;

    public String getOpRole() {
        /* 35 */
        return this.opRole;
    }

    public void setOpRole(String opRole) {
        /* 38 */
        this.opRole = opRole;
    }

    public String getPageNo() {
        /* 42 */
        return this.pageNo;
    }

    public void setPageNo(String pageNo) {
        /* 45 */
        this.pageNo = pageNo;
    }

    public String getShopId() {
        /* 49 */
        return this.shopId;
    }

    public void setShopId(String shopId) {
        /* 52 */
        this.shopId = shopId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOfflineMarketProductBatchqueryModel
 * JD-Core Version:    0.6.0
 */