package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayAccountExrateRatequeryModel extends AlipayObject {
    private static final long serialVersionUID = 4132714812123672823L;

    @ApiField("currency_pair")
    private String currencyPair;

    public String getCurrencyPair() {
        /* 23 */
        return this.currencyPair;
    }

    public void setCurrencyPair(String currencyPair) {
        /* 26 */
        this.currencyPair = currencyPair;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayAccountExrateRatequeryModel
 * JD-Core Version:    0.6.0
 */