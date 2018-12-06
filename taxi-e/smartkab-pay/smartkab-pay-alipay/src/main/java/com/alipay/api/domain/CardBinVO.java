package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class CardBinVO extends AlipayObject {
    private static final long serialVersionUID = 1184182319938395894L;


    @ApiField("card_alias")
    private String cardAlias;


    @ApiField("card_bin_value")
    private String cardBinValue;


    @ApiField("card_type_vo")
    private CardTypeVO cardTypeVo;


    @ApiField("domain_vo")
    private CardDomainVO domainVo;


    @ApiField("inst_id")
    private String instId;


    @ApiField("inst_len")
    private String instLen;


    @ApiField("memo")
    private String memo;


    @ApiField("operator")
    private String operator;


    @ApiField("version")
    private String version;


    public String getCardAlias() {
        /*  71 */
        return this.cardAlias;

    }


    public void setCardAlias(String cardAlias) {
        /*  74 */
        this.cardAlias = cardAlias;

    }


    public String getCardBinValue() {
        /*  78 */
        return this.cardBinValue;

    }


    public void setCardBinValue(String cardBinValue) {
        /*  81 */
        this.cardBinValue = cardBinValue;

    }


    public CardTypeVO getCardTypeVo() {
        /*  85 */
        return this.cardTypeVo;

    }


    public void setCardTypeVo(CardTypeVO cardTypeVo) {
        /*  88 */
        this.cardTypeVo = cardTypeVo;

    }


    public CardDomainVO getDomainVo() {
        /*  92 */
        return this.domainVo;

    }


    public void setDomainVo(CardDomainVO domainVo) {
        /*  95 */
        this.domainVo = domainVo;

    }


    public String getInstId() {
        /*  99 */
        return this.instId;

    }


    public void setInstId(String instId) {
        /* 102 */
        this.instId = instId;

    }


    public String getInstLen() {
        /* 106 */
        return this.instLen;

    }


    public void setInstLen(String instLen) {
        /* 109 */
        this.instLen = instLen;

    }


    public String getMemo() {
        /* 113 */
        return this.memo;

    }


    public void setMemo(String memo) {
        /* 116 */
        this.memo = memo;

    }


    public String getOperator() {
        /* 120 */
        return this.operator;

    }


    public void setOperator(String operator) {
        /* 123 */
        this.operator = operator;

    }


    public String getVersion() {
        /* 127 */
        return this.version;

    }


    public void setVersion(String version) {
        /* 130 */
        this.version = version;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.CardBinVO
 * JD-Core Version:    0.6.0
 */