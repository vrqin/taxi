package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 支付记录
 * Created by Administrator on 2016/8/15.
 */
@Entity
@Table(name = "tab_payrecords")
public class PayRecords implements Serializable {
    private static final long serialVersionUID = -131312312312321L;
    private String orderid; //电召单号
    private Date geton; //上车时间
    private Date getoff;//下车时间
    private String account;//司机帐号
    private Double mileage;//历程
    private Double money;//金额
    private Double vainmileage; //空驶里程(公里)
    private Double extramoney;  //附加费(元)
    private Integer waittime;//等待计时时间(秒)
    private Date submittime;// 提交时间
    private Byte paytype;//支付方式：0：现金；1：支付宝；2：微信
    private Date paytime;//支付时间，空时表示未支付
    private Integer paystatus;// 提现 ；  0:未申请，1:申请，2:未提现，3:提现

    @Id
    @Column(name = "orderid", length = 19)
    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "geton", length = 50)
    public Date getGeton() {
        return geton;
    }

    public void setGeton(Date geton) {
        this.geton = geton;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "getoff", length = 50)
    public Date getGetoff() {
        return getoff;
    }

    public void setGetoff(Date getoff) {
        this.getoff = getoff;
    }

    @Column(name = "account", length = 20)
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Column(name = "mileage", length = 8)
    public Double getMileage() {
        return mileage;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
    }

    @Column(name = "money", length = 8)
    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Column(name = "vainmileage", length = 8)
    public Double getVainmileage() {
        return vainmileage;
    }

    public void setVainmileage(Double vainmileage) {
        this.vainmileage = vainmileage;
    }

    @Column(name = "extramoney", length = 8)
    public Double getExtramoney() {
        return extramoney;
    }

    public void setExtramoney(Double extramoney) {
        this.extramoney = extramoney;
    }

    @Column(name = "waittime", length = 11)
    public Integer getWaittime() {
        return waittime;
    }

    public void setWaittime(Integer waittime) {
        this.waittime = waittime;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "submittime", length = 50)
    public Date getSubmittime() {
        return submittime;
    }

    public void setSubmittime(Date submittime) {
        this.submittime = submittime;
    }

    @Column(name = "paytype")
    public Byte getPaytype() {
        return paytype;
    }

    public void setPaytype(Byte paytype) {
        this.paytype = paytype;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "paytime", length = 50)
    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    @Column(name = "paystatus", columnDefinition = "INT default 0")
    public Integer getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(Integer paystatus) {
        this.paystatus = paystatus;
    }

    @Override
    public String toString() {
        return "PayreCords{" + "orderid='" + orderid + '\'' + ", geton=" + geton + ", getoff=" + getoff + ", account='" + account + '\'' + ", mileage=" + mileage + ", money=" + money + '}';
    }
}
