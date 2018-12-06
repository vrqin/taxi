package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 78.	tab_enterprise_integrated_query企业综合查询
 * Created by Administrator on 2016/10/6.
 */
@Entity
@Table(name = "tab_enterprise_integrated_query")
public class EnterpriseIntegratedQuery implements Serializable {
    private int clientid;
    private String companyname;//	varchar(20)			企业名称
    private String area;//	varchar(20)			区域
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
    @Column(name = "clientid", unique = true, nullable = false, length = 11)
    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    @Transient
    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    @Column(name = "area", length = 20)
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Column(name = "totalincome", length = 20)
    public double getTotalincome() {
        return totalincome;
    }

    public void setTotalincome(double totalincome) {
        this.totalincome = totalincome;
    }

    @Column(name = "dayincome", length = 20)
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
