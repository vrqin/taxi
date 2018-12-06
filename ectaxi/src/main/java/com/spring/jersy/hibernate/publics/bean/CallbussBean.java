package com.spring.jersy.hibernate.publics.bean;

import java.util.Date;

/**
 * Created by Administrator on 2016/10/20.
 */
public class CallbussBean {
    private String billid; //'单号;主键'
    private Integer status; //'状态: 0新业务 1:已下呼 2:已租车 3:已取消 4:已完成',5,附近没车
    private Date calltime; //'来电时间' 创建时间
    private String address; //'目的地电召地址'
    private String clientmobile; //'客户手机号码'
    private String carbox; //'应召车辆名称'
    private String srcaddr; //'出发地址'
    private Integer orderType;//app,微信，电话
    private int timedifference;//时间差
    private String remark; //'备注'
    private String drivername;
    private String msid;
    private String phone;

    public String getBillid() {
        return billid;
    }

    public void setBillid(String billid) {
        this.billid = billid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCalltime() {
        return calltime;
    }

    public void setCalltime(Date calltime) {
        this.calltime = calltime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClientmobile() {
        return clientmobile;
    }

    public void setClientmobile(String clientmobile) {
        this.clientmobile = clientmobile;
    }

    public String getCarbox() {
        return carbox;
    }

    public void setCarbox(String carbox) {
        this.carbox = carbox;
    }

    public String getSrcaddr() {
        return srcaddr;
    }

    public void setSrcaddr(String srcaddr) {
        this.srcaddr = srcaddr;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public int getTimedifference() {
        return timedifference;
    }

    public void setTimedifference(int timedifference) {
        this.timedifference = timedifference;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDrivername() {
        return drivername;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername;
    }

    public String getMsid() {
        return msid;
    }

    public void setMsid(String msid) {
        this.msid = msid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
