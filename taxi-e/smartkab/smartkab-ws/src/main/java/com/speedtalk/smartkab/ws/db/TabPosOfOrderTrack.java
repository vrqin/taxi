package com.speedtalk.smartkab.ws.db;

import java.sql.Timestamp;

/**
 * TabPosOfOrderTrack entity. @author MyEclipse Persistence Tools
 */
public class TabPosOfOrderTrack implements java.io.Serializable {
    // Fields
    private Long id;
    private String orderid;
    private String oper;
    private Byte opertype;
    private Double lg;
    private Double lt;
    private Timestamp gpstime;
    private Timestamp time;

    // Constructors

    /**
     * default constructor
     */
    public TabPosOfOrderTrack() {
    }

    /**
     * full constructor
     */
    public TabPosOfOrderTrack(String orderid, String oper, Byte opertype, Double lg, Double lt, Timestamp gpstime, Timestamp time) {
        this.orderid = orderid;
        this.oper = oper;
        this.opertype = opertype;
        this.lg = lg;
        this.lt = lt;
        this.gpstime = gpstime;
        this.time = time;
    }

    // Property accessors
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderid() {
        return this.orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getOper() {
        return this.oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public Byte getOpertype() {
        return this.opertype;
    }

    public void setOpertype(Byte opertype) {
        this.opertype = opertype;
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

    public Timestamp getGpstime() {
        return gpstime;
    }

    public void setGpstime(Timestamp gpstime) {
        this.gpstime = gpstime;
    }

    public Timestamp getTime() {
        return this.time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
