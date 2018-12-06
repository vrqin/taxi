package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayCommerceCityfacilitatorScardcenterDepositConfirmModel extends AlipayObject {
    private static final long serialVersionUID = 3363871464851515431L;


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


    @ApiField("request_id")
    private String requestId;


    @ApiField("trade_no")
    private String tradeNo;


    public String getBizInfoExt() {
        /*  59 */
        return this.bizInfoExt;

    }


    public void setBizInfoExt(String bizInfoExt) {
        /*  62 */
        this.bizInfoExt = bizInfoExt;

    }


    public String getCardNo() {
        /*  66 */
        return this.cardNo;

    }


    public void setCardNo(String cardNo) {
        /*  69 */
        this.cardNo = cardNo;

    }


    public String getCardType() {
        /*  73 */
        return this.cardType;

    }


    public void setCardType(String cardType) {
        /*  76 */
        this.cardType = cardType;

    }


    public String getOperateTime() {
        /*  80 */
        return this.operateTime;

    }


    public void setOperateTime(String operateTime) {
        /*  83 */
        this.operateTime = operateTime;

    }


    public String getOutBizNo() {
        /*  87 */
        return this.outBizNo;

    }


    public void setOutBizNo(String outBizNo) {
        /*  90 */
        this.outBizNo = outBizNo;

    }


    public String getRequestId() {
        /*  94 */
        return this.requestId;

    }


    public void setRequestId(String requestId) {
        /*  97 */
        this.requestId = requestId;

    }


    public String getTradeNo() {
        /* 101 */
        return this.tradeNo;

    }


    public void setTradeNo(String tradeNo) {
        /* 104 */
        this.tradeNo = tradeNo;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayCommerceCityfacilitatorScardcenterDepositConfirmModel
 * JD-Core Version:    0.6.0
 */