package com.spring.jersy.hibernate.publics.bean;

/**
 * 发送电召单实体类
 * Created by Administrator on 2016/5/27.
 */
public class OrderBean {
    private String account;
    private Double srcLt;
    private Double srcLg;
    private String srcAddr;
    private Double dstLt;
    private Double dstLg;
    private String dstAddr;
    private byte type;
    private String remark;
    private byte orderType;
    private String phone;
    private String name;

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

    @Override
    public String toString() {
        return "Order{" + "account='" + account + '\'' + ", srcLt=" + srcLt + ", srcLg=" + srcLg + ", srcAddr='" + srcAddr + '\'' + ", dstLt=" + dstLt + ", dstLg=" + dstLg + ", dstAddr='" + dstAddr + '\'' + ", type=" + type + ", remark='" + remark + '\'' + '}';
    }
}
