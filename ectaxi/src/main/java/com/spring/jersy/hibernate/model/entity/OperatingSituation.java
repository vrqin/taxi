package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 50.	tab_operating_situation运营的情况
 * Created by Administrator on 2016/10/6.
 */
@Entity
@Table(name = "tab_operating_situation")
public class OperatingSituation implements Serializable {
    //    private int id;//			id
    private int enterprise;//	varchar(20)			企业名称
    private int totalnum;//	int(20)			车辆总数
    private int emptynum;//	int(20)			空车数量
    private int heavynum;//	int(20)			重车数量
    private int totaloperat;//	int(20)			总运营次数
    private double passmiles;//	int(20)			总载客里程
    private double totalrevenue;//	int(20)			总收入
    private String company;
    private String token;

    //    @Id
    //    @GeneratedValue(strategy = GenerationType.AUTO)
    //    @Column(name = "id", unique = true, nullable = false, length = 11)
    //    public int getId() {
    //        return id;
    //    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "enterprise", length = 20)
    public int getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(int enterprise) {
        this.enterprise = enterprise;
    }

    @Column(name = "totalnum", length = 20)
    public int getTotalnum() {
        return totalnum;
    }

    public void setTotalnum(int totalnum) {
        this.totalnum = totalnum;
    }

    @Column(name = "emptynum", length = 20)
    public int getEmptynum() {
        return emptynum;
    }

    public void setEmptynum(int emptynum) {
        this.emptynum = emptynum;
    }

    @Column(name = "heavynum", length = 20)
    public int getHeavynum() {
        return heavynum;
    }

    public void setHeavynum(int heavynum) {
        this.heavynum = heavynum;
    }

    @Column(name = "totaloperat", length = 20)
    public int getTotaloperat() {
        return totaloperat;
    }

    public void setTotaloperat(int totaloperat) {
        this.totaloperat = totaloperat;
    }

    @Column(name = "passmiles", length = 20, scale = 2, columnDefinition = "bigint default 0")
    public double getPassmiles() {
        return passmiles;
    }

    public void setPassmiles(double passmiles) {
        this.passmiles = passmiles;
    }

    @Column(name = "totalrevenue", length = 20, scale = 2, columnDefinition = "bigint default 0")
    public double getTotalrevenue() {
        return totalrevenue;
    }

    public void setTotalrevenue(double totalrevenue) {
        this.totalrevenue = totalrevenue;
    }

    @Transient
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Transient
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
