package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 123.tab_enterprise_car_statis企业出车统计
 * Created by Administrator on 2016/10/6.
 */
@Entity
@Table(name = "tab_enterprise_car_statis")
public class EnterpriseCarStatis implements Serializable {
    private int id;
    private String date;
    private String companyname;//	varchar(50)			企业名称
    private int carnum;//	int(11)			企业车辆数
    private int operationcarnum;//int(11)			运营车辆数
    private int avedatebikeoperatnum;//	int(11)			日均工作车辆数
    private double carrate;//	double(11)			企业出车率（%）

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

    @Column(name = "companyname", length = 20)
    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    @Column(name = "carnum", length = 20)
    public int getCarnum() {
        return carnum;
    }

    public void setCarnum(int carnum) {
        this.carnum = carnum;
    }

    @Column(name = "operationcarnum", length = 20)
    public int getOperationcarnum() {
        return operationcarnum;
    }

    public void setOperationcarnum(int operationcarnum) {
        this.operationcarnum = operationcarnum;
    }

    @Column(name = "avedatebikeoperatnum", length = 20)
    public int getAvedatebikeoperatnum() {
        return avedatebikeoperatnum;
    }

    public void setAvedatebikeoperatnum(int avedatebikeoperatnum) {
        this.avedatebikeoperatnum = avedatebikeoperatnum;
    }

    @Column(name = "carrate", length = 20)
    public double getCarrate() {
        return carrate;
    }

    public void setCarrate(double carrate) {
        this.carrate = carrate;
    }
}
