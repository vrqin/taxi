package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOfflineSaleleadsInfoAddResponse extends AlipayResponse {
    private static final long serialVersionUID = 3223389587698455787L;

    @ApiField("leads_id")
    private String leadsId;

    @ApiField("message")
    private String message;

    public String getLeadsId() {
        /* 33 */
        return this.leadsId;
    }

    public void setLeadsId(String leadsId) {
        /* 30 */
        this.leadsId = leadsId;
    }

    public String getMessage() {
        /* 40 */
        return this.message;
    }

    public void setMessage(String message) {
        /* 37 */
        this.message = message;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOfflineSaleleadsInfoAddResponse
 * JD-Core Version:    0.6.0
 */