package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;


public class PaymentSchedule extends AlipayObject {
    private static final long serialVersionUID = 6289313239897544433L;


    @ApiField("date")
    private Date date;


    @ApiField("repaid_interest_total")
    private String repaidInterestTotal;


    @ApiField("repaid_penalty_total")
    private String repaidPenaltyTotal;


    @ApiField("repaid_principal_total")
    private String repaidPrincipalTotal;


    @ApiField("start_date")
    private Date startDate;


    @ApiField("term")
    private Long term;


    @ApiField("unpaid_interest_total")
    private String unpaidInterestTotal;


    @ApiField("unpaid_penalty_total")
    private String unpaidPenaltyTotal;


    @ApiField("unpaid_principal_total")
    private String unpaidPrincipalTotal;


    public Date getDate() {
        /*  73 */
        return this.date;

    }


    public void setDate(Date date) {
        /*  76 */
        this.date = date;

    }


    public String getRepaidInterestTotal() {
        /*  80 */
        return this.repaidInterestTotal;

    }


    public void setRepaidInterestTotal(String repaidInterestTotal) {
        /*  83 */
        this.repaidInterestTotal = repaidInterestTotal;

    }


    public String getRepaidPenaltyTotal() {
        /*  87 */
        return this.repaidPenaltyTotal;

    }


    public void setRepaidPenaltyTotal(String repaidPenaltyTotal) {
        /*  90 */
        this.repaidPenaltyTotal = repaidPenaltyTotal;

    }


    public String getRepaidPrincipalTotal() {
        /*  94 */
        return this.repaidPrincipalTotal;

    }


    public void setRepaidPrincipalTotal(String repaidPrincipalTotal) {
        /*  97 */
        this.repaidPrincipalTotal = repaidPrincipalTotal;

    }


    public Date getStartDate() {
        /* 101 */
        return this.startDate;

    }


    public void setStartDate(Date startDate) {
        /* 104 */
        this.startDate = startDate;

    }


    public Long getTerm() {
        /* 108 */
        return this.term;

    }


    public void setTerm(Long term) {
        /* 111 */
        this.term = term;

    }


    public String getUnpaidInterestTotal() {
        /* 115 */
        return this.unpaidInterestTotal;

    }


    public void setUnpaidInterestTotal(String unpaidInterestTotal) {
        /* 118 */
        this.unpaidInterestTotal = unpaidInterestTotal;

    }


    public String getUnpaidPenaltyTotal() {
        /* 122 */
        return this.unpaidPenaltyTotal;

    }


    public void setUnpaidPenaltyTotal(String unpaidPenaltyTotal) {
        /* 125 */
        this.unpaidPenaltyTotal = unpaidPenaltyTotal;

    }


    public String getUnpaidPrincipalTotal() {
        /* 129 */
        return this.unpaidPrincipalTotal;

    }


    public void setUnpaidPrincipalTotal(String unpaidPrincipalTotal) {
        /* 132 */
        this.unpaidPrincipalTotal = unpaidPrincipalTotal;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.PaymentSchedule
 * JD-Core Version:    0.6.0
 */