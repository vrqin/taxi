package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 88.tab_car_information_analysis_models车辆信息分析---车型
 * Created by Administrator on 2016/10/6.
 */
@Entity
@Table(name = "tab_car_information_analysis_models")
public class CarInformationAnalysisModels implements Serializable {
    private int id;
    private int minicar;//	int(11)			微型轿车
    private int regularcars;//	int(11)			普通级轿车
    private int intermediatesedan;//	int(11)			中级轿车
    private int seniorcar;//	int(11)			中高级轿车
    private int limousine;//	int(11)			高级轿车
    private int minivans;//	int(11)			微型客车
    private int lightbus;//	int(11)			轻型客车
    private int mediumsizedcoach;//	int(11)			中型客车
    private int buses;//	int(11)			大型客车
    private int other;//	int(11)			其他
    private int combined;//	int(11)			合计
    private String annual;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "minicar", length = 20)
    public int getMinicar() {
        return minicar;
    }

    public void setMinicar(int minicar) {
        this.minicar = minicar;
    }

    @Column(name = "regularcars", length = 20)
    public int getRegularcars() {
        return regularcars;
    }

    public void setRegularcars(int regularcars) {
        this.regularcars = regularcars;
    }

    @Column(name = "intermediatesedan", length = 20)
    public int getIntermediatesedan() {
        return intermediatesedan;
    }

    public void setIntermediatesedan(int intermediatesedan) {
        this.intermediatesedan = intermediatesedan;
    }

    @Column(name = "seniorcar", length = 20)
    public int getSeniorcar() {
        return seniorcar;
    }

    public void setSeniorcar(int seniorcar) {
        this.seniorcar = seniorcar;
    }

    @Column(name = "limousine", length = 20)
    public int getLimousine() {
        return limousine;
    }

    public void setLimousine(int limousine) {
        this.limousine = limousine;
    }

    @Column(name = "minivans", length = 20)
    public int getMinivans() {
        return minivans;
    }

    public void setMinivans(int minivans) {
        this.minivans = minivans;
    }

    @Column(name = "lightbus", length = 20)
    public int getLightbus() {
        return lightbus;
    }

    public void setLightbus(int lightbus) {
        this.lightbus = lightbus;
    }

    @Column(name = "mediumsizedcoach", length = 20)
    public int getMediumsizedcoach() {
        return mediumsizedcoach;
    }

    public void setMediumsizedcoach(int mediumsizedcoach) {
        this.mediumsizedcoach = mediumsizedcoach;
    }

    @Column(name = "buses", length = 20)
    public int getBuses() {
        return buses;
    }

    public void setBuses(int buses) {
        this.buses = buses;
    }

    @Column(name = "other", length = 20)
    public int getOther() {
        return other;
    }

    public void setOther(int other) {
        this.other = other;
    }

    @Column(name = "combined", length = 20)
    public int getCombined() {
        return combined;
    }

    public void setCombined(int combined) {
        this.combined = combined;
    }

    @Column(name = "annual", length = 20)
    public String getAnnual() {

        return annual;
    }

    public void setAnnual(String annual) {
        this.annual = annual;
    }
}
