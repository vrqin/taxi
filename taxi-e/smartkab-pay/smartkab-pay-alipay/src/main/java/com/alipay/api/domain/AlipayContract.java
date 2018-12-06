package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;

public class AlipayContract extends AlipayObject {
    private static final long serialVersionUID = 3651711958187624682L;

    @ApiField("alipay_user_id")
    private String alipayUserId;

    @ApiField("contract_content")
    private String contractContent;

    @ApiField("end_time")
    private Date endTime;

    @ApiField("page_url")
    private String pageUrl;

    @ApiField("start_time")
    private Date startTime;

    @ApiField("subscribe")
    private Boolean subscribe;

    public String getAlipayUserId() {
        /* 55 */
        return this.alipayUserId;
    }

    public void setAlipayUserId(String alipayUserId) {
        /* 58 */
        this.alipayUserId = alipayUserId;
    }

    public String getContractContent() {
        /* 62 */
        return this.contractContent;
    }

    public void setContractContent(String contractContent) {
        /* 65 */
        this.contractContent = contractContent;
    }

    public Date getEndTime() {
        /* 69 */
        return this.endTime;
    }

    public void setEndTime(Date endTime) {
        /* 72 */
        this.endTime = endTime;
    }

    public String getPageUrl() {
        /* 76 */
        return this.pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        /* 79 */
        this.pageUrl = pageUrl;
    }

    public Date getStartTime() {
        /* 83 */
        return this.startTime;
    }

    public void setStartTime(Date startTime) {
        /* 86 */
        this.startTime = startTime;
    }

    public Boolean getSubscribe() {
        /* 90 */
        return this.subscribe;
    }

    public void setSubscribe(Boolean subscribe) {
        /* 93 */
        this.subscribe = subscribe;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayContract
 * JD-Core Version:    0.6.0
 */