package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayCommerceTransportOfflinepayTradeSettleModel extends AlipayObject {
    private static final long serialVersionUID = 3845573968795214288L;

    @ApiListField("trade_list")
    @ApiField("alipay_offline_trade")
    private List<AlipayOfflineTrade> tradeList;

    public List<AlipayOfflineTrade> getTradeList() {
        /* 27 */
        return this.tradeList;
    }

    public void setTradeList(List<AlipayOfflineTrade> tradeList) {
        /* 30 */
        this.tradeList = tradeList;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayCommerceTransportOfflinepayTradeSettleModel
 * JD-Core Version:    0.6.0
 */