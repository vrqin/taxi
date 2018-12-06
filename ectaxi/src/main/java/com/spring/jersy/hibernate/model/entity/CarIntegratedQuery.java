package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 79.	tab_car_integrated_query车辆综合查询
 * Created by Administrator on 2016/10/6.
 */
@Entity
@Table(name = "tab_car_integrated_query")
public class CarIntegratedQuery implements Serializable {
    //    private int id;
    private String kabnum;//	varchar(20)			车牌号
    private String company;//	varchar(20)			所属企业
    private int clientid;
    private double totalincome;//	double(11)			总收入
    private double dayincome;//	double(11)			日均收入
    private int totaltime;//	int(11)			总时长
    private int daytime;//	int(11)			日均时长
    private int totalope;//	int(11)			总运营次数
    private int dayope;//	int(11)			日均运营次数
    private int totalcalling;//	int(11)			电召总数
    private int succalling;//	int(11)			成功电召数
    private int pascancalling;//	int(11)			电召乘客取消
    private int dricancalling;//	int(11)			电召司机取消


    @Id
    @Column(name = "kabnum", length = 20, unique = true, nullable = false)
    public String getKabnum() {
        return kabnum;
    }

    public void setKabnum(String kabnum) {
        this.kabnum = kabnum;
    }

    @Transient
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Column(name = "clientid", length = 20)
    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    @Column(name = "totalincome", length = 20, scale = 2)
    public double getTotalincome() {
        return totalincome;
    }

    public void setTotalincome(double totalincome) {
        this.totalincome = totalincome;
    }

    @Column(name = "dayincome", length = 20, scale = 2)
    public double getDayincome() {
        return dayincome;
    }

    public void setDayincome(double dayincome) {
        this.dayincome = dayincome;
    }

    @Column(name = "totaltime", length = 20)
    public int getTotaltime() {
        return totaltime;
    }

    public void setTotaltime(int totaltime) {
        this.totaltime = totaltime;
    }

    @Column(name = "daytime", length = 20)
    public int getDaytime() {
        return daytime;
    }

    public void setDaytime(int daytime) {
        this.daytime = daytime;
    }

    @Column(name = "totalope", length = 20)
    public int getTotalope() {
        return totalope;
    }

    public void setTotalope(int totalope) {
        this.totalope = totalope;
    }

    @Column(name = "dayope", length = 20)
    public int getDayope() {
        return dayope;
    }

    public void setDayope(int dayope) {
        this.dayope = dayope;
    }

    @Column(name = "totalcalling", length = 20)
    public int getTotalcalling() {
        return totalcalling;
    }

    public void setTotalcalling(int totalcalling) {
        this.totalcalling = totalcalling;
    }

    @Column(name = "succalling", length = 20)
    public int getSuccalling() {
        return succalling;
    }

    public void setSuccalling(int succalling) {
        this.succalling = succalling;
    }

    @Column(name = "pascancalling", length = 20)
    public int getPascancalling() {
        return pascancalling;
    }

    public void setPascancalling(int pascancalling) {
        this.pascancalling = pascancalling;
    }

    @Column(name = "dricancalling", length = 20)
    public int getDricancalling() {
        return dricancalling;
    }

    public void setDricancalling(int dricancalling) {
        this.dricancalling = dricancalling;
    }
}
