package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * tab_pass_pay_details
 * 乘客支付明细
 * Created by Administrator on 2016/9/30.
 */
@Entity
@Table(name = "tab_pass_pay_details")
public class PassPayDetails implements Serializable {
    private int id;
    private String passphone;//	varchar(20)			乘客号码
    private String passname;//	varchar(20)			乘客姓名
    private double totalamount;//	double(20)			总金额
    private double payamount;//	double(20)			支付金额
    private double taxicoupons;//	double(20)			打车劵
    private double tip;//	double(20)			小费
    private int payment;//	int(2)			支付方式
    private Date calltime;//datetime			打车时间
    private String drivername;//	varchar(20)			司机姓名
    private String kabnum;//	varchar(20)			车牌号
    private String ordernum;//varchar(20)			电召单号
    private String tradeno; //支付单号

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "passphone", length = 20)
    public String getPassphone() {
        return passphone;
    }

    public void setPassphone(String passphone) {
        this.passphone = passphone;
    }

    @Column(name = "passname", length = 20)
    public String getPassname() {
        return passname;
    }

    public void setPassname(String passname) {
        this.passname = passname;
    }

    @Column(name = "totalamount", length = 20)
    public double getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(double totalamount) {
        this.totalamount = totalamount;
    }

    @Column(name = "payamount", length = 20)
    public double getPayamount() {
        return payamount;
    }

    public void setPayamount(double payamount) {
        this.payamount = payamount;
    }

    @Column(name = "taxicoupons", length = 20)
    public double getTaxicoupons() {
        return taxicoupons;
    }

    public void setTaxicoupons(double taxicoupons) {
        this.taxicoupons = taxicoupons;
    }

    @Column(name = "tip", length = 20)
    public double getTip() {
        return tip;
    }

    public void setTip(double tip) {
        this.tip = tip;
    }

    @Column(name = "payment", length = 2)
    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "calltime", length = 50)
    public Date getCalltime() {
        return calltime;
    }

    public void setCalltime(Date calltime) {
        this.calltime = calltime;
    }

    @Column(name = "drivername", length = 20)
    public String getDrivername() {
        return drivername;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername;
    }

    @Column(name = "kabnum", length = 20)
    public String getKabnum() {
        return kabnum;
    }

    public void setKabnum(String kabnum) {
        this.kabnum = kabnum;
    }

    @Column(name = "ordernum", length = 20)
    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }

    @Column(name = "tradeno", length = 32)
    public String getTradeno() {
        return tradeno;
    }

    public void setTradeno(String tradeno) {
        this.tradeno = tradeno;
    }
}
