package com.speedtalk.smartkab.ws.domain;

public class ResetPwd {
    private String account;
    private String code;
    private String pwd;

    public ResetPwd() {
        super();
    }

    public ResetPwd(String account, String code, String pwd) {
        super();
        this.account = account;
        this.code = code;
        this.pwd = pwd;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

}
