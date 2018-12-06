package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOfflineMarketShopApplyorderCancelModel extends AlipayObject {
    private static final long serialVersionUID = 6646689968887279336L;

    @ApiField("memo")
    private String memo;

    @ApiField("op_id")
    private String opId;

    @ApiField("order_id")
    private String orderId;

    public String getMemo() {
        /* 35 */
        return this.memo;
    }

    public void setMemo(String memo) {
        /* 38 */
        this.memo = memo;
    }

    public String getOpId() {
        /* 42 */
        return this.opId;
    }

    public void setOpId(String opId) {
        /* 45 */
        this.opId = opId;
    }

    public String getOrderId() {
        /* 49 */
        return this.orderId;
    }

    public void setOrderId(String orderId) {
        /* 52 */
        this.orderId = orderId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOfflineMarketShopApplyorderCancelModel
 * JD-Core Version:    0.6.0
 */