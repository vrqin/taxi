package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOfflineMarketingVoucherModifyResponse extends AlipayResponse {
    private static final long serialVersionUID = 4718299981274869896L;

    @ApiField("voucher_id")
    private String voucherId;

    @ApiField("voucher_status")
    private String voucherStatus;

    public String getVoucherId() {
        /* 33 */
        return this.voucherId;
    }

    public void setVoucherId(String voucherId) {
        /* 30 */
        this.voucherId = voucherId;
    }

    public String getVoucherStatus() {
        /* 40 */
        return this.voucherStatus;
    }

    public void setVoucherStatus(String voucherStatus) {
        /* 37 */
        this.voucherStatus = voucherStatus;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOfflineMarketingVoucherModifyResponse
 * JD-Core Version:    0.6.0
 */