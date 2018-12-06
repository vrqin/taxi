package com.speedtalk.smartkab.pay.ws.db;

import java.sql.Timestamp;

/**
 * TabPayrecords entity. @author MyEclipse Persistence Tools
 */
public class TabPayrecords implements java.io.Serializable {
    // Fields
    private String orderid;
    private String account;
    private Timestamp getoff;
    private Timestamp geton;
    private Double mileage;
    private Double money;
    private Double extramoney;
    private Timestamp paytime;
    private Short paytype;
    private Timestamp submittime;
    private Double vainmileage;
    private Integer waittime;
    private String tradeno;

    // Constructors

    /**
     * default constructor
     */
    public TabPayrecords() {
    }

    /**
     * minimal constructor
     */
    public TabPayrecords(String orderid) {
        this.orderid = orderid;
    }

    /**
     * full constructor
     */
    public TabPayrecords(String orderid, String account, Timestamp getoff, Timestamp geton, Double mileage, Double money, Double extramoney, Timestamp paytime, Short paytype, Timestamp submittime, Double vainmileage, Integer waittime) {
        this.orderid = orderid;
        this.account = account;
        this.getoff = getoff;
        this.geton = geton;
        this.mileage = mileage;
        this.money = money;
        this.extramoney = extramoney;
        this.paytime = paytime;
        this.paytype = paytype;
        this.submittime = submittime;
        this.vainmileage = vainmileage;
        this.waittime = waittime;
    }

    // Property accessors
    public String getOrderid() {
        return this.orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Timestamp getGetoff() {
        return this.getoff;
    }

    public void setGetoff(Timestamp getoff) {
        this.getoff = getoff;
    }

    public Timestamp getGeton() {
        return this.geton;
    }

    public void setGeton(Timestamp geton) {
        this.geton = geton;
    }

    public Double getMileage() {
        return this.mileage;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
    }

    public Double getMoney() {
        return this.money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Double getExtramoney() {
        return this.extramoney;
    }

    public void setExtramoney(Double extramoney) {
        this.extramoney = extramoney;
    }

    public Timestamp getPaytime() {
        return this.paytime;
    }

    public void setPaytime(Timestamp paytime) {
        this.paytime = paytime;
    }

    public Short getPaytype() {
        return this.paytype;
    }

    public void setPaytype(Short paytype) {
        this.paytype = paytype;
    }

    public Timestamp getSubmittime() {
        return this.submittime;
    }

    public void setSubmittime(Timestamp submittime) {
        this.submittime = submittime;
    }

    public Double getVainmileage() {
        return this.vainmileage;
    }

    public void setVainmileage(Double vainmileage) {
        this.vainmileage = vainmileage;
    }

    public Integer getWaittime() {
        return this.waittime;
    }

    public void setWaittime(Integer waittime) {
        this.waittime = waittime;
    }

    public String getTradeno() {
        return tradeno;
    }

    public void setTradeno(String tradeno) {
        this.tradeno = tradeno;
    }
}
