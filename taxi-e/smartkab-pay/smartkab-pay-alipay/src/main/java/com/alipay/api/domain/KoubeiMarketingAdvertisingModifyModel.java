package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;

public class KoubeiMarketingAdvertisingModifyModel extends AlipayObject {
    private static final long serialVersionUID = 1675623117221328646L;

    @ApiField("action_url")
    private String actionUrl;

    @ApiField("ad_id")
    private String adId;

    @ApiField("content")
    private String content;

    @ApiField("end_time")
    private Date endTime;

    @ApiField("height")
    private String height;

    @ApiField("start_time")
    private Date startTime;

    public String getActionUrl() {
        /* 55 */
        return this.actionUrl;
    }

    public void setActionUrl(String actionUrl) {
        /* 58 */
        this.actionUrl = actionUrl;
    }

    public String getAdId() {
        /* 62 */
        return this.adId;
    }

    public void setAdId(String adId) {
        /* 65 */
        this.adId = adId;
    }

    public String getContent() {
        /* 69 */
        return this.content;
    }

    public void setContent(String content) {
        /* 72 */
        this.content = content;
    }

    public Date getEndTime() {
        /* 76 */
        return this.endTime;
    }

    public void setEndTime(Date endTime) {
        /* 79 */
        this.endTime = endTime;
    }

    public String getHeight() {
        /* 83 */
        return this.height;
    }

    public void setHeight(String height) {
        /* 86 */
        this.height = height;
    }

    public Date getStartTime() {
        /* 90 */
        return this.startTime;
    }

    public void setStartTime(Date startTime) {
        /* 93 */
        this.startTime = startTime;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.KoubeiMarketingAdvertisingModifyModel
 * JD-Core Version:    0.6.0
 */