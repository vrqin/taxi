package com.spring.jersy.hibernate.publics.bean;

import java.util.Date;

/**
 * Created by Administrator on 2016/10/20.
 */
public class CallbussTimeOutBean {
    private String billid; //'单号;主键'
    private Integer enterpriseid;
    private Integer status; //'状态: 0新业务 1:已下呼 2:已租车 3:已取消 4:已完成',5,附近没车
    private String opruser;
    private Date calltime; //'来电时间' 创建时间
    private String clientmobile; //'客户手机号码'
    private Integer orderType;//app,微信，电话
    private Integer timeoutnum;//时间差

    public String getBillid() {
        return billid;
    }

    public void setBillid(String billid) {
        this.billid = billid;
    }

    public Integer getEnterpriseid() {
        return enterpriseid;
    }

    public void setEnterpriseid(Integer enterpriseid) {
        this.enterpriseid = enterpriseid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOpruser() {
        return opruser;
    }

    public void setOpruser(String opruser) {
        this.opruser = opruser;
    }

    public Date getCalltime() {
        return calltime;
    }

    public void setCalltime(Date calltime) {
        this.calltime = calltime;
    }

    public String getClientmobile() {
        return clientmobile;
    }

    public void setClientmobile(String clientmobile) {
        this.clientmobile = clientmobile;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getTimeoutnum() {
        return timeoutnum;
    }

    public void setTimeoutnum(Integer timeoutnum) {
        this.timeoutnum = timeoutnum;
    }
}
