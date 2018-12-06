package com.speedtalk.smartkab.manage.ws.db;

import java.sql.Timestamp;

/**
 * TbEngineManage entity. @author MyEclipse Persistence Tools
 */
public class TbEngineManage implements java.io.Serializable {
    // Fields
    private Integer id;
    private String name;
    private String ip;
    private Integer kabcount;
    private Timestamp createtime;
    private Timestamp expiretime;
    private String remark;

    // Constructors

    /**
     * default constructor
     */
    public TbEngineManage() {
    }

    /**
     * minimal constructor
     */
    public TbEngineManage(String name, String ip, Integer kabcount, Timestamp createtime) {
        this.name = name;
        this.ip = ip;
        this.kabcount = kabcount;
        this.createtime = createtime;
    }

    /**
     * full constructor
     */
    public TbEngineManage(String name, String ip, Integer kabcount, Timestamp createtime, Timestamp expiretime, String remark) {
        this.name = name;
        this.ip = ip;
        this.kabcount = kabcount;
        this.createtime = createtime;
        this.expiretime = expiretime;
        this.remark = remark;
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

    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getKabcount() {
        return this.kabcount;
    }

    public void setKabcount(Integer kabcount) {
        this.kabcount = kabcount;
    }

    public Timestamp getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public Timestamp getExpiretime() {
        return this.expiretime;
    }

    public void setExpiretime(Timestamp expiretime) {
        this.expiretime = expiretime;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
