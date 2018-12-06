package com.alipay.api.domain;


import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

import java.util.Date;


public class AlipayMsaasMobileCodecSharetokenCreateModel extends AlipayObject {
    private static final long serialVersionUID = 2783295964844618157L;


    @ApiField("biz_linked_id")
    private String bizLinkedId;


    @ApiField("biz_type")
    private String bizType;


    @ApiField("btn_left")
    private String btnLeft;


    @ApiField("btn_left_href")
    private String btnLeftHref;


    @ApiField("btn_right")
    private String btnRight;


    @ApiField("btn_right_href")
    private String btnRightHref;


    @ApiField("desc")
    private String desc;


    @ApiField("icon")
    private String icon;


    @ApiField("start_date")
    private Date startDate;


    @ApiField("timeout")
    private Long timeout;


    @ApiField("title")
    private String title;


    public String getBizLinkedId() {
        /*  85 */
        return this.bizLinkedId;

    }


    public void setBizLinkedId(String bizLinkedId) {
        /*  88 */
        this.bizLinkedId = bizLinkedId;

    }


    public String getBizType() {
        /*  92 */
        return this.bizType;

    }


    public void setBizType(String bizType) {
        /*  95 */
        this.bizType = bizType;

    }


    public String getBtnLeft() {
        /*  99 */
        return this.btnLeft;

    }


    public void setBtnLeft(String btnLeft) {
        /* 102 */
        this.btnLeft = btnLeft;

    }


    public String getBtnLeftHref() {
        /* 106 */
        return this.btnLeftHref;

    }


    public void setBtnLeftHref(String btnLeftHref) {
        /* 109 */
        this.btnLeftHref = btnLeftHref;

    }


    public String getBtnRight() {
        /* 113 */
        return this.btnRight;

    }


    public void setBtnRight(String btnRight) {
        /* 116 */
        this.btnRight = btnRight;

    }


    public String getBtnRightHref() {
        /* 120 */
        return this.btnRightHref;

    }


    public void setBtnRightHref(String btnRightHref) {
        /* 123 */
        this.btnRightHref = btnRightHref;

    }


    public String getDesc() {
        /* 127 */
        return this.desc;

    }


    public void setDesc(String desc) {
        /* 130 */
        this.desc = desc;

    }


    public String getIcon() {
        /* 134 */
        return this.icon;

    }


    public void setIcon(String icon) {
        /* 137 */
        this.icon = icon;

    }


    public Date getStartDate() {
        /* 141 */
        return this.startDate;

    }


    public void setStartDate(Date startDate) {
        /* 144 */
        this.startDate = startDate;

    }


    public Long getTimeout() {
        /* 148 */
        return this.timeout;

    }


    public void setTimeout(Long timeout) {
        /* 151 */
        this.timeout = timeout;

    }


    public String getTitle() {
        /* 155 */
        return this.title;

    }


    public void setTitle(String title) {
        /* 158 */
        this.title = title;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.domain.AlipayMsaasMobileCodecSharetokenCreateModel
 * JD-Core Version:    0.6.0
 */