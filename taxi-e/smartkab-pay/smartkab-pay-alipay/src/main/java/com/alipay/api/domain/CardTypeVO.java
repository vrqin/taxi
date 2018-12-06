package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class CardTypeVO extends AlipayObject {
    private static final long serialVersionUID = 2747713646547916161L;

    @ApiField("card_type")
    private String cardType;

    @ApiField("description")
    private String description;

    public String getCardType() {
        /* 37 */
        return this.cardType;
    }

    public void setCardType(String cardType) {
        /* 40 */
        this.cardType = cardType;
    }

    public String getDescription() {
        /* 44 */
        return this.description;
    }

    public void setDescription(String description) {
        /* 47 */
        this.description = description;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.CardTypeVO
 * JD-Core Version:    0.6.0
 */