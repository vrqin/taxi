package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 109.tab_mileage_income_analysis_year里程收入分析-年份
 * Created by Administrator on 2016/10/6.
 */
@Entity
@Table(name = "tab_mileage_income_analysis_year")
public class MileageIncomeAnalysisYear implements Serializable {
    private int id;
    private String annual;//	varchar(11)			年度
    private String area;
    private double totalmiles;//	double(11)			里程总数（公里）
    private double callmiles;//	double(11)			电召里程（公里）
    private double callmilesratio;//	double(11)			电召里程利用比例（%）
    private double driverincome;//	double(11)			驾驶员收入（元）
    private double drivercallincome;//	double(11)			驾驶员电召收入（元）
    private double callincomeratio;//	double(11)			电召收入比例（%）

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "annual", length = 20)
    public String getAnnual() {
        return annual;
    }

    public void setAnnual(String annual) {
        this.annual = annual;
    }

    @Column(name = "totalmiles", length = 20)
    public double getTotalmiles() {
        return totalmiles;
    }

    public void setTotalmiles(double totalmiles) {
        this.totalmiles = totalmiles;
    }

    @Column(name = "callmiles", length = 20)
    public double getCallmiles() {
        return callmiles;
    }

    public void setCallmiles(double callmiles) {
        this.callmiles = callmiles;
    }

    @Column(name = "callmilesratio", length = 20)
    public double getCallmilesratio() {
        return callmilesratio;
    }

    public void setCallmilesratio(double callmilesratio) {
        this.callmilesratio = callmilesratio;
    }

    @Column(name = "driverincome", length = 20)
    public double getDriverincome() {
        return driverincome;
    }

    public void setDriverincome(double driverincome) {
        this.driverincome = driverincome;
    }

    @Column(name = "drivercallincome", length = 20)
    public double getDrivercallincome() {
        return drivercallincome;
    }

    public void setDrivercallincome(double drivercallincome) {
        this.drivercallincome = drivercallincome;
    }

    @Column(name = "callincomeratio", length = 20)
    public double getCallincomeratio() {
        return callincomeratio;
    }

    public void setCallincomeratio(double callincomeratio) {
        this.callincomeratio = callincomeratio;
    }

    @Column(name = "area", length = 20)
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
