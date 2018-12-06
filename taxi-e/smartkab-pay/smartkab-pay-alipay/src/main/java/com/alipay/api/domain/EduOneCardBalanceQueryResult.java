package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;

public class EduOneCardBalanceQueryResult extends AlipayObject {
    private static final long serialVersionUID = 4611751883961897849L;

    @ApiField("agent_code")
    private String agentCode;

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
        /* 55 */
        return this.agentCode;
    }

    public void setAgentCode(String agentCode) {
        /* 58 */
        this.agentCode = agentCode;
    }

    public String getBalance() {
        /* 62 */
        return this.balance;
    }

    public void setBalance(String balance) {
        /* 65 */
        this.balance = balance;
    }

    public String getCardName() {
        /* 69 */
        return this.cardName;
    }

    public void setCardName(String cardName) {
        /* 72 */
        this.cardName = cardName;
    }

    public String getCardNo() {
        /* 76 */
        return this.cardNo;
    }

    public void setCardNo(String cardNo) {
        /* 79 */
        this.cardNo = cardNo;
    }

    public Date getLastUpdateTime() {
        /* 83 */
        return this.lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        /* 86 */
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getPoundAmount() {
        /* 90 */
        return this.poundAmount;
    }

    public void setPoundAmount(String poundAmount) {
        /* 93 */
        this.poundAmount = poundAmount;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.EduOneCardBalanceQueryResult
 * JD-Core Version:    0.6.0
 */