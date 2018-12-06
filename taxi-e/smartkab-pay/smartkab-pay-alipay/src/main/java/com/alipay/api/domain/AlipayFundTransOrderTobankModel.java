package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayFundTransOrderTobankModel extends AlipayObject {
    private static final long serialVersionUID = 4751829229615278887L;


    @ApiField("amount")
    private String amount;


    @ApiField("memo")
    private String memo;


    @ApiField("out_biz_no")
    private String outBizNo;


    @ApiField("payee_account_name")
    private String payeeAccountName;


    @ApiField("payee_account_type")
    private String payeeAccountType;


    @ApiField("payee_bank_code")
    private String payeeBankCode;


    @ApiField("payee_card_no")
    private String payeeCardNo;


    @ApiField("payee_inst_branch_name")
    private String payeeInstBranchName;


    @ApiField("payee_inst_city")
    private String payeeInstCity;


    @ApiField("payee_inst_name")
    private String payeeInstName;


    @ApiField("payee_inst_province")
    private String payeeInstProvince;


    @ApiField("payer_real_name")
    private String payerRealName;


    @ApiField("remark")
    private String remark;


    @ApiField("time_liness")
    private String timeLiness;


    public String getAmount() {
        /* 123 */
        return this.amount;

    }


    public void setAmount(String amount) {
        /* 126 */
        this.amount = amount;

    }


    public String getMemo() {
        /* 130 */
        return this.memo;

    }


    public void setMemo(String memo) {
        /* 133 */
        this.memo = memo;

    }


    public String getOutBizNo() {
        /* 137 */
        return this.outBizNo;

    }


    public void setOutBizNo(String outBizNo) {
        /* 140 */
        this.outBizNo = outBizNo;

    }


    public String getPayeeAccountName() {
        /* 144 */
        return this.payeeAccountName;

    }


    public void setPayeeAccountName(String payeeAccountName) {
        /* 147 */
        this.payeeAccountName = payeeAccountName;

    }


    public String getPayeeAccountType() {
        /* 151 */
        return this.payeeAccountType;

    }


    public void setPayeeAccountType(String payeeAccountType) {
        /* 154 */
        this.payeeAccountType = payeeAccountType;

    }


    public String getPayeeBankCode() {
        /* 158 */
        return this.payeeBankCode;

    }


    public void setPayeeBankCode(String payeeBankCode) {
        /* 161 */
        this.payeeBankCode = payeeBankCode;

    }


    public String getPayeeCardNo() {
        /* 165 */
        return this.payeeCardNo;

    }


    public void setPayeeCardNo(String payeeCardNo) {
        /* 168 */
        this.payeeCardNo = payeeCardNo;

    }


    public String getPayeeInstBranchName() {
        /* 172 */
        return this.payeeInstBranchName;

    }


    public void setPayeeInstBranchName(String payeeInstBranchName) {
        /* 175 */
        this.payeeInstBranchName = payeeInstBranchName;

    }


    public String getPayeeInstCity() {
        /* 179 */
        return this.payeeInstCity;

    }


    public void setPayeeInstCity(String payeeInstCity) {
        /* 182 */
        this.payeeInstCity = payeeInstCity;

    }


    public String getPayeeInstName() {
        /* 186 */
        return this.payeeInstName;

    }


    public void setPayeeInstName(String payeeInstName) {
        /* 189 */
        this.payeeInstName = payeeInstName;

    }


    public String getPayeeInstProvince() {
        /* 193 */
        return this.payeeInstProvince;

    }


    public void setPayeeInstProvince(String payeeInstProvince) {
        /* 196 */
        this.payeeInstProvince = payeeInstProvince;

    }


    public String getPayerRealName() {
        /* 200 */
        return this.payerRealName;

    }


    public void setPayerRealName(String payerRealName) {
        /* 203 */
        this.payerRealName = payerRealName;

    }


    public String getRemark() {
        /* 207 */
        return this.remark;

    }


    public void setRemark(String remark) {
        /* 210 */
        this.remark = remark;

    }


    public String getTimeLiness() {
        /* 214 */
        return this.timeLiness;

    }


    public void setTimeLiness(String timeLiness) {
        /* 217 */
        this.timeLiness = timeLiness;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayFundTransOrderTobankModel
 * JD-Core Version:    0.6.0
 */