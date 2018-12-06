package com.speedtalk.smartkab.ws.db;

import java.sql.Timestamp;

/**
 * TabFeedback entity. @author MyEclipse Persistence Tools
 */
public class TabFeedback implements java.io.Serializable {
    // Fields
    private Integer id;
    private String user;
    private String content;
    private Timestamp time;

    // Constructors

    /**
     * default constructor
     */
    public TabFeedback() {
    }

    /**
     * minimal constructor
     */
    public TabFeedback(String user, String content) {
        this.user = user;
        this.content = content;
    }

    /**
     * full constructor
     */
    public TabFeedback(String user, String content, Timestamp time) {
        this.user = user;
        this.content = content;
        this.time = time;
    }

    // Property accessors
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTime() {
        return this.time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
