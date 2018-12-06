package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOfflineMarketShopAssignstaffModel extends AlipayObject {
    private static final long serialVersionUID = 1872734115666243364L;

    @ApiField("allocated_staff_id")
    private String allocatedStaffId;

    @ApiField("ope_pid")
    private String opePid;

    @ApiField("request_id")
    private String requestId;

    @ApiField("shop_id")
    private String shopId;

    public String getAllocatedStaffId() {
        /* 41 */
        return this.allocatedStaffId;
    }

    public void setAllocatedStaffId(String allocatedStaffId) {
        /* 44 */
        this.allocatedStaffId = allocatedStaffId;
    }

    public String getOpePid() {
        /* 48 */
        return this.opePid;
    }

    public void setOpePid(String opePid) {
        /* 51 */
        this.opePid = opePid;
    }

    public String getRequestId() {
        /* 55 */
        return this.requestId;
    }

    public void setRequestId(String requestId) {
        /* 58 */
        this.requestId = requestId;
    }

    public String getShopId() {
        /* 62 */
        return this.shopId;
    }

    public void setShopId(String shopId) {
        /* 65 */
        this.shopId = shopId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOfflineMarketShopAssignstaffModel
 * JD-Core Version:    0.6.0
 */