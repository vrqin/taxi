package com.speedtalk.smartkab.pay.ws.domain;

public class WechatTokenReq {
    private String openid;
    private String account;

    public WechatTokenReq() {
        super();
    }

    public WechatTokenReq(String openid, String account) {
        super();
        this.openid = openid;
        this.account = account;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
