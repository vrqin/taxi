package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;


public class AlipayMarketingCdpAdvertiseCreateModel extends AlipayObject {
    private static final long serialVersionUID = 6457972215689568297L;


    @ApiField("action_url")
    private String actionUrl;


    @ApiField("ad_code")
    private String adCode;


    @ApiField("ad_rules")
    private String adRules;


    @ApiField("content")
    private String content;


    @ApiField("content_type")
    private String contentType;


    @ApiField("end_time")
    private Date endTime;


    @ApiField("height")
    private String height;


    @ApiField("start_time")
    private Date startTime;


    public String getActionUrl() {
        /*  68 */
        return this.actionUrl;

    }


    public void setActionUrl(String actionUrl) {
        /*  71 */
        this.actionUrl = actionUrl;

    }


    public String getAdCode() {
        /*  75 */
        return this.adCode;

    }


    public void setAdCode(String adCode) {
        /*  78 */
        this.adCode = adCode;

    }


    public String getAdRules() {
        /*  82 */
        return this.adRules;

    }


    public void setAdRules(String adRules) {
        /*  85 */
        this.adRules = adRules;

    }


    public String getContent() {
        /*  89 */
        return this.content;

    }


    public void setContent(String content) {
        /*  92 */
        this.content = content;

    }


    public String getContentType() {
        /*  96 */
        return this.contentType;

    }


    public void setContentType(String contentType) {
        /*  99 */
        this.contentType = contentType;

    }


    public Date getEndTime() {
        /* 103 */
        return this.endTime;

    }


    public void setEndTime(Date endTime) {
        /* 106 */
        this.endTime = endTime;

    }


    public String getHeight() {
        /* 110 */
        return this.height;

    }


    public void setHeight(String height) {
        /* 113 */
        this.height = height;

    }


    public Date getStartTime() {
        /* 117 */
        return this.startTime;

    }


    public void setStartTime(Date startTime) {
        /* 120 */
        this.startTime = startTime;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayMarketingCdpAdvertiseCreateModel
 * JD-Core Version:    0.6.0
 */