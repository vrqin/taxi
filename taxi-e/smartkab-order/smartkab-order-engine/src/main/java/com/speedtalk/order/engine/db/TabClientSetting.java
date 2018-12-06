package com.speedtalk.order.engine.db;

/**
 * TabClientSetting entity. @author MyEclipse Persistence Tools
 */
public class TabClientSetting implements java.io.Serializable {
    // Fields
    private Integer clientid;
    private Integer messagenum;
    private Integer orderovertime;
    private Byte droporder;
    private Byte waitminute;
    private String smsid;
    private String smskey;
    private String smscancelid;
    private Integer distance;
    private String areaname;

    // Constructors

    /**
     * default constructor
     */
    public TabClientSetting() {
    }

    /**
     * minimal constructor
     */
    public TabClientSetting(Integer clientid) {
        this.clientid = clientid;
    }

    /**
     * full constructor
     */
    public TabClientSetting(Integer clientid, Integer messagenum, Integer orderovertime, Byte droporder, Byte waitminute, String smsid, String smskey, String smscancelid, Integer distance, String areaname) {
        this.clientid = clientid;
        this.messagenum = messagenum;
        this.orderovertime = orderovertime;
        this.droporder = droporder;
        this.waitminute = waitminute;
        this.smsid = smsid;
        this.smskey = smskey;
        this.smscancelid = smscancelid;
        this.distance = distance;
        this.areaname = areaname;
    }

    // Property accessors
    public Integer getClientid() {
        return this.clientid;
    }

    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }

    public Integer getMessagenum() {
        return this.messagenum;
    }

    public void setMessagenum(Integer messagenum) {
        this.messagenum = messagenum;
    }

    public Integer getOrderovertime() {
        return this.orderovertime;
    }

    public void setOrderovertime(Integer orderovertime) {
        this.orderovertime = orderovertime;
    }

    public Byte getDroporder() {
        return droporder;
    }

    public void setDroporder(Byte droporder) {
        this.droporder = droporder;
    }

    public Byte getWaitminute() {
        return waitminute;
    }

    public void setWaitminute(Byte waitminute) {
        this.waitminute = waitminute;
    }

    public String getSmsid() {
        return smsid;
    }

    public void setSmsid(String smsid) {
        this.smsid = smsid;
    }

    public String getSmskey() {
        return smskey;
    }

    public void setSmskey(String smskey) {
        this.smskey = smskey;
    }

    public String getSmscancelid() {
        return smscancelid;
    }

    public void setSmscancelid(String smscancelid) {
        this.smscancelid = smscancelid;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    @Override
    public String toString() {
        return "TabClientSetting [clientid=" + clientid + ", messagenum=" + messagenum + ", orderovertime=" + orderovertime + ", droporder=" + droporder + ", waitminute=" + waitminute + ", smsid=" + smsid + ", smskey=" + smskey + ", smscancelid=" + smscancelid + ", distance=" + distance + ", areaname=" + areaname + "]";
    }

}