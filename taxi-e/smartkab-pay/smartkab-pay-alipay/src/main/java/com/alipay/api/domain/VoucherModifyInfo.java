package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class VoucherModifyInfo extends AlipayObject {
    private static final long serialVersionUID = 2882795379924959613L;

    @ApiListField("suitable_shops")
    @ApiField("string")
    private List<String> suitableShops;

    @ApiField("voucher_desc")
    private String voucherDesc;

    @ApiField("voucher_id")
    private String voucherId;

    @ApiField("voucher_name")
    private String voucherName;

    @ApiListField("voucher_terms")
    @ApiField("voucher_term_info")
    private List<VoucherTermInfo> voucherTerms;

    public List<String> getSuitableShops() {
        /* 52 */
        return this.suitableShops;
    }

    public void setSuitableShops(List<String> suitableShops) {
        /* 55 */
        this.suitableShops = suitableShops;
    }

    public String getVoucherDesc() {
        /* 59 */
        return this.voucherDesc;
    }

    public void setVoucherDesc(String voucherDesc) {
        /* 62 */
        this.voucherDesc = voucherDesc;
    }

    public String getVoucherId() {
        /* 66 */
        return this.voucherId;
    }

    public void setVoucherId(String voucherId) {
        /* 69 */
        this.voucherId = voucherId;
    }

    public String getVoucherName() {
        /* 73 */
        return this.voucherName;
    }

    public void setVoucherName(String voucherName) {
        /* 76 */
        this.voucherName = voucherName;
    }

    public List<VoucherTermInfo> getVoucherTerms() {
        /* 80 */
        return this.voucherTerms;
    }

    public void setVoucherTerms(List<VoucherTermInfo> voucherTerms) {
        /* 83 */
        this.voucherTerms = voucherTerms;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.VoucherModifyInfo
 * JD-Core Version:    0.6.0
 */