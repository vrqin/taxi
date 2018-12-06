package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

public class AlipayCommerceCityfacilitatorScardcenterDepositCancelModel extends AlipayObject {
    private static final long serialVersionUID = 5494499694273672122L;

    @ApiField("biz_info_ext")
    private String bizInfoExt;

    @ApiField("card_no")
    private String cardNo;

    @ApiField("card_type")
    private String cardType;

    @ApiField("operate_time")
    private String operateTime;

    @ApiField("out_biz_no")
    private String outBizNo;

    @ApiField("trade_no")
    private String tradeNo;

    public String getBizInfoExt() {
        /* 53 */
        return this.bizInfoExt;
    }

    public void setBizInfoExt(String bizInfoExt) {
        /* 56 */
        this.bizInfoExt = bizInfoExt;
    }

    public String getCardNo() {
        /* 60 */
        return this.cardNo;
    }

    public void setCardNo(String cardNo) {
        /* 63 */
        this.cardNo = cardNo;
    }

    public String getCardType() {
        /* 67 */
        return this.cardType;
    }

    public void setCardType(String cardType) {
        /* 70 */
        this.cardType = cardType;
    }

    public String getOperateTime() {
        /* 74 */
        return this.operateTime;
    }

    public void setOperateTime(String operateTime) {
        /* 77 */
        this.operateTime = operateTime;
    }

    public String getOutBizNo() {
        /* 81 */
        return this.outBizNo;
    }

    public void setOutBizNo(String outBizNo) {
        /* 84 */
        this.outBizNo = outBizNo;
    }

    public String getTradeNo() {
        /* 88 */
        return this.tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        /* 91 */
        this.tradeNo = tradeNo;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayCommerceCityfacilitatorScardcenterDepositCancelModel
 * JD-Core Version:    0.6.0
 */