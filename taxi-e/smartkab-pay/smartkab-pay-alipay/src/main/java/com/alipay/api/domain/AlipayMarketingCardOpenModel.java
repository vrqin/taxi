package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMarketingCardOpenModel extends AlipayObject {
    private static final long serialVersionUID = 2668836796789332337L;

    @ApiField("card_ext_info")
    private MerchantCard cardExtInfo;

    @ApiField("card_template_id")
    private String cardTemplateId;

    @ApiField("card_user_info")
    private CardUserInfo cardUserInfo;

    @ApiField("member_ext_info")
    private MerchantMenber memberExtInfo;

    @ApiField("out_serial_no")
    private String outSerialNo;

    public MerchantCard getCardExtInfo() {
        /* 47 */
        return this.cardExtInfo;
    }

    public void setCardExtInfo(MerchantCard cardExtInfo) {
        /* 50 */
        this.cardExtInfo = cardExtInfo;
    }

    public String getCardTemplateId() {
        /* 54 */
        return this.cardTemplateId;
    }

    public void setCardTemplateId(String cardTemplateId) {
        /* 57 */
        this.cardTemplateId = cardTemplateId;
    }

    public CardUserInfo getCardUserInfo() {
        /* 61 */
        return this.cardUserInfo;
    }

    public void setCardUserInfo(CardUserInfo cardUserInfo) {
        /* 64 */
        this.cardUserInfo = cardUserInfo;
    }

    public MerchantMenber getMemberExtInfo() {
        /* 68 */
        return this.memberExtInfo;
    }

    public void setMemberExtInfo(MerchantMenber memberExtInfo) {
        /* 71 */
        this.memberExtInfo = memberExtInfo;
    }

    public String getOutSerialNo() {
        /* 75 */
        return this.outSerialNo;
    }

    public void setOutSerialNo(String outSerialNo) {
        /* 78 */
        this.outSerialNo = outSerialNo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayMarketingCardOpenModel
 * JD-Core Version:    0.6.0
 */