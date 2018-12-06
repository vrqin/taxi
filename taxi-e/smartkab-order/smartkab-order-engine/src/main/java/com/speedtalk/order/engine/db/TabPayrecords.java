package com.speedtalk.order.engine.db;

import java.sql.Timestamp;

/**
 * TabPayrecords entity. @author MyEclipse Persistence Tools
 */
public class TabPayrecords implements java.io.Serializable {
    // Fields
    private String orderid;
    private Timestamp geton;
    private Timestamp getoff;
    private String account;
    private Double mileage;
    private Double money;
    private Double vainmileage;
    private Double extramoney;
    private Integer waittime;
    private Integer paytype;
    private Timestamp paytime;
    private String tradeno;

    // Constructors

    /**
     * default constructor
     */
    public TabPayrecords() {
    }

    /**
     * full constructor
     */
    public TabPayrecords(String orderid, Timestamp geton, Timestamp getoff, String account, Double mileage, Double money, Double vainmileage, Double extramoney, Integer waittime, Integer paytype, Timestamp paytime) {
        this.orderid = orderid;
        this.geton = geton;
        this.getoff = getoff;
        this.account = account;
        this.mileage = mileage;
        this.money = money;
        this.vainmileage = vainmileage;
        this.extramoney = extramoney;
        this.waittime = waittime;
        this.paytype = paytype;
        this.paytime = paytime;
    }

    // Property accessors
    public String getOrderid() {
        return this.orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Timestamp getGeton() {
        return this.geton;
    }

    public void setGeton(Timestamp geton) {
        this.geton = geton;
    }

    public Timestamp getGetoff() {
        return this.getoff;
    }

    public void setGetoff(Timestamp getoff) {
        this.getoff = getoff;
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String account) {
        this.account = account;
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

    public Double getVainmileage() {
        return this.vainmileage;
    }

    public void setVainmileage(Double vainmileage) {
        this.vainmileage = vainmileage;
    }

    public Double getExtramoney() {
        return this.extramoney;
    }

    public void setExtramoney(Double extramoney) {
        this.extramoney = extramoney;
    }

    public Integer getWaittime() {
        return this.waittime;
    }

    public void setWaittime(Integer waittime) {
        this.waittime = waittime;
    }

    public Integer getPaytype() {
        return paytype;
    }

    public void setPaytype(Integer paytype) {
        this.paytype = paytype;
    }

    public Timestamp getPaytime() {
        return paytime;
    }

    public void setPaytime(Timestamp paytime) {
        this.paytime = paytime;
    }

    public String getTradeno() {
        return tradeno;
    }

    public void setTradeno(String tradeno) {
        this.tradeno = tradeno;
    }
}
