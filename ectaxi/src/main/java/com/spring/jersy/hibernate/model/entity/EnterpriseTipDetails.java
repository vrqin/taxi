package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * tab_enterprise_tip_details
 * 企业小费流水
 * Created by Administrator on 2016/9/30.
 */
@Entity
@Table(name = "tab_enterprise_tip_details")
public class EnterpriseTipDetails implements Serializable {
    private int id;
    private Date incometime;//	datetime			收入时间
    private double businesstip;//	double(20)			企业小费
    private double platformtip;//	double(20)			平台小费
    private double drivertip;//double(20)			司机小费
    private double tip;//	double(20)			小费
    private int payment;//	int(4)			支付方式
    private String drivername;//	varchar(20)			司机名称
    private String driverphone;//	varchar(20)			司机手机号
    private String kabnum;//	varchar(20)			车牌号
    private String passname;//	varchar(20)			乘客姓名
    private String kabphone;//	varchar(20)			乘客手机号
    private String ordernum;//	varchar(20)			电召单号

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "incometime", length = 50)
    public Date getIncometime() {
        return incometime;
    }

    public void setIncometime(Date incometime) {
        this.incometime = incometime;
    }

    @Column(name = "businesstip", length = 20)
    public double getBusinesstip() {
        return businesstip;
    }

    public void setBusinesstip(double businesstip) {
        this.businesstip = businesstip;
    }

    @Column(name = "platformtip", length = 20)
    public double getPlatformtip() {
        return platformtip;
    }

    public void setPlatformtip(double platformtip) {
        this.platformtip = platformtip;
    }

    @Column(name = "drivertip", length = 20)
    public double getDrivertip() {
        return drivertip;
    }

    public void setDrivertip(double drivertip) {
        this.drivertip = drivertip;
    }

    @Column(name = "tip", length = 20)
    public double getTip() {
        return tip;
    }

    public void setTip(double tip) {
        this.tip = tip;
    }

    @Column(name = "payment", length = 4)
    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    @Column(name = "drivername", length = 20)
    public String getDrivername() {
        return drivername;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername;
    }

    @Column(name = "driverphone", length = 20)
    public String getDriverphone() {
        return driverphone;
    }

    public void setDriverphone(String driverphone) {
        this.driverphone = driverphone;
    }

    @Column(name = "kabnum", length = 20)
    public String getKabnum() {
        return kabnum;
    }

    public void setKabnum(String kabnum) {
        this.kabnum = kabnum;
    }

    @Column(name = "passname", length = 20)
    public String getPassname() {
        return passname;
    }

    public void setPassname(String passname) {
        this.passname = passname;
    }

    @Column(name = "kabphone", length = 20)
    public String getKabphone() {
        return kabphone;
    }

    public void setKabphone(String kabphone) {
        this.kabphone = kabphone;
    }

    @Column(name = "ordernum", length = 20)
    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }
}
