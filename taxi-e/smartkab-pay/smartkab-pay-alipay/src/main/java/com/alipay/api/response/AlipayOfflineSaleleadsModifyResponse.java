package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOfflineSaleleadsModifyResponse extends AlipayResponse {
    private static final long serialVersionUID = 5254615459631281111L;

    @ApiField("leads_id")
    private String leadsId;

    public String getLeadsId() {
        /* 27 */
        return this.leadsId;
    }

    public void setLeadsId(String leadsId) {
        /* 24 */
        this.leadsId = leadsId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOfflineSaleleadsModifyResponse
 * JD-Core Version:    0.6.0
 */