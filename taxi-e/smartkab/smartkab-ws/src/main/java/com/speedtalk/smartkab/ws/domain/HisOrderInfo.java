package com.speedtalk.smartkab.ws.domain;

public class HisOrderInfo {
    private String orderNum;
    private String passer;
    private String srcAddr;
    private String srcLg;
    private String srcLt;
    private String dstAddr;
    private String dstLg;
    private String dstLt;
    private String time;
    private String dName;
    private String kabNum;
    private String dPhone;
    private String company;
    private String evaluate;
    private String status;
    private String remark;
    private String ordertype;

    public HisOrderInfo() {
    }

    public HisOrderInfo(String orderNum, String passer, String srcAddr, String srcLg, String srcLt, String dstAddr, String dstLg, String dstLt, String time, String dName, String kabNum, String dPhone, String company, String evaluate, String status, String remark, String ordertype) {
        super();
        this.orderNum = orderNum;
        this.passer = passer;
        this.srcAddr = srcAddr;
        this.srcLg = srcLg;
        this.srcLt = srcLt;
        this.dstAddr = dstAddr;
        this.dstLg = dstLg;
        this.dstLt = dstLt;
        this.time = time;
        this.dName = dName;
        this.kabNum = kabNum;
        this.dPhone = dPhone;
        this.company = company;
        this.evaluate = evaluate;
        this.status = status;
        this.remark = remark;
        this.ordertype = ordertype;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getPasser() {
        return passer;
    }

    public void setPasser(String passer) {
        this.passer = passer;
    }

    public String getSrcAddr() {
        return srcAddr;
    }

    public void setSrcAddr(String srcAddr) {
        this.srcAddr = srcAddr;
    }

    public String getSrcLg() {
        return srcLg;
    }

    public void setSrcLg(String srcLg) {
        this.srcLg = srcLg;
    }

    public String getSrcLt() {
        return srcLt;
    }

    public void setSrcLt(String srcLt) {
        this.srcLt = srcLt;
    }

    public String getDstAddr() {
        return dstAddr;
    }

    public void setDstAddr(String dstAddr) {
        this.dstAddr = dstAddr;
    }

    public String getDstLg() {
        return dstLg;
    }

    public void setDstLg(String dstLg) {
        this.dstLg = dstLg;
    }

    public String getDstLt() {
        return dstLt;
    }

    public void setDstLt(String dstLt) {
        this.dstLt = dstLt;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getKabNum() {
        return kabNum;
    }

    public void setKabNum(String kabNum) {
        this.kabNum = kabNum;
    }

    public String getdPhone() {
        return dPhone;
    }

    public void setdPhone(String dPhone) {
        this.dPhone = dPhone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(String ordertype) {
        this.ordertype = ordertype;
    }
}
