package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 177.tab_passenger_topup_statistics_day乘客充值统计-日期
 * Created by Administrator on 2016/10/7.
 */
@Entity
@Table(name = "tab_passenger_topup_statistics_day")
public class PassengerTopupStatisticsDay implements Serializable {
    private int id;
    private String date;//	varchar(11)
    private double topupmoney;//	double(11)			充值金额(元)
    private String detail;//	varchar			明细

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

    @Column(name = "topupmoney", length = 20)
    public double getTopupmoney() {
        return topupmoney;
    }

    public void setTopupmoney(double topupmoney) {
        this.topupmoney = topupmoney;
    }

    @Column(name = "detail", length = 20)
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
