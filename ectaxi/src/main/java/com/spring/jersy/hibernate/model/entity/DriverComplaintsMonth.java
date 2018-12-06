package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 148.tab_driver_complaints_month驾驶员投诉率-月份
 * Created by Administrator on 2016/10/7.
 */
@Entity
@Table(name = "tab_driver_complaints_month")
public class DriverComplaintsMonth implements Serializable {
    private int id;
    private String account;//	varchar(20)			驾驶员姓名
    private String month;//	varchar(20)			月份
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

    @Column(name = "month", length = 20)
    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
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
