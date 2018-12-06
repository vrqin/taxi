package com.spring.jersy.hibernate.publics.bean;

/**
 * 支付
 * Created by Administrator on 2016/8/11.
 */
public class PayBean {
    private String billid;//    电召单号
    private String geton;//    上车时间
    private String getoff;//    下车时间
    private String driverCardID;//司机卡ID
    private String kabnum;//车牌号
    private String account;
    private String name;//司机名称
    private Double mileage;//    里程(公里)
    private Double money;//    交易金额(元）

    public String getBillid() {
        return billid;
    }

    public void setBillid(String billid) {
        this.billid = billid;
    }

    public String getGeton() {
        return geton;
    }

    public void setGeton(String geton) {
        this.geton = geton;
    }

    public String getGetoff() {
        return getoff;
    }

    public void setGetoff(String getoff) {
        this.getoff = getoff;
    }

    public String getDriverCardID() {
        return driverCardID;
    }

    public void setDriverCardID(String driverCardID) {
        this.driverCardID = driverCardID;
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
}
