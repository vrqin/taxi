package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class DstCampRuleModel extends AlipayObject {
    private static final long serialVersionUID = 3748252795414335112L;


    @ApiField("alipay_cashier")
    private String alipayCashier;


    @ApiField("discount_type")
    private String discountType;


    @ApiField("id")
    private String id;


    @ApiField("prize_count_per_account")
    private String prizeCountPerAccount;


    @ApiField("product_type")
    private String productType;


    @ApiField("rule_uuid")
    private String ruleUuid;


    @ApiField("voucher_id")
    private String voucherId;


    public String getAlipayCashier() {
        /*  59 */
        return this.alipayCashier;

    }


    public void setAlipayCashier(String alipayCashier) {
        /*  62 */
        this.alipayCashier = alipayCashier;

    }


    public String getDiscountType() {
        /*  66 */
        return this.discountType;

    }


    public void setDiscountType(String discountType) {
        /*  69 */
        this.discountType = discountType;

    }


    public String getId() {
        /*  73 */
        return this.id;

    }


    public void setId(String id) {
        /*  76 */
        this.id = id;

    }


    public String getPrizeCountPerAccount() {
        /*  80 */
        return this.prizeCountPerAccount;

    }


    public void setPrizeCountPerAccount(String prizeCountPerAccount) {
        /*  83 */
        this.prizeCountPerAccount = prizeCountPerAccount;

    }


    public String getProductType() {
        /*  87 */
        return this.productType;

    }


    public void setProductType(String productType) {
        /*  90 */
        this.productType = productType;

    }


    public String getRuleUuid() {
        /*  94 */
        return this.ruleUuid;

    }


    public void setRuleUuid(String ruleUuid) {
        /*  97 */
        this.ruleUuid = ruleUuid;

    }


    public String getVoucherId() {
        /* 101 */
        return this.voucherId;

    }


    public void setVoucherId(String voucherId) {
        /* 104 */
        this.voucherId = voucherId;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.DstCampRuleModel
 * JD-Core Version:    0.6.0
 */