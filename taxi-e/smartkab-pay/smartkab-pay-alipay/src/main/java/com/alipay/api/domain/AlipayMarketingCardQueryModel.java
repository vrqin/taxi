package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayMarketingCardQueryModel extends AlipayObject {
    private static final long serialVersionUID = 6265166424476512327L;

    @ApiField("card_user_info")
    private CardUserInfo cardUserInfo;

    @ApiField("ext_info")
    private String extInfo;

    @ApiField("target_card_no")
    private String targetCardNo;

    @ApiField("target_card_no_type")
    private String targetCardNoType;

    public CardUserInfo getCardUserInfo() {
        /* 46 */
        return this.cardUserInfo;
    }

    public void setCardUserInfo(CardUserInfo cardUserInfo) {
        /* 49 */
        this.cardUserInfo = cardUserInfo;
    }

    public String getExtInfo() {
        /* 53 */
        return this.extInfo;
    }

    public void setExtInfo(String extInfo) {
        /* 56 */
        this.extInfo = extInfo;
    }

    public String getTargetCardNo() {
        /* 60 */
        return this.targetCardNo;
    }

    public void setTargetCardNo(String targetCardNo) {
        /* 63 */
        this.targetCardNo = targetCardNo;
    }

    public String getTargetCardNoType() {
        /* 67 */
        return this.targetCardNoType;
    }

    public void setTargetCardNoType(String targetCardNoType) {
        /* 70 */
        this.targetCardNoType = targetCardNoType;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayMarketingCardQueryModel
 * JD-Core Version:    0.6.0
 */