package com.speedtalk.smartkab.ws.db;

import java.sql.Timestamp;

/**
 * TabDriver entity. @author MyEclipse Persistence Tools
 */
public class TabDriver implements java.io.Serializable {
    // Fields
    private Integer id;
    private String account;
    private String pwd;
    private String msid;
    private String kabnum;
    private String name;
    private Byte sex;
    private String phone;
    private Timestamp createtime;
    private Double lastlg;
    private Double lastlt;
    private Timestamp gpstime;
    private String company;
    // Constructors

    /**
     * default constructor
     */
    public TabDriver() {
    }

    /**
     * minimal constructor
     */
    public TabDriver(String kabnum, String name, Byte sex, Timestamp createtime) {
        this.kabnum = kabnum;
        this.name = name;
        this.sex = sex;
        this.createtime = createtime;
    }

    /**
     * full constructor
     */
    public TabDriver(String account, String pwd, String msid, String kabnum, String name, Byte sex, String phone, Timestamp createtime, Double lastlg, Double lastlt, Timestamp gpstime, String company) {
        this.account = account;
        this.pwd = pwd;
        this.msid = msid;
        this.kabnum = kabnum;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.createtime = createtime;
        this.lastlg = lastlg;
        this.lastlt = lastlt;
        this.gpstime = gpstime;
        this.company = company;
    }

    // Property accessors
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getMsid() {
        return this.msid;
    }

    public void setMsid(String msid) {
        this.msid = msid;
    }

    public String getKabnum() {
        return this.kabnum;
    }

    public void setKabnum(String kabnum) {
        this.kabnum = kabnum;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getSex() {
        return this.sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Timestamp getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public Double getLastlg() {
        return this.lastlg;
    }

    public void setLastlg(Double lastlg) {
        this.lastlg = lastlg;
    }

    public Double getLastlt() {
        return this.lastlt;
    }

    public void setLastlt(Double lastlt) {
        this.lastlt = lastlt;
    }

    public Timestamp getGpstime() {
        return this.gpstime;
    }

    public void setGpstime(Timestamp gpstime) {
        this.gpstime = gpstime;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
