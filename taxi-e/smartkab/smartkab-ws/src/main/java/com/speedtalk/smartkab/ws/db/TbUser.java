package com.speedtalk.smartkab.ws.db;

import java.sql.Timestamp;

/**
 * TbUser entity. @author MyEclipse Persistence Tools
 */
public class TbUser implements java.io.Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 5561652981913296169L;
    // Fields
    private Integer id;
    private String name;
    private Byte gender;
    private String phone;
    private String account;
    private String pwd;
    private Timestamp createTime;

    // Constructors

    /**
     * default constructor
     */
    public TbUser() {
    }

    /**
     * full constructor
     */
    public TbUser(String name, Byte gender, String phone, String account, String pwd, Timestamp createTime) {
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.account = account;
        this.pwd = pwd;
        this.createTime = createTime;
    }

    // Property accessors
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getGender() {
        return this.gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return this.pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
