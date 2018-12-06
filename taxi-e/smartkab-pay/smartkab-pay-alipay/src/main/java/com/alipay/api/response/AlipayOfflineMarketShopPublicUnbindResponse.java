package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayOfflineMarketShopPublicUnbindResponse extends AlipayResponse {
    private static final long serialVersionUID = 2853587475476268255L;

    @ApiListField("error_un_binding_shop_ids")
    @ApiField("string")
    private List<String> errorUnBindingShopIds;

    @ApiField("total_error")
    private Long totalError;

    @ApiField("total_success")
    private Long totalSuccess;

    public List<String> getErrorUnBindingShopIds() {
        /* 42 */
        return this.errorUnBindingShopIds;
    }

    public void setErrorUnBindingShopIds(List<String> errorUnBindingShopIds) {
        /* 39 */
        this.errorUnBindingShopIds = errorUnBindingShopIds;
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
 * Qualified Name:     com.alipay.api.response.AlipayOfflineMarketShopPublicUnbindResponse
 * JD-Core Version:    0.6.0
 */