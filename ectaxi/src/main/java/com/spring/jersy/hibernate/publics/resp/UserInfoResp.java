package com.spring.jersy.hibernate.publics.resp;

/**
 * Created by Administrator on 2016/9/11.
 */
public class UserInfoResp extends BaseResp {
    private String token;

    private String account;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
