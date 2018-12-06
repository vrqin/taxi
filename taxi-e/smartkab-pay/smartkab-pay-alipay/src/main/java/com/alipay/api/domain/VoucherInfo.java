package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;


public class VoucherInfo extends AlipayObject {
    private static final long serialVersionUID = 7349833923371696557L;


    @ApiField("can_give_friend")
    private Boolean canGiveFriend;


    @ApiField("use_rule")
    private UseRuleInfo useRule;


    @ApiField("valid_date")
    private ValidDateInfo validDate;


    @ApiField("voucher_desc")
    private String voucherDesc;


    @ApiField("voucher_img")
    private String voucherImg;


    @ApiField("voucher_logo")
    private String voucherLogo;


    @ApiField("voucher_name")
    private String voucherName;


    @ApiListField("voucher_terms")

    @ApiField("voucher_term_info")
    private List<VoucherTermInfo> voucherTerms;


    @ApiField("voucher_type")
    private String voucherType;


    public Boolean getCanGiveFriend() {
        /*  75 */
        return this.canGiveFriend;

    }


    public void setCanGiveFriend(Boolean canGiveFriend) {
        /*  78 */
        this.canGiveFriend = canGiveFriend;

    }


    public UseRuleInfo getUseRule() {
        /*  82 */
        return this.useRule;

    }


    public void setUseRule(UseRuleInfo useRule) {
        /*  85 */
        this.useRule = useRule;

    }


    public ValidDateInfo getValidDate() {
        /*  89 */
        return this.validDate;

    }


    public void setValidDate(ValidDateInfo validDate) {
        /*  92 */
        this.validDate = validDate;

    }


    public String getVoucherDesc() {
        /*  96 */
        return this.voucherDesc;

    }


    public void setVoucherDesc(String voucherDesc) {
        /*  99 */
        this.voucherDesc = voucherDesc;

    }


    public String getVoucherImg() {
        /* 103 */
        return this.voucherImg;

    }


    public void setVoucherImg(String voucherImg) {
        /* 106 */
        this.voucherImg = voucherImg;

    }


    public String getVoucherLogo() {
        /* 110 */
        return this.voucherLogo;

    }


    public void setVoucherLogo(String voucherLogo) {
        /* 113 */
        this.voucherLogo = voucherLogo;

    }


    public String getVoucherName() {
        /* 117 */
        return this.voucherName;

    }


    public void setVoucherName(String voucherName) {
        /* 120 */
        this.voucherName = voucherName;

    }


    public List<VoucherTermInfo> getVoucherTerms() {
        /* 124 */
        return this.voucherTerms;

    }


    public void setVoucherTerms(List<VoucherTermInfo> voucherTerms) {
        /* 127 */
        this.voucherTerms = voucherTerms;

    }


    public String getVoucherType() {
        /* 131 */
        return this.voucherType;

    }


    public void setVoucherType(String voucherType) {
        /* 134 */
        this.voucherType = voucherType;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.VoucherInfo
 * JD-Core Version:    0.6.0
 */