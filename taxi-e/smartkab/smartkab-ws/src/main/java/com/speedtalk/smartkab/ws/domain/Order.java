package com.speedtalk.smartkab.ws.domain;

public class Order {
    private String account;    //客户端账号
    private Double srcLt;    //召车纬度
    private Double srcLg;    //召车经度
    private String srcAddr;    //召车地址
    private Double dstLt;    //目的地纬度
    private Double dstLg;    //目的地经度
    private String dstAddr;    //目的地地址
    private byte type;    //电召类型：0实时;1预约
    private String remark;    //备注
    private byte orderType;    //订单入口：0：app;1：微信;2：电话
    private String phone;    //客户来电号码
    private String name;    //客户姓名
    private String driver;    //司机账号

    public Order() {
        super();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Double getSrcLt() {
        return srcLt;
    }

    public void setSrcLt(Double srcLt) {
        this.srcLt = srcLt;
    }

    public Double getSrcLg() {
        return srcLg;
    }

    public void setSrcLg(Double srcLg) {
        this.srcLg = srcLg;
    }

    public String getSrcAddr() {
        return srcAddr;
    }

    public void setSrcAddr(String srcAddr) {
        this.srcAddr = srcAddr;
    }

    public Double getDstLt() {
        return dstLt;
    }

    public void setDstLt(Double dstLt) {
        this.dstLt = dstLt;
    }

    public Double getDstLg() {
        return dstLg;
    }

    public void setDstLg(Double dstLg) {
        this.dstLg = dstLg;
    }

    public String getDstAddr() {
        return dstAddr;
    }

    public void setDstAddr(String dstAddr) {
        this.dstAddr = dstAddr;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public byte getOrderType() {
        return orderType;
    }

    public void setOrderType(byte orderType) {
        this.orderType = orderType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "Order [account=" + account + ", srcLt=" + srcLt + ", srcLg=" + srcLg + ", srcAddr=" + srcAddr + ", dstLt=" + dstLt + ", dstLg=" + dstLg + ", dstAddr=" + dstAddr + ", type=" + type + ", remark=" + remark + ", orderType=" + orderType + ", phone=" + phone + ", name=" + name + ", driver=" + driver + "]";
    }
}
