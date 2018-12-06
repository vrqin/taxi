package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayOfflineProviderIsvShopActionQueryModel extends AlipayObject {
    private static final long serialVersionUID = 3855932768417382579L;


    @ApiField("action_detail")
    private String actionDetail;


    @ApiField("action_outer_id")
    private String actionOuterId;


    @ApiField("action_type")
    private String actionType;


    @ApiField("date_time")
    private String dateTime;


    @ApiField("entity")
    private String entity;


    @ApiField("industry")
    private String industry;


    @ApiField("outer_shop_do")
    private OuterShopDO outerShopDo;


    public String getActionDetail() {
        /*  59 */
        return this.actionDetail;

    }


    public void setActionDetail(String actionDetail) {
        /*  62 */
        this.actionDetail = actionDetail;

    }


    public String getActionOuterId() {
        /*  66 */
        return this.actionOuterId;

    }


    public void setActionOuterId(String actionOuterId) {
        /*  69 */
        this.actionOuterId = actionOuterId;

    }


    public String getActionType() {
        /*  73 */
        return this.actionType;

    }


    public void setActionType(String actionType) {
        /*  76 */
        this.actionType = actionType;

    }


    public String getDateTime() {
        /*  80 */
        return this.dateTime;

    }


    public void setDateTime(String dateTime) {
        /*  83 */
        this.dateTime = dateTime;

    }


    public String getEntity() {
        /*  87 */
        return this.entity;

    }


    public void setEntity(String entity) {
        /*  90 */
        this.entity = entity;

    }


    public String getIndustry() {
        /*  94 */
        return this.industry;

    }


    public void setIndustry(String industry) {
        /*  97 */
        this.industry = industry;

    }


    public OuterShopDO getOuterShopDo() {
        /* 101 */
        return this.outerShopDo;

    }


    public void setOuterShopDo(OuterShopDO outerShopDo) {
        /* 104 */
        this.outerShopDo = outerShopDo;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOfflineProviderIsvShopActionQueryModel
 * JD-Core Version:    0.6.0
 */