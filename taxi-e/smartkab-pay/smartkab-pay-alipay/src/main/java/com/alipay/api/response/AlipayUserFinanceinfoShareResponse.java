package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.AlipayUserCreditCard;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class AlipayUserFinanceinfoShareResponse extends AlipayResponse {
    private static final long serialVersionUID = 7131246281756273189L;

    @ApiListField("credit_card_list")
    @ApiField("alipay_user_credit_card")
    private List<AlipayUserCreditCard> creditCardList;

    public List<AlipayUserCreditCard> getCreditCardList() {
        /* 31 */
        return this.creditCardList;
    }

    public void setCreditCardList(List<AlipayUserCreditCard> creditCardList) {
        /* 28 */
        this.creditCardList = creditCardList;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayUserFinanceinfoShareResponse
 * JD-Core Version:    0.6.0
 */