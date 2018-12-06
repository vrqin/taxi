package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * tab_driver_income
 * 司机收入流水
 * Created by Administrator on 2016/9/30.
 */
@Entity
@Table(name = "tab_driver_income")
public class DriverIncome implements Serializable {

    private int id;
    private String driverphone;//	varchar(20)			司机手机号
    private String drivername;//	varchar(20)			司机姓名
    private double amount;//	double(20)			收入金额
    private double bill;//	double(20)			打车费
    private double drivertip;//	double(20)			司机小费
    private int payment;//	int(4)			支付方式
    private Date incometime;//	datetime			收入时间
    private String kabnum;//	varchar(20)			车牌号
    private String passname;//	varchar(20)			乘客姓名
    private String passphone;//	varchar(20)			乘客手机号
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

    @Column(name = "driverphone", length = 20)
    public String getDriverphone() {
        return driverphone;
    }

    public void setDriverphone(String driverphone) {
        this.driverphone = driverphone;
    }

    @Column(name = "drivername", length = 20)
    public String getDrivername() {
        return drivername;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername;
    }

    @Column(name = "amount", length = 20)
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Column(name = "bill", length = 20)
    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    @Column(name = "drivertip", length = 20)
    public double getDrivertip() {
        return drivertip;
    }

    public void setDrivertip(double drivertip) {
        this.drivertip = drivertip;
    }

    @Column(name = "payment", length = 4)
    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
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

    @Column(name = "passphone", length = 20)
    public String getPassphone() {
        return passphone;
    }

    public void setPassphone(String passphone) {
        this.passphone = passphone;
    }

    @Column(name = "ordernum", length = 20)
    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }
}
