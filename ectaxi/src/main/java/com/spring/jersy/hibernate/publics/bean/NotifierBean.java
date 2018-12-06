package com.spring.jersy.hibernate.publics.bean;

/**
 * Created by Administrator on 2016/12/28.
 */
public class NotifierBean {
    private Integer id;
    private String dirverIds;
    private String content;
    private Integer clientid;
    private String accountName;
    private String validity;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDirverIds() {
        return dirverIds;
    }

    public void setDirverIds(String dirverIds) {
        this.dirverIds = dirverIds;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getClientid() {
        return clientid;
    }

    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }
}
