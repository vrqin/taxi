package com.speedtalk.smartkab.pay.ws.domain;

public class TokenReq {
    private String account;
    private String pwd;

    public TokenReq() {
        super();
    }

    public TokenReq(String account, String pwd) {
        super();
        this.account = account;
        this.pwd = pwd;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
