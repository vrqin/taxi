package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 101.tab_calling_during_analysis_day电召时段分析-日期
 * Created by Administrator on 2016/10/6.
 */
@Entity
@Table(name = "tab_calling_during_analysis_day")
public class CallingDuringAnalysisDay implements Serializable {
    private int id;
    private String date;//	varchar(11)			日期
    private String area;//地区
    private int total;//	int(11)			总业务数
    private int succnum;//	int(11)			成功数
    private double succratio;//	double(11)			成功比例(%)
    private int passcancel;//	int(11)			乘客取消
    private double passcancelratio;//	double(11)			乘客取消比例(%)
    private int drivercancel;//	int(11)			司机取消比例
    private double drivercancelratio;//	double(11)			司机取消比例(%)
    private int noanswer;//	int(11)			无人接单
    private double noanswerratio;//	double(11)			无人接单比例(%)

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

    @Column(name = "total", length = 20)
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Column(name = "succnum", length = 20)
    public int getSuccnum() {
        return succnum;
    }

    public void setSuccnum(int succnum) {
        this.succnum = succnum;
    }

    @Column(name = "succratio", length = 20)
    public double getSuccratio() {
        return succratio;
    }

    public void setSuccratio(double succratio) {
        this.succratio = succratio;
    }

    @Column(name = "passcancel", length = 20)
    public int getPasscancel() {
        return passcancel;
    }

    public void setPasscancel(int passcancel) {
        this.passcancel = passcancel;
    }

    @Column(name = "passcancelratio", length = 20)
    public double getPasscancelratio() {
        return passcancelratio;
    }

    public void setPasscancelratio(double passcancelratio) {
        this.passcancelratio = passcancelratio;
    }

    @Column(name = "drivercancel", length = 20)
    public int getDrivercancel() {
        return drivercancel;
    }

    public void setDrivercancel(int drivercancel) {
        this.drivercancel = drivercancel;
    }

    @Column(name = "drivercancelratio", length = 20)
    public double getDrivercancelratio() {
        return drivercancelratio;
    }

    public void setDrivercancelratio(double drivercancelratio) {
        this.drivercancelratio = drivercancelratio;
    }

    @Column(name = "noanswer", length = 20)
    public int getNoanswer() {
        return noanswer;
    }

    public void setNoanswer(int noanswer) {
        this.noanswer = noanswer;
    }

    @Column(name = "noanswerratio", length = 20)
    public double getNoanswerratio() {
        return noanswerratio;
    }

    public void setNoanswerratio(double noanswerratio) {
        this.noanswerratio = noanswerratio;
    }

    @Column(name = "area", length = 20)
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
