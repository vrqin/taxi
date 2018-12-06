package com.speedtalk.smartkab.ws.db;

import java.sql.Timestamp;

/**
 * TabOrderTrack entity. @author MyEclipse Persistence Tools
 */
public class TabOrderTrack implements java.io.Serializable {
    // Fields
    private Long id;
    private String oper;
    private String orderid;
    private Byte nodeid;
    private Timestamp time;
    private String remark;

    // Constructors

    /**
     * default constructor
     */
    public TabOrderTrack() {
    }

    /**
     * minimal constructor
     */
    public TabOrderTrack(String oper, String orderid, Byte nodeid, Timestamp time) {
        this.oper = oper;
        this.orderid = orderid;
        this.nodeid = nodeid;
        this.time = time;
    }

    /**
     * full constructor
     */
    public TabOrderTrack(String oper, String orderid, Byte nodeid, Timestamp time, String remark) {
        this.oper = oper;
        this.orderid = orderid;
        this.nodeid = nodeid;
        this.time = time;
        this.remark = remark;
    }

    // Property accessors
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOper() {
        return this.oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public String getOrderid() {
        return this.orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Byte getNodeid() {
        return this.nodeid;
    }

    public void setNodeid(Byte nodeid) {
        this.nodeid = nodeid;
    }

    public Timestamp getTime() {
        return this.time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
