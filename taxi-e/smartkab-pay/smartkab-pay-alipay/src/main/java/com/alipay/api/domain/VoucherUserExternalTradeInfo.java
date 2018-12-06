package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class VoucherUserExternalTradeInfo extends AlipayObject {
    private static final long serialVersionUID = 1513612468744143778L;

    @ApiField("amount")
    private String amount;

    @ApiField("consume_date")
    private String consumeDate;

    @ApiField("consume_shop_id")
    private String consumeShopId;

    @ApiField("external_trade_no")
    private String externalTradeNo;

    public String getAmount() {
        /* 41 */
        return this.amount;
    }

    public void setAmount(String amount) {
        /* 44 */
        this.amount = amount;
    }

    public String getConsumeDate() {
        /* 48 */
        return this.consumeDate;
    }

    public void setConsumeDate(String consumeDate) {
        /* 51 */
        this.consumeDate = consumeDate;
    }

    public String getConsumeShopId() {
        /* 55 */
        return this.consumeShopId;
    }

    public void setConsumeShopId(String consumeShopId) {
        /* 58 */
        this.consumeShopId = consumeShopId;
    }

    public String getExternalTradeNo() {
        /* 62 */
        return this.externalTradeNo;
    }

    public void setExternalTradeNo(String externalTradeNo) {
        /* 65 */
        this.externalTradeNo = externalTradeNo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.VoucherUserExternalTradeInfo
 * JD-Core Version:    0.6.0
 */