package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 117.tab_operate_range_time_hours运营里程-按时段-小时
 * <p>
 * Created by Administrator on 2016/10/6.
 */
@Entity
@Table(name = "tab_operate_range_time_hours")
public class OperateRangeTimeHours implements Serializable {
    private int id;
    private Date hourse;//	varchar(11)			月份
    private String area;//	varchar(11)			区域
    private String companyname;//	varchar(20)			企业名称
    private double operaterange;//	double(11)			营运里程（Km）
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

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "hourse", length = 50)
    public Date getHourse() {
        return hourse;
    }

    public void setHourse(Date hourse) {
        this.hourse = hourse;
    }


    @Column(name = "area", length = 20)
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Column(name = "companyname", length = 20)
    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    @Column(name = "operaterange", length = 20)
    public double getOperaterange() {
        return operaterange;
    }

    public void setOperaterange(double operaterange) {
        this.operaterange = operaterange;
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
