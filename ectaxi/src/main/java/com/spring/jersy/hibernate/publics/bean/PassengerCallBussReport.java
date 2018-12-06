package com.spring.jersy.hibernate.publics.bean;

/**
 * Created by Administrator on 2016/7/14.
 */
public class PassengerCallBussReport extends CallBussReport {
    private String opruser;  //乘客

    private String name;

    private int apptotal;       //总数
    private int appunfinish;    //未完成
    private int appcancellation;//取消
    private int appfinish;      //未完成

    private int wxtotal;       //总数
    private int wxunfinish;    //未完成
    private int wxcancellation;//取消
    private int wxfinish;      //未完成

    private int plonetotal;       //总数
    private int ploneunfinish;    //未完成
    private int plonecancellation;//取消
    private int plonefinish;      //未完成

    public String getOpruser() {
        return opruser;
    }

    public void setOpruser(String opruser) {
        this.opruser = opruser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getApptotal() {
        return apptotal;
    }

    public void setApptotal(int apptotal) {
        this.apptotal = apptotal;
    }

    public int getAppunfinish() {
        return appunfinish;
    }

    public void setAppunfinish(int appunfinish) {
        this.appunfinish = appunfinish;
    }

    public int getAppcancellation() {
        return appcancellation;
    }

    public void setAppcancellation(int appcancellation) {
        this.appcancellation = appcancellation;
    }

    public int getAppfinish() {
        return appfinish;
    }

    public void setAppfinish(int appfinish) {
        this.appfinish = appfinish;
    }

    public int getWxtotal() {
        return wxtotal;
    }

    public void setWxtotal(int wxtotal) {
        this.wxtotal = wxtotal;
    }

    public int getWxunfinish() {
        return wxunfinish;
    }

    public void setWxunfinish(int wxunfinish) {
        this.wxunfinish = wxunfinish;
    }

    public int getWxcancellation() {
        return wxcancellation;
    }

    public void setWxcancellation(int wxcancellation) {
        this.wxcancellation = wxcancellation;
    }

    public int getWxfinish() {
        return wxfinish;
    }

    public void setWxfinish(int wxfinish) {
        this.wxfinish = wxfinish;
    }

    public int getPlonetotal() {
        return plonetotal;
    }

    public void setPlonetotal(int plonetotal) {
        this.plonetotal = plonetotal;
    }

    public int getPloneunfinish() {
        return ploneunfinish;
    }

    public void setPloneunfinish(int ploneunfinish) {
        this.ploneunfinish = ploneunfinish;
    }

    public int getPlonecancellation() {
        return plonecancellation;
    }

    public void setPlonecancellation(int plonecancellation) {
        this.plonecancellation = plonecancellation;
    }

    public int getPlonefinish() {
        return plonefinish;
    }

    public void setPlonefinish(int plonefinish) {
        this.plonefinish = plonefinish;
    }
}
