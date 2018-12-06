package com.speedtalk.smartkab.score.ws.db;

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
    private Timestamp curtime;
    private Double lastlg;
    private Double lastlt;
    private Timestamp gpstime;
    private Byte isonline;
    private Byte isstop;
    private String iccard;
    private String level;
    private String tradeCer;
    private String serialNum;
    private String company;
    private String driveLicense;
    private String iconUrl;

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
    public TabDriver(String account, String pwd, String msid, String kabnum, String name, Byte sex, String phone, Timestamp createtime, Double lastlg, Double lastlt, Timestamp gpstime, Byte isonline, Byte isstop, String iccard, String level, String tradeCer, String serialNum, String company, String driveLicense, String iconUrl) {
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
        this.isonline = isonline;
        this.isstop = 0;
        this.iccard = iccard;
        this.level = level;
        this.tradeCer = tradeCer;
        this.serialNum = serialNum;
        this.company = company;
        this.driveLicense = driveLicense;
        this.iconUrl = iconUrl;
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

    public Timestamp getCurtime() {
        return curtime;
    }

    public void setCurtime(Timestamp curtime) {
        this.curtime = curtime;
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

    public Byte getIsonline() {
        return isonline;
    }

    public void setIsonline(Byte isonline) {
        this.isonline = isonline;
    }

    public Byte getIsstop() {
        return isstop;
    }

    public void setIsstop(Byte isstop) {
        this.isstop = isstop;
    }

    public String getIccard() {
        return iccard;
    }

    public void setIccard(String iccard) {
        this.iccard = iccard;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTradeCer() {
        return tradeCer;
    }

    public void setTradeCer(String tradeCer) {
        this.tradeCer = tradeCer;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDriveLicense() {
        return driveLicense;
    }

    public void setDriveLicense(String driveLicense) {
        this.driveLicense = driveLicense;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }
}
