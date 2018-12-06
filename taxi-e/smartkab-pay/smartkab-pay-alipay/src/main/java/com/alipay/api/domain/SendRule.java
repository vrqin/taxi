package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class SendRule extends AlipayObject {
    private static final long serialVersionUID = 5591238541268441239L;

    @ApiField("min_cost")
    private String minCost;

    @ApiField("send_budget")
    private String sendBudget;

    @ApiField("send_num")
    private String sendNum;

    public String getMinCost() {
        /* 38 */
        return this.minCost;
    }

    public void setMinCost(String minCost) {
        /* 41 */
        this.minCost = minCost;
    }

    public String getSendBudget() {
        /* 45 */
        return this.sendBudget;
    }

    public void setSendBudget(String sendBudget) {
        /* 48 */
        this.sendBudget = sendBudget;
    }

    public String getSendNum() {
        /* 52 */
        return this.sendNum;
    }

    public void setSendNum(String sendNum) {
        /* 55 */
        this.sendNum = sendNum;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.SendRule
 * JD-Core Version:    0.6.0
 */