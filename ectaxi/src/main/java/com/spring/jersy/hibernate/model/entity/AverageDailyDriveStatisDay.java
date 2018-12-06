package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 114.tab_average_daily_drive_statis_day日均出车统计-日期
 * Created by Administrator on 2016/10/6.
 */
@Entity
@Table(name = "tab_average_daily_drive_statis_day")
public class AverageDailyDriveStatisDay implements Serializable {
    private int id;
    private String date;//	varchar(11)			年度
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
