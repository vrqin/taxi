package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

public class SupportFunction extends AlipayObject {
    private static final long serialVersionUID = 7725278468732699326L;

    @ApiField("card_name")
    private String cardName;

    @ApiField("card_type")
    private String cardType;

    @ApiListField("function_type")
    @ApiField("string")
    private List<String> functionType;

    @ApiField("goto_url")
    private String gotoUrl;

    public String getCardName() {
        /* 45 */
        return this.cardName;
    }

    public void setCardName(String cardName) {
        /* 48 */
        this.cardName = cardName;
    }

    public String getCardType() {
        /* 52 */
        return this.cardType;
    }

    public void setCardType(String cardType) {
        /* 55 */
        this.cardType = cardType;
    }

    public List<String> getFunctionType() {
        /* 59 */
        return this.functionType;
    }

    public void setFunctionType(List<String> functionType) {
        /* 62 */
        this.functionType = functionType;
    }

    public String getGotoUrl() {
        /* 66 */
        return this.gotoUrl;
    }

    public void setGotoUrl(String gotoUrl) {
        /* 69 */
        this.gotoUrl = gotoUrl;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.SupportFunction
 * JD-Core Version:    0.6.0
 */