package com.speedtalk.order.engine.db;

import java.sql.Timestamp;

/**
 * TabNotifierHistory entity. @author MyEclipse Persistence Tools
 */
public class TabNotifierHistory implements java.io.Serializable {
    // Fields
    private Integer id;
    private Timestamp sendtime;
    private Integer notifierid;
    private Integer status;
    private Integer driverid;
    private Integer clientid;
    private TabNotifierPlus notice;

    // Constructors

    /**
     * default constructor
     */
    public TabNotifierHistory() {
    }

    /**
     * full constructor
     */
    public TabNotifierHistory(Timestamp sendtime, Integer notifierid, Integer status, Integer driverid, Integer clientid) {
        this.sendtime = sendtime;
        this.notifierid = notifierid;
        this.status = status;
        this.driverid = driverid;
        this.clientid = clientid;
    }

    // Property accessors
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getSendtime() {
        return this.sendtime;
    }

    public void setSendtime(Timestamp sendtime) {
        this.sendtime = sendtime;
    }

    public Integer getNotifierid() {
        return this.notifierid;
    }

    public void setNotifierid(Integer notifierid) {
        this.notifierid = notifierid;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDriverid() {
        return this.driverid;
    }

    public void setDriverid(Integer driverid) {
        this.driverid = driverid;
    }

    public Integer getClientid() {
        return this.clientid;
    }

    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }

    public TabNotifierPlus getNotice() {
        return notice;
    }

    public void setNotice(TabNotifierPlus notice) {
        this.notice = notice;
    }
}