package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayFundTransOrderToaccountModel extends AlipayObject {
    private static final long serialVersionUID = 8136689335745386321L;


    @ApiField("amount")
    private String amount;


    @ApiField("ext_param")
    private String extParam;


    @ApiField("out_biz_no")
    private String outBizNo;


    @ApiField("payee_account")
    private String payeeAccount;


    @ApiField("payee_real_name")
    private String payeeRealName;


    @ApiField("payee_type")
    private String payeeType;


    @ApiField("payer_real_name")
    private String payerRealName;


    @ApiField("payer_show_name")
    private String payerShowName;


    @ApiField("remark")
    private String remark;


    public String getAmount() {
        /*  81 */
        return this.amount;

    }


    public void setAmount(String amount) {
        /*  84 */
        this.amount = amount;

    }


    public String getExtParam() {
        /*  88 */
        return this.extParam;

    }


    public void setExtParam(String extParam) {
        /*  91 */
        this.extParam = extParam;

    }


    public String getOutBizNo() {
        /*  95 */
        return this.outBizNo;

    }


    public void setOutBizNo(String outBizNo) {
        /*  98 */
        this.outBizNo = outBizNo;

    }


    public String getPayeeAccount() {
        /* 102 */
        return this.payeeAccount;

    }


    public void setPayeeAccount(String payeeAccount) {
        /* 105 */
        this.payeeAccount = payeeAccount;

    }


    public String getPayeeRealName() {
        /* 109 */
        return this.payeeRealName;

    }


    public void setPayeeRealName(String payeeRealName) {
        /* 112 */
        this.payeeRealName = payeeRealName;

    }


    public String getPayeeType() {
        /* 116 */
        return this.payeeType;

    }


    public void setPayeeType(String payeeType) {
        /* 119 */
        this.payeeType = payeeType;

    }


    public String getPayerRealName() {
        /* 123 */
        return this.payerRealName;

    }


    public void setPayerRealName(String payerRealName) {
        /* 126 */
        this.payerRealName = payerRealName;

    }


    public String getPayerShowName() {
        /* 130 */
        return this.payerShowName;

    }


    public void setPayerShowName(String payerShowName) {
        /* 133 */
        this.payerShowName = payerShowName;

    }


    public String getRemark() {
        /* 137 */
        return this.remark;

    }


    public void setRemark(String remark) {
        /* 140 */
        this.remark = remark;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayFundTransOrderToaccountModel
 * JD-Core Version:    0.6.0
 */