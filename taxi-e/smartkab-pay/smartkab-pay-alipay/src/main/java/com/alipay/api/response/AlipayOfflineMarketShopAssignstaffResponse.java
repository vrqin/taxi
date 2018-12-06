package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOfflineMarketShopAssignstaffResponse extends AlipayResponse {
    private static final long serialVersionUID = 3875192273687638553L;

    @ApiField("error_msg")
    private String errorMsg;

    @ApiField("result")
    private String result;

    @ApiField("shop_id")
    private String shopId;

    public String getErrorMsg() {
        /* 39 */
        return this.errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        /* 36 */
        this.errorMsg = errorMsg;
    }

    public String getResult() {
        /* 46 */
        return this.result;
    }

    public void setResult(String result) {
        /* 43 */
        this.result = result;
    }

    public String getShopId() {
        /* 53 */
        return this.shopId;
    }

    public void setShopId(String shopId) {
        /* 50 */
        this.shopId = shopId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOfflineMarketShopAssignstaffResponse
 * JD-Core Version:    0.6.0
 */