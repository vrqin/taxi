package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayCommerceCityfacilitatorScardcenterScriptQueryModel extends AlipayObject {
    private static final long serialVersionUID = 5734964125995482527L;

    @ApiField("card_type")
    private String cardType;

    @ApiField("script_type")
    private String scriptType;

    public String getCardType() {
        /* 31 */
        return this.cardType;
    }

    public void setCardType(String cardType) {
        /* 34 */
        this.cardType = cardType;
    }

    public String getScriptType() {
        /* 38 */
        return this.scriptType;
    }

    public void setScriptType(String scriptType) {
        /* 41 */
        this.scriptType = scriptType;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayCommerceCityfacilitatorScardcenterScriptQueryModel
 * JD-Core Version:    0.6.0
 */