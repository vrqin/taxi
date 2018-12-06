package com.speedtalk.smartkab.score.ws.db;

/**
 * TabScoreRecords entity. @author MyEclipse Persistence Tools
 */
public class TabScoreRecords implements java.io.Serializable {
    // Fields
    private Integer id;
    private String account;
    private Short type;
    private String ordernum;
    private Integer score;
    private String remark;

    // Constructors

    /**
     * default constructor
     */
    public TabScoreRecords() {
    }

    /**
     * minimal constructor
     */
    public TabScoreRecords(String account, Short type, Integer score) {
        this.account = account;
        this.type = type;
        this.score = score;
    }

    /**
     * full constructor
     */
    public TabScoreRecords(String account, Short type, String ordernum, Integer score, String remark) {
        this.account = account;
        this.type = type;
        this.ordernum = ordernum;
        this.score = score;
        this.remark = remark;
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

    public Short getType() {
        return this.type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public String getOrdernum() {
        return this.ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }

    public Integer getScore() {
        return this.score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
