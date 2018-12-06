package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayOfflineMarketMcommentQueryModel extends AlipayObject {
    private static final long serialVersionUID = 5461993951768694354L;

    @ApiField("op_role")
    private String opRole;

    @ApiField("partner_id")
    private String partnerId;

    @ApiField("trade_no")
    private String tradeNo;

    public String getOpRole() {
        /* 38 */
        return this.opRole;
    }

    public void setOpRole(String opRole) {
        /* 41 */
        this.opRole = opRole;
    }

    public String getPartnerId() {
        /* 45 */
        return this.partnerId;
    }

    public void setPartnerId(String partnerId) {
        /* 48 */
        this.partnerId = partnerId;
    }

    public String getTradeNo() {
        /* 52 */
        return this.tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        /* 55 */
        this.tradeNo = tradeNo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOfflineMarketMcommentQueryModel
 * JD-Core Version:    0.6.0
 */