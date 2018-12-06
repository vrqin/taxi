package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 138.tab_driver_satisfaction_worktime驾驶员满意度-从业时间
 * Created by Administrator on 2016/10/7.
 */
@Entity
@Table(name = "tab_driver_satisfaction_worktime")
public class DriverSatisfactionWorktime implements Serializable {
    private int id;
    private String companyname;//	varchar(20)			企业名称
    private int worktime;//datetime			从业时间
    private double satisfaction;//	double(11)			满意度（%）
    private String satistime;
    private int complaint;// 投诉次数
    private int operation;// 运营次数
    private double measured;//投诉率

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "companyname", length = 20)
    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    @Column(name = "worktime", length = 20)
    public int getWorktime() {
        return worktime;
    }

    public void setWorktime(int worktime) {
        this.worktime = worktime;
    }

    @Column(name = "satisfaction", length = 20)
    public double getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(double satisfaction) {
        this.satisfaction = satisfaction;
    }

    @Column(name = "satistime", length = 50)
    public String getSatistime() {
        return satistime;
    }

    public void setSatistime(String satistime) {
        this.satistime = satistime;
    }

    @Column(name = "complaint", length = 50)
    public int getComplaint() {
        return complaint;
    }

    public void setComplaint(int complaint) {
        this.complaint = complaint;
    }

    @Column(name = "operation", length = 50)
    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }

    @Column(name = "measured", length = 50)
    public double getMeasured() {
        return measured;
    }

    public void setMeasured(double measured) {
        this.measured = measured;
    }
}
