package com.spring.jersy.hibernate.publics.bean;

/**
 * Created by Administrator on 2016/7/14.
 */
public class DriverCallBussReport extends CallBussReport {
    private String drivername;  //乘客
    private String account;  //帐号
    private String phone; //msid
    private int clientid; //所属公司
    private int records;//司机接收的电召单


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    public String getDrivername() {
        return drivername;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername;
    }

    public int getRecords() {
        return records;
    }

    public void setRecords(int records) {
        this.records = records;
    }
}
