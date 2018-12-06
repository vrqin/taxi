package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 176.tab_passenger_topup_statistics_month乘客充值统计-月份
 * Created by Administrator on 2016/10/7.
 */
@Entity
@Table(name = "tab_passenger_topup_statistics_month")
public class PassengerTopupStatisticsMonth implements Serializable {
    private int id;
    private String month;//	varchar(11)
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

    @Column(name = "month", length = 20)
    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
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
