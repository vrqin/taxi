package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class TradeFundBill extends AlipayObject {
    private static final long serialVersionUID = 5532874119741731978L;

    @ApiField("amount")
    private String amount;

    @ApiField("fund_channel")
    private String fundChannel;

    @ApiField("real_amount")
    private String realAmount;

    public String getAmount() {
        /* 35 */
        return this.amount;
    }

    public void setAmount(String amount) {
        /* 38 */
        this.amount = amount;
    }

    public String getFundChannel() {
        /* 42 */
        return this.fundChannel;
    }

    public void setFundChannel(String fundChannel) {
        /* 45 */
        this.fundChannel = fundChannel;
    }

    public String getRealAmount() {
        /* 49 */
        return this.realAmount;
    }

    public void setRealAmount(String realAmount) {
        /* 52 */
        this.realAmount = realAmount;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.TradeFundBill
 * JD-Core Version:    0.6.0
 */