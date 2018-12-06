package com.speedtalk.smartkab.ws.domain;

public class DriverExtend {
    private byte code;
    private String desc;
    private String orderNum;
    private String msId;
    private String kabNum;
    private String driverName;
    private String driverSex;
    private String driverPhone;
    private String company;

    public DriverExtend() {
    }

    public DriverExtend(byte code, String desc, String orderNum, String msId, String kabNum, String driverName, String driverSex, String driverPhone, String company) {
        super();
        this.code = code;
        this.desc = desc;
        this.orderNum = orderNum;
        this.msId = msId;
        this.kabNum = kabNum;
        this.driverName = driverName;
        this.driverSex = driverSex;
        this.driverPhone = driverPhone;
        this.company = company;
    }

    public byte getCode() {
        return code;
    }

    public void setCode(byte code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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
}
