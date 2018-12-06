package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOfflineMarketShopApplyorderCancelResponse extends AlipayResponse {
    private static final long serialVersionUID = 1395765168115325914L;

    @ApiField("apply_id")
    private String applyId;

    public String getApplyId() {
        /* 27 */
        return this.applyId;
    }

    public void setApplyId(String applyId) {
        /* 24 */
        this.applyId = applyId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOfflineMarketShopApplyorderCancelResponse
 * JD-Core Version:    0.6.0
 */