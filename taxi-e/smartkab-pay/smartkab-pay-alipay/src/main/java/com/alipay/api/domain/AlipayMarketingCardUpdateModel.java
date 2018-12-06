package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;

public class AlipayMarketingCardUpdateModel extends AlipayObject {
    private static final long serialVersionUID = 2317754998482956867L;

    @ApiField("card_info")
    private MerchantCard cardInfo;

    @ApiField("ext_info")
    private String extInfo;

    @ApiField("occur_time")
    private Date occurTime;

    @ApiField("target_card_no")
    private String targetCardNo;

    @ApiField("target_card_no_type")
    private String targetCardNoType;

    public MerchantCard getCardInfo() {
        /* 51 */
        return this.cardInfo;
    }

    public void setCardInfo(MerchantCard cardInfo) {
        /* 54 */
        this.cardInfo = cardInfo;
    }

    public String getExtInfo() {
        /* 58 */
        return this.extInfo;
    }

    public void setExtInfo(String extInfo) {
        /* 61 */
        this.extInfo = extInfo;
    }

    public Date getOccurTime() {
        /* 65 */
        return this.occurTime;
    }

    public void setOccurTime(Date occurTime) {
        /* 68 */
        this.occurTime = occurTime;
    }

    public String getTargetCardNo() {
        /* 72 */
        return this.targetCardNo;
    }

    public void setTargetCardNo(String targetCardNo) {
        /* 75 */
        this.targetCardNo = targetCardNo;
    }

    public String getTargetCardNoType() {
        /* 79 */
        return this.targetCardNoType;
    }

    public void setTargetCardNoType(String targetCardNoType) {
        /* 82 */
        this.targetCardNoType = targetCardNoType;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayMarketingCardUpdateModel
 * JD-Core Version:    0.6.0
 */