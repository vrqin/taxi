package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOfflineMarketingVoucherCodeUploadResponse extends AlipayResponse {
    private static final long serialVersionUID = 3796655251798667535L;

    @ApiField("code_inventory_id")
    private String codeInventoryId;

    public String getCodeInventoryId() {
        /* 27 */
        return this.codeInventoryId;
    }

    public void setCodeInventoryId(String codeInventoryId) {
        /* 24 */
        this.codeInventoryId = codeInventoryId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOfflineMarketingVoucherCodeUploadResponse
 * JD-Core Version:    0.6.0
 */