package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayAssetPointBalanceQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 4789227833442235983L;

    @ApiField("point_amount")
    private Long pointAmount;

    public Long getPointAmount() {
        /* 27 */
        return this.pointAmount;
    }

    public void setPointAmount(Long pointAmount) {
        /* 24 */
        this.pointAmount = pointAmount;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayAssetPointBalanceQueryResponse
 * JD-Core Version:    0.6.0
 */