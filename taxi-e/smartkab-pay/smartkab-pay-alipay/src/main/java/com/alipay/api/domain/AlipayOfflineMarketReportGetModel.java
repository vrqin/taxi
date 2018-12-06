package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOfflineMarketReportGetModel extends AlipayObject {
    private static final long serialVersionUID = 1448797843127363359L;

    @ApiField("ope_pid")
    private String opePid;

    @ApiField("request_id")
    private String requestId;

    @ApiField("shop_id")
    private String shopId;

    public String getOpePid() {
        /* 35 */
        return this.opePid;
    }

    public void setOpePid(String opePid) {
        /* 38 */
        this.opePid = opePid;
    }

    public String getRequestId() {
        /* 42 */
        return this.requestId;
    }

    public void setRequestId(String requestId) {
        /* 45 */
        this.requestId = requestId;
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
 * Qualified Name:     com.alipay.api.domain.AlipayOfflineMarketReportGetModel
 * JD-Core Version:    0.6.0
 */