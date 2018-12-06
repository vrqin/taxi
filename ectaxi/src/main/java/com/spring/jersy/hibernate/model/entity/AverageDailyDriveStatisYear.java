package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 112.tab_average_daily_drive_statis_year日均出车统计-年度
 * Created by Administrator on 2016/10/6.
 */
@Entity
@Table(name = "tab_average_daily_drive_statis_year")
public class AverageDailyDriveStatisYear implements Serializable {
    private int id;
    private String annual;//	varchar(11)			年度
    private String companyname;//	varchar(11)			企业名称
    private int carnum;//	int(11)			车辆总数
    private int operatenum;//	int(11)			运营车辆数
    private int cardaywork;//	int(11)			日均工作车辆数
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

    @Column(name = "annual", length = 20)
    public String getAnnual() {
        return annual;
    }

    public void setAnnual(String annual) {
        this.annual = annual;
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

    @Column(name = "operatenum", length = 20)
    public int getOperatenum() {
        return operatenum;
    }

    public void setOperatenum(int operatenum) {
        this.operatenum = operatenum;
    }

    @Column(name = "cardaywork", length = 20)
    public int getCardaywork() {
        return cardaywork;
    }

    public void setCardaywork(int cardaywork) {
        this.cardaywork = cardaywork;
    }

    @Column(name = "carrate", length = 20)
    public double getCarrate() {
        return carrate;
    }

    public void setCarrate(double carrate) {
        this.carrate = carrate;
    }
}
