package com.speedtalk.smartkab.ws.domain;

public class Driver {
    protected String orderNum;
    protected String msId;
    protected String kabNum;
    protected String driverName;
    protected String driverSex;
    protected String driverPhone;
    protected String company;

    public Driver() {
    }

    public Driver(String orderNum) {
        this.orderNum = orderNum;
    }

    public Driver(String orderNum, String msId, String kabNum, String driverName, String driverSex, String driverPhone, String company) {
        super();
        this.orderNum = orderNum;
        this.msId = msId;
        this.kabNum = kabNum;
        this.driverName = driverName;
        this.driverSex = driverSex;
        this.driverPhone = driverPhone;
        this.company = company;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getMsId() {
        return msId;
    }

    public void setMsId(String msId) {
        this.msId = msId;
    }

    public String getKabNum() {
        return kabNum;
    }

    public void setKabNum(String kabNum) {
        this.kabNum = kabNum;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverSex() {
        return driverSex;
    }

    public void setDriverSex(String driverSex) {
        this.driverSex = driverSex;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Driver [orderNum=" + orderNum + ", msId=" + msId + ", kabNum=" + kabNum + ", driverName=" + driverName + ", driverSex=" + driverSex + ", driverPhone=" + driverPhone + ", company=" + company + "]";
    }
}
