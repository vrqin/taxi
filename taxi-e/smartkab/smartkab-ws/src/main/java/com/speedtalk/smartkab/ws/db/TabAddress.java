package com.speedtalk.smartkab.ws.db;

import java.sql.Timestamp;


/**
 * TabAddress entity. @author MyEclipse Persistence Tools
 */

public class TabAddress implements java.io.Serializable {


    // Fields    

    private Integer iid;
    private Integer enterpriseid;
    private String opruser;
    private Timestamp createtime;
    private String province;
    private String city;
    private String street;
    private String address;
    private String citycode;
    private Double lg;
    private Double lt;
    private String match;


    // Constructors

    /**
     * default constructor
     */
    public TabAddress() {
    }

    /**
     * minimal constructor
     */
    public TabAddress(Integer enterpriseid, String opruser, Timestamp createtime) {
        this.enterpriseid = enterpriseid;
        this.opruser = opruser;
        this.createtime = createtime;
    }

    /**
     * full constructor
     */
    public TabAddress(Integer enterpriseid, String opruser, Timestamp createtime, String province, String city, String street, String address, String citycode, Double lg, Double lt, String match) {
        this.enterpriseid = enterpriseid;
        this.opruser = opruser;
        this.createtime = createtime;
        this.province = province;
        this.city = city;
        this.street = street;
        this.address = address;
        this.citycode = citycode;
        this.lg = lg;
        this.lt = lt;
        this.match = match;
    }


    // Property accessors

    public Integer getIid() {
        return this.iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public Integer getEnterpriseid() {
        return this.enterpriseid;
    }

    public void setEnterpriseid(Integer enterpriseid) {
        this.enterpriseid = enterpriseid;
    }

    public String getOpruser() {
        return this.opruser;
    }

    public void setOpruser(String opruser) {
        this.opruser = opruser;
    }

    public Timestamp getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCitycode() {
        return this.citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public Double getLg() {
        return this.lg;
    }

    public void setLg(Double lg) {
        this.lg = lg;
    }

    public Double getLt() {
        return this.lt;
    }

    public void setLt(Double lt) {
        this.lt = lt;
    }

    public String getMatch() {
        return this.match;
    }

    public void setMatch(String match) {
        this.match = match;
    }


}