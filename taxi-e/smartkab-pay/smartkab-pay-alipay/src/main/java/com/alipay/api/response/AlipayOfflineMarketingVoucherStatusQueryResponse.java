package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOfflineMarketingVoucherStatusQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 6786971615156754344L;

    @ApiField("ext_info")
    private String extInfo;

    @ApiField("voucher_id")
    private String voucherId;

    @ApiField("voucher_status")
    private String voucherStatus;

    public String getExtInfo() {
        /* 39 */
        return this.extInfo;
    }

    public void setExtInfo(String extInfo) {
        /* 36 */
        this.extInfo = extInfo;
    }

    public String getVoucherId() {
        /* 46 */
        return this.voucherId;
    }

    public void setVoucherId(String voucherId) {
        /* 43 */
        this.voucherId = voucherId;
    }

    public String getVoucherStatus() {
        /* 53 */
        return this.voucherStatus;
    }

    public void setVoucherStatus(String voucherStatus) {
        /* 50 */
        this.voucherStatus = voucherStatus;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayOfflineMarketingVoucherStatusQueryResponse
 * JD-Core Version:    0.6.0
 */