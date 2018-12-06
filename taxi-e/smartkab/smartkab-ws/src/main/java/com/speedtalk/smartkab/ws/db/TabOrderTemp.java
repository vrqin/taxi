package com.speedtalk.smartkab.ws.db;

import java.sql.Timestamp;

/**
 * TabOrderTemp entity. @author MyEclipse Persistence Tools
 */
public class TabOrderTemp implements java.io.Serializable {
    // Fields
    private String orderid;
    private Byte status;
    private Timestamp time;

    // Constructors

    /**
     * default constructor
     */
    public TabOrderTemp() {
    }

    /**
     * full constructor
     */
    public TabOrderTemp(String orderid, Byte status, Timestamp time) {
        this.orderid = orderid;
        this.status = status;
        this.time = time;
    }

    // Property accessors
    public String getOrderid() {
        return this.orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Byte getStatus() {
        return this.status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Timestamp getTime() {
        return this.time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
