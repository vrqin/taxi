package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 147.tab_driver_complaints_year驾驶员投诉率-年度
 * Created by Administrator on 2016/10/7.
 */
@Entity
@Table(name = "tab_driver_complaints_year")
public class DriverComplaintsYear implements Serializable {
    private int id;
    private String account;//	varchar(20)			驾驶员姓名
    private String annual;//	varchar(20)			年度
    private double measured;//	double(11)			投诉率（%）
    private int complaint;// 投诉次数
    private int operation;// 运营次数

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "account", length = 20)
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Column(name = "annual", length = 20)
    public String getAnnual() {
        return annual;
    }

    public void setAnnual(String annual) {
        this.annual = annual;
    }

    @Column(name = "measured", length = 20)
    public double getMeasured() {
        return measured;
    }

    public void setMeasured(double measured) {
        this.measured = measured;
    }

    @Column(name = "complaint", length = 20)

    public int getComplaint() {
        return complaint;
    }

    public void setComplaint(int complaint) {
        this.complaint = complaint;
    }

    @Column(name = "operation", length = 20)
    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }
}
