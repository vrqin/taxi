package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class RechargeBill extends AlipayObject {
    private static final long serialVersionUID = 3416483538642478511L;

    @ApiField("amount")
    private String amount;

    @ApiField("deposit_time")
    private String depositTime;

    @ApiField("status")
    private String status;

    @ApiField("trade_no")
    private String tradeNo;

    public String getAmount() {
        /* 43 */
        return this.amount;
    }

    public void setAmount(String amount) {
        /* 46 */
        this.amount = amount;
    }

    public String getDepositTime() {
        /* 50 */
        return this.depositTime;
    }

    public void setDepositTime(String depositTime) {
        /* 53 */
        this.depositTime = depositTime;
    }

    public String getStatus() {
        /* 57 */
        return this.status;
    }

    public void setStatus(String status) {
        /* 60 */
        this.status = status;
    }

    public String getTradeNo() {
        /* 64 */
        return this.tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        /* 67 */
        this.tradeNo = tradeNo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.RechargeBill
 * JD-Core Version:    0.6.0
 */