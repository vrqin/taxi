package com.speedtalk.smartkab.score.ws.db;

/**
 * TabPassengerScore entity. @author MyEclipse Persistence Tools
 */
public class TabPassengerScore implements java.io.Serializable {
    // Fields
    private Integer id;
    private String account;
    private Integer score;

    // Constructors

    /**
     * default constructor
     */
    public TabPassengerScore() {
    }

    /**
     * full constructor
     */
    public TabPassengerScore(String account, Integer score) {
        this.account = account;
        this.score = score;
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

    public Integer getScore() {
        return this.score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
