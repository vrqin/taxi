package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class PromoTool extends AlipayObject {
    private static final long serialVersionUID = 6135943994114846723L;

    @ApiField("send_rule")
    private SendRule sendRule;

    @ApiField("voucher")
    private Voucher voucher;

    @ApiField("voucher_no")
    private String voucherNo;

    public SendRule getSendRule() {
        /* 35 */
        return this.sendRule;
    }

    public void setSendRule(SendRule sendRule) {
        /* 38 */
        this.sendRule = sendRule;
    }

    public Voucher getVoucher() {
        /* 42 */
        return this.voucher;
    }

    public void setVoucher(Voucher voucher) {
        /* 45 */
        this.voucher = voucher;
    }

    public String getVoucherNo() {
        /* 49 */
        return this.voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        /* 52 */
        this.voucherNo = voucherNo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.PromoTool
 * JD-Core Version:    0.6.0
 */