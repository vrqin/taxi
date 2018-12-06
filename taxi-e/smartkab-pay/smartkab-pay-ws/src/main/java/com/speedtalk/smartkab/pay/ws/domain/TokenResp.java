package com.speedtalk.smartkab.pay.ws.domain;

public class TokenResp {
    private String code;
    private String desc;
    private String token;

    public TokenResp() {
    }

    public TokenResp(String code, String desc, String token) {
        super();
        this.code = code;
        this.desc = desc;
        this.token = token;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
