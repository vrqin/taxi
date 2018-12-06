package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 企业综合数据统计
 * Created by Administrator on 2016/9/29.
 */
@Entity
@Table(name = "tab_enterprise_integrate_statis")
public class EnterpriseIntegrateStatis implements Serializable {

    private int id;//			id
    private String companyname;//企业名称
    private int carnum;//	车辆数量
    private double totalopernum;//	总运营次数
    private double avedayoper;//	日均运营次数
    private double avedayoperincome;//日均运营收入
    private double totalmileage;//	总行驶里程
    private double avedayrange;//	日均行驶里程
    private double totaloper;//	总运营里程
    private double avedayoperange;//	日均运营里程
    private double ratio;//		实载率

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "companyname", length = 50)
    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    @Column(name = "carnum", length = 11)
    public int getCarnum() {
        return carnum;
    }

    public void setCarnum(int carnum) {
        this.carnum = carnum;
    }

    @Column(name = "totalopernum", length = 11)
    public double getTotalopernum() {
        return totalopernum;
    }

    public void setTotalopernum(double totalopernum) {
        this.totalopernum = totalopernum;
    }

    @Column(name = "avedayoper", length = 11)
    public double getAvedayoper() {
        return avedayoper;
    }

    public void setAvedayoper(double avedayoper) {
        this.avedayoper = avedayoper;
    }

    @Column(name = "avedayoperincome", length = 11)
    public double getAvedayoperincome() {
        return avedayoperincome;
    }

    public void setAvedayoperincome(double avedayoperincome) {
        this.avedayoperincome = avedayoperincome;
    }

    @Column(name = "totalmileage", length = 11)
    public double getTotalmileage() {
        return totalmileage;
    }

    public void setTotalmileage(double totalmileage) {
        this.totalmileage = totalmileage;
    }

    @Column(name = "avedayrange", length = 11)
    public double getAvedayrange() {
        return avedayrange;
    }

    public void setAvedayrange(double avedayrange) {
        this.avedayrange = avedayrange;
    }

    @Column(name = "totaloper", length = 11)
    public double getTotaloper() {
        return totaloper;
    }

    public void setTotaloper(double totaloper) {
        this.totaloper = totaloper;
    }

    @Column(name = "avedayoperange", length = 11)
    public double getAvedayoperange() {
        return avedayoperange;
    }

    public void setAvedayoperange(double avedayoperange) {
        this.avedayoperange = avedayoperange;
    }

    @Column(name = "ratio", length = 11)
    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }
}
