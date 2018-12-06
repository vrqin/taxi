package com.alipay.api.response;


import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;


public class AlipayMarketingCdpAdvertiseQueryResponse extends AlipayResponse {
    private static final long serialVersionUID = 2296287413455273724L;


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


    @ApiField("status")
    private String status;


    public String getActionUrl() {
        /*  76 */
        return this.actionUrl;

    }


    public void setActionUrl(String actionUrl) {
        /*  73 */
        this.actionUrl = actionUrl;

    }


    public String getAdCode() {
        /*  83 */
        return this.adCode;

    }


    public void setAdCode(String adCode) {
        /*  80 */
        this.adCode = adCode;

    }


    public String getAdRules() {
        /*  90 */
        return this.adRules;

    }


    public void setAdRules(String adRules) {
        /*  87 */
        this.adRules = adRules;

    }


    public String getContent() {
        /*  97 */
        return this.content;

    }


    public void setContent(String content) {
        /*  94 */
        this.content = content;

    }


    public String getContentType() {
        /* 104 */
        return this.contentType;

    }


    public void setContentType(String contentType) {
        /* 101 */
        this.contentType = contentType;

    }


    public Date getEndTime() {
        /* 111 */
        return this.endTime;

    }


    public void setEndTime(Date endTime) {
        /* 108 */
        this.endTime = endTime;

    }


    public String getHeight() {
        /* 118 */
        return this.height;

    }


    public void setHeight(String height) {
        /* 115 */
        this.height = height;

    }


    public Date getStartTime() {
        /* 125 */
        return this.startTime;

    }


    public void setStartTime(Date startTime) {
        /* 122 */
        this.startTime = startTime;

    }


    public String getStatus() {
        /* 132 */
        return this.status;

    }


    public void setStatus(String status) {
        /* 129 */
        this.status = status;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.response.AlipayMarketingCdpAdvertiseQueryResponse
 * JD-Core Version:    0.6.0
 */