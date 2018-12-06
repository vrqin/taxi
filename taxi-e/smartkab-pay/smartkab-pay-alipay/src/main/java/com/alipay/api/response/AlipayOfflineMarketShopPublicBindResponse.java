package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayOfflineMarketShopPublicBindResponse extends AlipayResponse {
    private static final long serialVersionUID = 7611111145354861589L;

    @ApiListField("error_binding_shop_ids")
    @ApiField("string")
    private List<String> errorBindingShopIds;

    @ApiField("total_error")
    private Long totalError;

    @ApiField("total_success")
    private Long totalSuccess;

    public List<String> getErrorBindingShopIds() {
        /* 42 */
        return this.errorBindingShopIds;
    }

    public void setErrorBindingShopIds(List<String> errorBindingShopIds) {
        /* 39 */
        this.errorBindingShopIds = errorBindingShopIds;
    }

    public Long getTotalError() {
        /* 49 */
        return this.totalError;
    }

    public void setTotalError(Long totalError) {
        /* 46 */
        this.totalError = totalError;
    }

    public Long getTotalSuccess() {
        /* 56 */
        return this.totalSuccess;
    }

    public void setTotalSuccess(Long totalSuccess) {
        /* 53 */
        this.totalSuccess = totalSuccess;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOfflineMarketShopPublicBindResponse
 * JD-Core Version:    0.6.0
 */