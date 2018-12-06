package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.MerchantCard;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMarketingCardOpenResponse extends AlipayResponse {
    private static final long serialVersionUID = 6482267567955189392L;

    @ApiField("card_info")
    private MerchantCard cardInfo;

    public MerchantCard getCardInfo() {
        /* 28 */
        return this.cardInfo;
    }

    public void setCardInfo(MerchantCard cardInfo) {
        /* 25 */
        this.cardInfo = cardInfo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMarketingCardOpenResponse
 * JD-Core Version:    0.6.0
 */