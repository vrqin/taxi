package com.speedtalk.order.engine.db;

import java.sql.Timestamp;

/**
 * TabOrderTrack entity. @author MyEclipse Persistence Tools
 */
public class TabOrderTrack implements java.io.Serializable {
    // Fields
    private Integer id;
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
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOper() {
        return oper;
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
