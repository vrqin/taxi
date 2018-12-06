package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOfflineMarketingVoucherCreateModel extends AlipayObject {
    private static final long serialVersionUID = 6242771564431877873L;

    @ApiField("budget_info")
    private BudgetInfo budgetInfo;

    @ApiField("code_inventory_id")
    private String codeInventoryId;

    @ApiField("ext_info")
    private String extInfo;

    @ApiField("get_rule")
    private GetRuleInfo getRule;

    @ApiField("out_biz_no")
    private String outBizNo;

    @ApiField("voucher_info")
    private VoucherInfo voucherInfo;

    public BudgetInfo getBudgetInfo() {
        /* 53 */
        return this.budgetInfo;
    }

    public void setBudgetInfo(BudgetInfo budgetInfo) {
        /* 56 */
        this.budgetInfo = budgetInfo;
    }

    public String getCodeInventoryId() {
        /* 60 */
        return this.codeInventoryId;
    }

    public void setCodeInventoryId(String codeInventoryId) {
        /* 63 */
        this.codeInventoryId = codeInventoryId;
    }

    public String getExtInfo() {
        /* 67 */
        return this.extInfo;
    }

    public void setExtInfo(String extInfo) {
        /* 70 */
        this.extInfo = extInfo;
    }

    public GetRuleInfo getGetRule() {
        /* 74 */
        return this.getRule;
    }

    public void setGetRule(GetRuleInfo getRule) {
        /* 77 */
        this.getRule = getRule;
    }

    public String getOutBizNo() {
        /* 81 */
        return this.outBizNo;
    }

    public void setOutBizNo(String outBizNo) {
        /* 84 */
        this.outBizNo = outBizNo;
    }

    public VoucherInfo getVoucherInfo() {
        /* 88 */
        return this.voucherInfo;
    }

    public void setVoucherInfo(VoucherInfo voucherInfo) {
        /* 91 */
        this.voucherInfo = voucherInfo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOfflineMarketingVoucherCreateModel
 * JD-Core Version:    0.6.0
 */