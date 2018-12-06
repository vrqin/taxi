package com.spring.jersy.hibernate.publics.bean;

/**
 * 司机上下班bean
 * Created by Administrator on 2016/8/11.
 */
public class DriverCommuting {

    private String onwork;
    private String offwork;
    private String kabnum;//车牌号
    private String account;//司机名称
    private String name;//司机名称
    private String driverCardID;//司机卡ID
    private String duration;//时长(小时)
    private Double mileage;//    里程(公里)
    private Double money;//    交易金额(元）

    public String getOnwork() {
        return onwork;
    }

    public void setOnwork(String onwork) {
        this.onwork = onwork;
    }

    public String getOffwork() {
        return offwork;
    }

    public void setOffwork(String offwork) {
        this.offwork = offwork;
    }

    public String getKabnum() {
        return kabnum;
    }

    public void setKabnum(String kabnum) {
        this.kabnum = kabnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Double getMileage() {
        return mileage;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDriverCardID() {
        return driverCardID;
    }

    public void setDriverCardID(String driverCardID) {
        this.driverCardID = driverCardID;
    }
}
