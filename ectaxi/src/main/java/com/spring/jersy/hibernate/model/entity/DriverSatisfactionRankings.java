package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 136.tab_driver_satisfaction_rankings驾驶员满意度排名
 * Created by Administrator on 2016/10/7.
 */
@Entity
@Table(name = "tab_driver_satisfaction_rankings")
public class DriverSatisfactionRankings implements Serializable {
    private int id;
    private String account;//	int(20)			驾驶员姓名
    private double ranking;//	int(11)			排名
    private double satisfaction;//	double(11)			满意度（%）
    private String satistime;

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

    @Column(name = "ranking", length = 20)
    public double getRanking() {
        return ranking;
    }

    public void setRanking(double ranking) {
        this.ranking = ranking;
    }

    @Column(name = "satisfaction", length = 20)
    public double getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(double satisfaction) {
        this.satisfaction = satisfaction;
    }

    @Column(name = "satistime", length = 50)
    public String getSatistime() {
        return satistime;
    }

    public void setSatistime(String satistime) {
        this.satistime = satistime;
    }


}
