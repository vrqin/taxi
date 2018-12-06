package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;


public class AlipayOfflineProviderOpenUseractionModel extends AlipayObject {
    private static final long serialVersionUID = 5695712355241167816L;


    @ApiField("action_detail")
    private String actionDetail;


    @ApiField("action_outer_id")
    private String actionOuterId;


    @ApiField("action_type")
    private String actionType;


    @ApiField("alipay_app_id")
    private String alipayAppId;


    @ApiField("date_time")
    private String dateTime;


    @ApiField("entity")
    private String entity;


    @ApiField("industry")
    private String industry;


    @ApiField("mobile")
    private String mobile;


    @ApiField("outer_shop_do")
    private OuterShopDO outerShopDo;


    @ApiField("platform_user_id")
    private String platformUserId;


    @ApiField("source")
    private String source;


    @ApiField("user_id")
    private String userId;


    public String getActionDetail() {
        /*  89 */
        return this.actionDetail;

    }


    public void setActionDetail(String actionDetail) {
        /*  92 */
        this.actionDetail = actionDetail;

    }


    public String getActionOuterId() {
        /*  96 */
        return this.actionOuterId;

    }


    public void setActionOuterId(String actionOuterId) {
        /*  99 */
        this.actionOuterId = actionOuterId;

    }


    public String getActionType() {
        /* 103 */
        return this.actionType;

    }


    public void setActionType(String actionType) {
        /* 106 */
        this.actionType = actionType;

    }


    public String getAlipayAppId() {
        /* 110 */
        return this.alipayAppId;

    }


    public void setAlipayAppId(String alipayAppId) {
        /* 113 */
        this.alipayAppId = alipayAppId;

    }


    public String getDateTime() {
        /* 117 */
        return this.dateTime;

    }


    public void setDateTime(String dateTime) {
        /* 120 */
        this.dateTime = dateTime;

    }


    public String getEntity() {
        /* 124 */
        return this.entity;

    }


    public void setEntity(String entity) {
        /* 127 */
        this.entity = entity;

    }


    public String getIndustry() {
        /* 131 */
        return this.industry;

    }


    public void setIndustry(String industry) {
        /* 134 */
        this.industry = industry;

    }


    public String getMobile() {
        /* 138 */
        return this.mobile;

    }


    public void setMobile(String mobile) {
        /* 141 */
        this.mobile = mobile;

    }


    public OuterShopDO getOuterShopDo() {
        /* 145 */
        return this.outerShopDo;

    }


    public void setOuterShopDo(OuterShopDO outerShopDo) {
        /* 148 */
        this.outerShopDo = outerShopDo;

    }


    public String getPlatformUserId() {
        /* 152 */
        return this.platformUserId;

    }


    public void setPlatformUserId(String platformUserId) {
        /* 155 */
        this.platformUserId = platformUserId;

    }


    public String getSource() {
        /* 159 */
        return this.source;

    }


    public void setSource(String source) {
        /* 162 */
        this.source = source;

    }


    public String getUserId() {
        /* 166 */
        return this.userId;

    }


    public void setUserId(String userId) {
        /* 169 */
        this.userId = userId;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayOfflineProviderOpenUseractionModel
 * JD-Core Version:    0.6.0
 */