package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 144.tab_enterprise_complaints_year企业投诉率-年度
 * Created by Administrator on 2016/10/7.
 */
@Entity
@Table(name = "tab_enterprise_complaints_year")
public class EnterpriseComplaintsYear implements Serializable {
    private int id;
    private String companyname;//	varchar(20)			企业名称
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

    @Column(name = "companyname", length = 20)
    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
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
