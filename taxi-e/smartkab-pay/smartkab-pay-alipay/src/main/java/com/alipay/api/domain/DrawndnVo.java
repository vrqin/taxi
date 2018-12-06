package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;


public class DrawndnVo extends AlipayObject {
    private static final long serialVersionUID = 2389628549284275628L;


    @ApiField("actual_collected_interest")
    private String actualCollectedInterest;


    @ApiField("balance")
    private String balance;


    @ApiField("collected_principal_and_interest")
    private String collectedPrincipalAndInterest;


    @ApiField("credit_no")
    private String creditNo;


    @ApiField("drawndn_date")
    private Date drawndnDate;


    @ApiField("drawndn_no")
    private String drawndnNo;


    @ApiField("due_date")
    private Date dueDate;


    @ApiField("five_tier_classification")
    private String fiveTierClassification;


    @ApiField("interest")
    private String interest;


    @ApiField("interest_rate")
    private String interestRate;


    @ApiField("lending_amount")
    private String lendingAmount;


    @ApiField("overduce_terms")
    private Long overduceTerms;


    @ApiField("overdue_days")
    private Long overdueDays;


    @ApiField("overdue_interest")
    private String overdueInterest;


    @ApiField("overdue_interest_penalty")
    private String overdueInterestPenalty;


    @ApiField("overdue_principal")
    private String overduePrincipal;


    @ApiField("overdue_principal_penalty")
    private String overduePrincipalPenalty;


    @ApiField("status")
    private String status;


    public String getActualCollectedInterest() {
        /* 127 */
        return this.actualCollectedInterest;

    }


    public void setActualCollectedInterest(String actualCollectedInterest) {
        /* 130 */
        this.actualCollectedInterest = actualCollectedInterest;

    }


    public String getBalance() {
        /* 134 */
        return this.balance;

    }


    public void setBalance(String balance) {
        /* 137 */
        this.balance = balance;

    }


    public String getCollectedPrincipalAndInterest() {
        /* 141 */
        return this.collectedPrincipalAndInterest;

    }


    public void setCollectedPrincipalAndInterest(String collectedPrincipalAndInterest) {
        /* 144 */
        this.collectedPrincipalAndInterest = collectedPrincipalAndInterest;

    }


    public String getCreditNo() {
        /* 148 */
        return this.creditNo;

    }


    public void setCreditNo(String creditNo) {
        /* 151 */
        this.creditNo = creditNo;

    }


    public Date getDrawndnDate() {
        /* 155 */
        return this.drawndnDate;

    }


    public void setDrawndnDate(Date drawndnDate) {
        /* 158 */
        this.drawndnDate = drawndnDate;

    }


    public String getDrawndnNo() {
        /* 162 */
        return this.drawndnNo;

    }


    public void setDrawndnNo(String drawndnNo) {
        /* 165 */
        this.drawndnNo = drawndnNo;

    }


    public Date getDueDate() {
        /* 169 */
        return this.dueDate;

    }


    public void setDueDate(Date dueDate) {
        /* 172 */
        this.dueDate = dueDate;

    }


    public String getFiveTierClassification() {
        /* 176 */
        return this.fiveTierClassification;

    }


    public void setFiveTierClassification(String fiveTierClassification) {
        /* 179 */
        this.fiveTierClassification = fiveTierClassification;

    }


    public String getInterest() {
        /* 183 */
        return this.interest;

    }


    public void setInterest(String interest) {
        /* 186 */
        this.interest = interest;

    }


    public String getInterestRate() {
        /* 190 */
        return this.interestRate;

    }


    public void setInterestRate(String interestRate) {
        /* 193 */
        this.interestRate = interestRate;

    }


    public String getLendingAmount() {
        /* 197 */
        return this.lendingAmount;

    }


    public void setLendingAmount(String lendingAmount) {
        /* 200 */
        this.lendingAmount = lendingAmount;

    }


    public Long getOverduceTerms() {
        /* 204 */
        return this.overduceTerms;

    }


    public void setOverduceTerms(Long overduceTerms) {
        /* 207 */
        this.overduceTerms = overduceTerms;

    }


    public Long getOverdueDays() {
        /* 211 */
        return this.overdueDays;

    }


    public void setOverdueDays(Long overdueDays) {
        /* 214 */
        this.overdueDays = overdueDays;

    }


    public String getOverdueInterest() {
        /* 218 */
        return this.overdueInterest;

    }


    public void setOverdueInterest(String overdueInterest) {
        /* 221 */
        this.overdueInterest = overdueInterest;

    }


    public String getOverdueInterestPenalty() {
        /* 225 */
        return this.overdueInterestPenalty;

    }


    public void setOverdueInterestPenalty(String overdueInterestPenalty) {
        /* 228 */
        this.overdueInterestPenalty = overdueInterestPenalty;

    }


    public String getOverduePrincipal() {
        /* 232 */
        return this.overduePrincipal;

    }


    public void setOverduePrincipal(String overduePrincipal) {
        /* 235 */
        this.overduePrincipal = overduePrincipal;

    }


    public String getOverduePrincipalPenalty() {
        /* 239 */
        return this.overduePrincipalPenalty;

    }


    public void setOverduePrincipalPenalty(String overduePrincipalPenalty) {
        /* 242 */
        this.overduePrincipalPenalty = overduePrincipalPenalty;

    }


    public String getStatus() {
        /* 246 */
        return this.status;

    }


    public void setStatus(String status) {
        /* 249 */
        this.status = status;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.DrawndnVo
 * JD-Core Version:    0.6.0
 */