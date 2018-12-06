package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;


public class EduOneCardDepositCardQueryResult extends AlipayObject {
    private static final long serialVersionUID = 3642324814629796956L;


    @ApiField("agent_code")
    private String agentCode;


    @ApiField("agent_name")
    private String agentName;


    @ApiField("balance")
    private String balance;


    @ApiField("card_name")
    private String cardName;


    @ApiField("card_no")
    private String cardNo;


    @ApiField("last_update_time")
    private Date lastUpdateTime;


    @ApiField("pound_amount")
    private String poundAmount;


    public String getAgentCode() {
        /*  61 */
        return this.agentCode;

    }


    public void setAgentCode(String agentCode) {
        /*  64 */
        this.agentCode = agentCode;

    }


    public String getAgentName() {
        /*  68 */
        return this.agentName;

    }


    public void setAgentName(String agentName) {
        /*  71 */
        this.agentName = agentName;

    }


    public String getBalance() {
        /*  75 */
        return this.balance;

    }


    public void setBalance(String balance) {
        /*  78 */
        this.balance = balance;

    }


    public String getCardName() {
        /*  82 */
        return this.cardName;

    }


    public void setCardName(String cardName) {
        /*  85 */
        this.cardName = cardName;

    }


    public String getCardNo() {
        /*  89 */
        return this.cardNo;

    }


    public void setCardNo(String cardNo) {
        /*  92 */
        this.cardNo = cardNo;

    }


    public Date getLastUpdateTime() {
        /*  96 */
        return this.lastUpdateTime;

    }


    public void setLastUpdateTime(Date lastUpdateTime) {
        /*  99 */
        this.lastUpdateTime = lastUpdateTime;

    }


    public String getPoundAmount() {
        /* 103 */
        return this.poundAmount;

    }


    public void setPoundAmount(String poundAmount) {
        /* 106 */
        this.poundAmount = poundAmount;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.EduOneCardDepositCardQueryResult
 * JD-Core Version:    0.6.0
 */