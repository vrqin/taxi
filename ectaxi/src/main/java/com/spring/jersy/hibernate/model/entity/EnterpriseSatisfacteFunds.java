package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 135.tab_enterprise_satisfacte_funds	企业满意度-资金规模
 * Created by Administrator on 2016/10/7.
 */
@Entity
@Table(name = "tab_enterprise_satisfacte_funds")
public class EnterpriseSatisfacteFunds implements Serializable {
    private int id;
    private String companyname;//	varchar(20)			企业名称
    private int funds;//	int(11)			资金规模
    private double satisfaction;//	double(20)			满意度（%）
    private String satistime;//时间
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

    @Column(name = "funds", length = 20)
    public int getFunds() {
        return funds;
    }

    public void setFunds(int funds) {
        this.funds = funds;
    }

    @Column(name = "satistime", length = 50)
    public String getSatistime() {
        return satistime;
    }

    public void setSatistime(String satistime) {
        this.satistime = satistime;
    }

    @Column(name = "satisfaction", length = 20)
    public double getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(double satisfaction) {
        this.satisfaction = satisfaction;
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
