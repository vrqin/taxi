package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;


public class KoubeiMarketingAdvertisingCreateModel extends AlipayObject {
    private static final long serialVersionUID = 4214378456691392749L;


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
        /*  67 */
        return this.actionUrl;

    }


    public void setActionUrl(String actionUrl) {
        /*  70 */
        this.actionUrl = actionUrl;

    }


    public String getAdCode() {
        /*  74 */
        return this.adCode;

    }


    public void setAdCode(String adCode) {
        /*  77 */
        this.adCode = adCode;

    }


    public String getAdRules() {
        /*  81 */
        return this.adRules;

    }


    public void setAdRules(String adRules) {
        /*  84 */
        this.adRules = adRules;

    }


    public String getContent() {
        /*  88 */
        return this.content;

    }


    public void setContent(String content) {
        /*  91 */
        this.content = content;

    }


    public String getContentType() {
        /*  95 */
        return this.contentType;

    }


    public void setContentType(String contentType) {
        /*  98 */
        this.contentType = contentType;

    }


    public Date getEndTime() {
        /* 102 */
        return this.endTime;

    }


    public void setEndTime(Date endTime) {
        /* 105 */
        this.endTime = endTime;

    }


    public String getHeight() {
        /* 109 */
        return this.height;

    }


    public void setHeight(String height) {
        /* 112 */
        this.height = height;

    }


    public Date getStartTime() {
        /* 116 */
        return this.startTime;

    }


    public void setStartTime(Date startTime) {
        /* 119 */
        this.startTime = startTime;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMarketingAdvertisingCreateModel
 * JD-Core Version:    0.6.0
 */