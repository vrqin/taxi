package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOfflineMarketingVoucherModifyModel extends AlipayObject {
    private static final long serialVersionUID = 4327911267523748676L;

    @ApiField("budget_info")
    private BudgetInfo budgetInfo;

    @ApiField("ext_info")
    private String extInfo;

    @ApiField("get_count_limit")
    private PeriodInfo getCountLimit;

    @ApiField("out_biz_no")
    private String outBizNo;

    @ApiField("voucher_info")
    private VoucherModifyInfo voucherInfo;

    public BudgetInfo getBudgetInfo() {
        /* 47 */
        return this.budgetInfo;
    }

    public void setBudgetInfo(BudgetInfo budgetInfo) {
        /* 50 */
        this.budgetInfo = budgetInfo;
    }

    public String getExtInfo() {
        /* 54 */
        return this.extInfo;
    }

    public void setExtInfo(String extInfo) {
        /* 57 */
        this.extInfo = extInfo;
    }

    public PeriodInfo getGetCountLimit() {
        /* 61 */
        return this.getCountLimit;
    }

    public void setGetCountLimit(PeriodInfo getCountLimit) {
        /* 64 */
        this.getCountLimit = getCountLimit;
    }

    public String getOutBizNo() {
        /* 68 */
        return this.outBizNo;
    }

    public void setOutBizNo(String outBizNo) {
        /* 71 */
        this.outBizNo = outBizNo;
    }

    public VoucherModifyInfo getVoucherInfo() {
        /* 75 */
        return this.voucherInfo;
    }

    public void setVoucherInfo(VoucherModifyInfo voucherInfo) {
        /* 78 */
        this.voucherInfo = voucherInfo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOfflineMarketingVoucherModifyModel
 * JD-Core Version:    0.6.0
 */