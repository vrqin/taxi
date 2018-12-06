package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 146.tab_enterprise_complaints_day企业投诉率-日期
 * Created by Administrator on 2016/10/7.
 */
@Entity
@Table(name = "tab_enterprise_complaints_day")
public class EnterpriseComplaintsDay implements Serializable {
    private int id;
    private String companyname;//	varchar(20)			企业名称
    private String date;//	varchar(20)			月份
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

    @Column(name = "companyname", length = 20)
    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    @Column(name = "date", length = 20)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
