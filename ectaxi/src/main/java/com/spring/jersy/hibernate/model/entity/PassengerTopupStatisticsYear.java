package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 175.tab_passenger_topup_statistics_year乘客充值统计-年度
 * Created by Administrator on 2016/10/7.
 */
@Entity
@Table(name = "tab_passenger_topup_statistics_year")
public class PassengerTopupStatisticsYear implements Serializable {
    private int id;
    private String annual;//	varchar(11)			年度
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

    @Column(name = "annual", length = 20)
    public String getAnnual() {
        return annual;
    }

    public void setAnnual(String annual) {
        this.annual = annual;
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
