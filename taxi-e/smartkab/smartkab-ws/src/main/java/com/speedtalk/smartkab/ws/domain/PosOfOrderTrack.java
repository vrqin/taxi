package com.speedtalk.smartkab.ws.domain;

public class PosOfOrderTrack {
    private String orderNum;
    private String account;
    private double lg;
    private double lt;
    private String time;

    public PosOfOrderTrack() {
        super();
    }

    public PosOfOrderTrack(String orderNum, String account, double lg, double lt, String time) {
        super();
        this.orderNum = orderNum;
        this.account = account;
        this.lg = lg;
        this.lt = lt;
        this.time = time;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public double getLg() {
        return lg;
    }

    public void setLg(double lg) {
        this.lg = lg;
    }

    public double getLt() {
        return lt;
    }

    public void setLt(double lt) {
        this.lt = lt;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
