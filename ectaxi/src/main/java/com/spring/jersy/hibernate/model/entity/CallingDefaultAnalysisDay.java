package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 108.tab_calling_default_analysis_day电召违约分析-日期
 * Created by Administrator on 2016/10/6.
 */
@Entity
@Table(name = "tab_calling_default_analysis_day")
public class CallingDefaultAnalysisDay implements Serializable {
    private int id;
    private String date;//	varchar(11)			年度
    private String area;//
    private int total;//	int(11)			总业务数
    private int passcancel;//	int(11)			乘客取消
    private double passcancelratio;//	double(11)			乘客取消比例(%)
    private int drivercancel;//	int(11)			司机取消比例
    private double drivercancelratio;//	double(11)			司机取消比例(%)
    private int passdefault;//	int(11)			乘客违约
    private double passdefaultratio;//	double(11)			乘客违约比例(%)
    private int driverdefault;//	int(11)			司机违约
    private double driverdefaultratio;//	double(11)			司机违约比例(%)

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

    @Column(name = "passdefault", length = 20)
    public int getPassdefault() {
        return passdefault;
    }

    public void setPassdefault(int passdefault) {
        this.passdefault = passdefault;
    }

    @Column(name = "passdefaultratio", length = 20)
    public double getPassdefaultratio() {
        return passdefaultratio;
    }

    public void setPassdefaultratio(double passdefaultratio) {
        this.passdefaultratio = passdefaultratio;
    }

    @Column(name = "driverdefault", length = 20)
    public int getDriverdefault() {
        return driverdefault;
    }

    public void setDriverdefault(int driverdefault) {
        this.driverdefault = driverdefault;
    }

    @Column(name = "driverdefaultratio", length = 20)
    public double getDriverdefaultratio() {
        return driverdefaultratio;
    }

    public void setDriverdefaultratio(double driverdefaultratio) {
        this.driverdefaultratio = driverdefaultratio;
    }

    @Column(name = "area", length = 20)
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
