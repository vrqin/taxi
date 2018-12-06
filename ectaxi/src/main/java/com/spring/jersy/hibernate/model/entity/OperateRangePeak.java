package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 118.tab_operate_range_peak运营里程-按高峰
 * Created by Administrator on 2016/10/6.
 */
@Entity
@Table(name = "tab_operate_range_peak")
public class OperateRangePeak implements Serializable {
    private int id;
    private String date;//	varchar(11)			日期
    private String area;//	varchar(11)			区域
    private String companyname;//	varchar(50)			企业名称
    private String peakperiod;//	varchar(11)			高峰段
    private double orange;//	double(11)			行驶里程（Km）
    private double passmiles;//	double(11)			载客里程（Km）
    private double emptydistance;//	double(11)			空驶里程（Km）
    private double mileageutilization;//	double(11)			里程利用率（%）

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "date", length = 20)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Column(name = "area", length = 20)
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Column(name = "companyname", length = 50)
    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    @Column(name = "peakperiod", length = 20)
    public String getPeakperiod() {
        return peakperiod;
    }

    public void setPeakperiod(String peakperiod) {
        this.peakperiod = peakperiod;
    }

    @Column(name = "orange", length = 20)
    public double getOrange() {
        return orange;
    }

    public void setOrange(double orange) {
        this.orange = orange;
    }

    @Column(name = "passmiles", length = 20)
    public double getPassmiles() {
        return passmiles;
    }

    public void setPassmiles(double passmiles) {
        this.passmiles = passmiles;
    }

    @Column(name = "emptydistance", length = 20)
    public double getEmptydistance() {
        return emptydistance;
    }

    public void setEmptydistance(double emptydistance) {
        this.emptydistance = emptydistance;
    }

    @Column(name = "mileageutilization", length = 20)
    public double getMileageutilization() {
        return mileageutilization;
    }

    public void setMileageutilization(double mileageutilization) {
        this.mileageutilization = mileageutilization;
    }
}
