package com.spring.jersy.hibernate.publics.bean;

/**
 * Created by Administrator on 2017/1/2.
 */
public class MonitorBean {


    private Integer allbill;
    private Integer online;
    private Integer empty;
    private Integer passenger;
    private Integer callnum;
    private Integer malfunction;
    private Integer clientid;

    public Integer getAllbill() {
        return allbill;
    }

    public void setAllbill(Integer allbill) {
        this.allbill = allbill;
    }

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }

    public Integer getEmpty() {
        return empty;
    }

    public void setEmpty(Integer empty) {
        this.empty = empty;
    }

    public Integer getPassenger() {
        return passenger;
    }

    public void setPassenger(Integer passenger) {
        this.passenger = passenger;
    }

    public Integer getCallnum() {
        return callnum;
    }

    public void setCallnum(Integer callnum) {
        this.callnum = callnum;
    }

    public Integer getMalfunction() {
        return malfunction;
    }

    public void setMalfunction(Integer malfunction) {
        this.malfunction = malfunction;
    }

    public Integer getClientid() {
        return clientid;
    }

    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }
}
