package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOfflineMarketingVoucherStatusQueryModel extends AlipayObject {
    private static final long serialVersionUID = 8658466364455636647L;

    @ApiField("out_biz_no")
    private String outBizNo;

    @ApiField("voucher_id")
    private String voucherId;

    public String getOutBizNo() {
        /* 29 */
        return this.outBizNo;
    }

    public void setOutBizNo(String outBizNo) {
        /* 32 */
        this.outBizNo = outBizNo;
    }

    public String getVoucherId() {
        /* 36 */
        return this.voucherId;
    }

    public void setVoucherId(String voucherId) {
        /* 39 */
        this.voucherId = voucherId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOfflineMarketingVoucherStatusQueryModel
 * JD-Core Version:    0.6.0
 */