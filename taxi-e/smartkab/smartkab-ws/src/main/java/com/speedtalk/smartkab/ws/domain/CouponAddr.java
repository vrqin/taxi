package com.speedtalk.smartkab.ws.domain;

public class CouponAddr {
    private String code;
    private String desc;
    private String title;
    private String picurl;
    private String pageurl;

    public CouponAddr() {
        super();
    }

    public CouponAddr(String code, String desc, String title, String picurl, String pageurl) {
        super();
        this.code = code;
        this.desc = desc;
        this.title = title;
        this.picurl = picurl;
        this.pageurl = pageurl;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public String getPageurl() {
        return pageurl;
    }

    public void setPageurl(String pageurl) {
        this.pageurl = pageurl;
    }
}
