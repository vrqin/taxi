package com.spring.jersy.hibernate.publics.bean;

/**
 * Created by Administrator on 2016/12/16.
 */
public class ResToRolBean {

    private int roleid;
    private String resourcelist;
    private String token;

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getResourcelist() {
        return resourcelist;
    }

    public void setResourcelist(String resourcelist) {
        this.resourcelist = resourcelist;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "ResToRolBean{" + "roleid=" + roleid + ", resourcelist='" + resourcelist + '\'' + ", token='" + token + '\'' + '}';
    }
}