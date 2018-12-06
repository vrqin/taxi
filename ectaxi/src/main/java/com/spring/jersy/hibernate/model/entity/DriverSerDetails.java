package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 55.	tab_driver_ser_details服务评价明细
 * Created by Administrator on 2016/10/6.
 */
@Entity
@Table(name = "tab_driver_ser_details")
public class DriverSerDetails implements Serializable {
    private int id;
    private int star;//	int(4)			评价星级
    private String subsidiary;//	varchar(20)			评价明细
    private Date evatime;//	datetime			评价时间
    private String account;//	varchar(20)			驾驶员帐号
    private String kabnum;//	varchar(20)			车牌号码
    private String passphone;//	varchar(20)			乘客手机号
    private String passname;//	varchar(20)			乘客姓名
    private Date calltime;//	datetime			召车时间
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

    @Column(name = "star", length = 20)
    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    @Column(name = "subsidiary", length = 20)
    public String getSubsidiary() {
        return subsidiary;
    }

    public void setSubsidiary(String subsidiary) {
        this.subsidiary = subsidiary;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "evatime", length = 50)
    public Date getEvatime() {
        return evatime;
    }

    public void setEvatime(Date evatime) {
        this.evatime = evatime;
    }

    @Column(name = "account", length = 20)
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Column(name = "kabnum", length = 20)
    public String getKabnum() {
        return kabnum;
    }

    public void setKabnum(String kabnum) {
        this.kabnum = kabnum;
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

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "calltime", length = 50)
    public Date getCalltime() {
        return calltime;
    }

    public void setCalltime(Date calltime) {
        this.calltime = calltime;
    }

    @Column(name = "ordernum", length = 20)
    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }
}
