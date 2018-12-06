package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;


public class RepaymentRecords extends AlipayObject {
    private static final long serialVersionUID = 7352362511398938798L;


    @ApiField("date")
    private Date date;


    @ApiField("interest")
    private String interest;


    @ApiField("overdue_interest")
    private String overdueInterest;


    @ApiField("overdue_interest_penalty")
    private String overdueInterestPenalty;


    @ApiField("overdue_principal")
    private String overduePrincipal;


    @ApiField("overdue_principal_penalty")
    private String overduePrincipalPenalty;


    @ApiField("principal")
    private String principal;


    @ApiField("remarks")
    private String remarks;


    @ApiField("total_amount")
    private String totalAmount;


    public Date getDate() {
        /*  73 */
        return this.date;

    }


    public void setDate(Date date) {
        /*  76 */
        this.date = date;

    }


    public String getInterest() {
        /*  80 */
        return this.interest;

    }


    public void setInterest(String interest) {
        /*  83 */
        this.interest = interest;

    }


    public String getOverdueInterest() {
        /*  87 */
        return this.overdueInterest;

    }


    public void setOverdueInterest(String overdueInterest) {
        /*  90 */
        this.overdueInterest = overdueInterest;

    }


    public String getOverdueInterestPenalty() {
        /*  94 */
        return this.overdueInterestPenalty;

    }


    public void setOverdueInterestPenalty(String overdueInterestPenalty) {
        /*  97 */
        this.overdueInterestPenalty = overdueInterestPenalty;

    }


    public String getOverduePrincipal() {
        /* 101 */
        return this.overduePrincipal;

    }


    public void setOverduePrincipal(String overduePrincipal) {
        /* 104 */
        this.overduePrincipal = overduePrincipal;

    }


    public String getOverduePrincipalPenalty() {
        /* 108 */
        return this.overduePrincipalPenalty;

    }


    public void setOverduePrincipalPenalty(String overduePrincipalPenalty) {
        /* 111 */
        this.overduePrincipalPenalty = overduePrincipalPenalty;

    }


    public String getPrincipal() {
        /* 115 */
        return this.principal;

    }


    public void setPrincipal(String principal) {
        /* 118 */
        this.principal = principal;

    }


    public String getRemarks() {
        /* 122 */
        return this.remarks;

    }


    public void setRemarks(String remarks) {
        /* 125 */
        this.remarks = remarks;

    }


    public String getTotalAmount() {
        /* 129 */
        return this.totalAmount;

    }


    public void setTotalAmount(String totalAmount) {
        /* 132 */
        this.totalAmount = totalAmount;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.RepaymentRecords
 * JD-Core Version:    0.6.0
 */