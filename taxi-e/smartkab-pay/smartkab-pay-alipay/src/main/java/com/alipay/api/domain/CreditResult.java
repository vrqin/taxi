package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;


public class CreditResult extends AlipayObject {
    private static final long serialVersionUID = 3272694256618868741L;


    @ApiField("credit_line")
    private String creditLine;


    @ApiField("credit_no")
    private String creditNo;


    @ApiField("credit_term")
    private Long creditTerm;


    @ApiField("credit_term_unit")
    private String creditTermUnit;


    @ApiField("effective_date")
    private Date effectiveDate;


    @ApiField("expire_date")
    private Date expireDate;


    @ApiField("fee_rate")
    private String feeRate;


    @ApiField("interest_rate")
    private String interestRate;


    @ApiField("loan_term")
    private Long loanTerm;


    @ApiField("loan_term_unit")
    private String loanTermUnit;


    @ApiField("repayment_mode")
    private String repaymentMode;


    public String getCreditLine() {
        /*  85 */
        return this.creditLine;

    }


    public void setCreditLine(String creditLine) {
        /*  88 */
        this.creditLine = creditLine;

    }


    public String getCreditNo() {
        /*  92 */
        return this.creditNo;

    }


    public void setCreditNo(String creditNo) {
        /*  95 */
        this.creditNo = creditNo;

    }


    public Long getCreditTerm() {
        /*  99 */
        return this.creditTerm;

    }


    public void setCreditTerm(Long creditTerm) {
        /* 102 */
        this.creditTerm = creditTerm;

    }


    public String getCreditTermUnit() {
        /* 106 */
        return this.creditTermUnit;

    }


    public void setCreditTermUnit(String creditTermUnit) {
        /* 109 */
        this.creditTermUnit = creditTermUnit;

    }


    public Date getEffectiveDate() {
        /* 113 */
        return this.effectiveDate;

    }


    public void setEffectiveDate(Date effectiveDate) {
        /* 116 */
        this.effectiveDate = effectiveDate;

    }


    public Date getExpireDate() {
        /* 120 */
        return this.expireDate;

    }


    public void setExpireDate(Date expireDate) {
        /* 123 */
        this.expireDate = expireDate;

    }


    public String getFeeRate() {
        /* 127 */
        return this.feeRate;

    }


    public void setFeeRate(String feeRate) {
        /* 130 */
        this.feeRate = feeRate;

    }


    public String getInterestRate() {
        /* 134 */
        return this.interestRate;

    }


    public void setInterestRate(String interestRate) {
        /* 137 */
        this.interestRate = interestRate;

    }


    public Long getLoanTerm() {
        /* 141 */
        return this.loanTerm;

    }


    public void setLoanTerm(Long loanTerm) {
        /* 144 */
        this.loanTerm = loanTerm;

    }


    public String getLoanTermUnit() {
        /* 148 */
        return this.loanTermUnit;

    }


    public void setLoanTermUnit(String loanTermUnit) {
        /* 151 */
        this.loanTermUnit = loanTermUnit;

    }


    public String getRepaymentMode() {
        /* 155 */
        return this.repaymentMode;

    }


    public void setRepaymentMode(String repaymentMode) {
        /* 158 */
        this.repaymentMode = repaymentMode;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.CreditResult
 * JD-Core Version:    0.6.0
 */