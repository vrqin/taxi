package com.speedtalk.smartkab.ws.domain;

public class OrderInfo {
    private String orderNum;
    private String phone;
    private Double srcLt;
    private Double srcLg;
    private String srcAddr;
    private Double dstLt;
    private Double dstLg;
    private String dstAddr;
    private String time;
    private String type;
    private String status;

    public OrderInfo() {
        super();
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderInfo [orderNum=" + orderNum + ", phone=" + phone + ", srcLt=" + srcLt + ", srcLg=" + srcLg + ", srcAddr=" + srcAddr + ", dstLt=" + dstLt + ", dstLg=" + dstLg + ", dstAddr=" + dstAddr + ", time=" + time + ", type=" + type + ", status=" + status + "]";
    }
}
