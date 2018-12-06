package com.speedtalk.order.engine.db;

import java.sql.Timestamp;

/**
 * TabLogSmsdiary entity. @author MyEclipse Persistence Tools
 */
public class TabLogSmsdiary implements java.io.Serializable {
    // Fields
    private Integer id;
    private String content;
    private String phone;
    private Timestamp sendtime;
    private Integer clientid;

    // Constructors

    /**
     * default constructor
     */
    public TabLogSmsdiary() {
    }

    /**
     * full constructor
     */
    public TabLogSmsdiary(String content, String phone, Timestamp sendtime, int clientid) {
        this.content = content;
        this.phone = phone;
        this.sendtime = sendtime;
        this.clientid = clientid;
    }

    // Property accessors
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Timestamp getSendtime() {
        return this.sendtime;
    }

    public void setSendtime(Timestamp sendtime) {
        this.sendtime = sendtime;
    }

    public Integer getClientid() {
        return clientid;
    }

    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }
}
