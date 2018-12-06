package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOfflineMarketItemModifyResponse extends AlipayResponse {
    private static final long serialVersionUID = 7639268646382646757L;

    @ApiField("item_id")
    private String itemId;

    @ApiField("request_id")
    private String requestId;

    public String getItemId() {
        /* 33 */
        return this.itemId;
    }

    public void setItemId(String itemId) {
        /* 30 */
        this.itemId = itemId;
    }

    public String getRequestId() {
        /* 40 */
        return this.requestId;
    }

    public void setRequestId(String requestId) {
        /* 37 */
        this.requestId = requestId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOfflineMarketItemModifyResponse
 * JD-Core Version:    0.6.0
 */