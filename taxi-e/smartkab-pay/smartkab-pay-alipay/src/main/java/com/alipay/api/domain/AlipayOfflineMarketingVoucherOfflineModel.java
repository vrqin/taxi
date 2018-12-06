package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOfflineMarketingVoucherOfflineModel extends AlipayObject {
    private static final long serialVersionUID = 6775135346972494987L;

    @ApiField("memo")
    private String memo;

    @ApiField("out_biz_no")
    private String outBizNo;

    @ApiField("voucher_id")
    private String voucherId;

    public String getMemo() {
        /* 35 */
        return this.memo;
    }

    public void setMemo(String memo) {
        /* 38 */
        this.memo = memo;
    }

    public String getOutBizNo() {
        /* 42 */
        return this.outBizNo;
    }

    public void setOutBizNo(String outBizNo) {
        /* 45 */
        this.outBizNo = outBizNo;
    }

    public String getVoucherId() {
        /* 49 */
        return this.voucherId;
    }

    public void setVoucherId(String voucherId) {
        /* 52 */
        this.voucherId = voucherId;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOfflineMarketingVoucherOfflineModel
 * JD-Core Version:    0.6.0
 */