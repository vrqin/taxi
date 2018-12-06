package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 87.tab_car_information_analysis_fueltype车辆信息分析---燃油类型
 * Created by Administrator on 2016/10/6.
 */
@Entity
@Table(name = "tab_car_information_analysis_fueltype")
public class CarInformationAnalysisFueltype implements Serializable {
    private int id;
    private String annual;//	varchar(11)			年份
    private int gasoline;//	int(11)			汽油
    private int diesel;//	int(11)			柴油
    private int gas;//	int(11)			天然气
    private int electric;//	int(11)			电力
    private int hybrid;//	int(11)			混合动力
    private int unknown;//	int(11)			未知
    private int combined;//	int(11)			合计

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

    @Column(name = "gasoline", length = 20)
    public int getGasoline() {
        return gasoline;
    }

    public void setGasoline(int gasoline) {
        this.gasoline = gasoline;
    }

    @Column(name = "diesel", length = 20)
    public int getDiesel() {
        return diesel;
    }

    public void setDiesel(int diesel) {
        this.diesel = diesel;
    }

    @Column(name = "gas", length = 20)
    public int getGas() {
        return gas;
    }

    public void setGas(int gas) {
        this.gas = gas;
    }

    @Column(name = "electric", length = 20)
    public int getElectric() {
        return electric;
    }

    public void setElectric(int electric) {
        this.electric = electric;
    }

    @Column(name = "hybrid", length = 20)
    public int getHybrid() {
        return hybrid;
    }

    public void setHybrid(int hybrid) {
        this.hybrid = hybrid;
    }

    @Column(name = "unknown", length = 20)
    public int getUnknown() {
        return unknown;
    }

    public void setUnknown(int unknown) {
        this.unknown = unknown;
    }

    @Column(name = "combined", length = 20)
    public int getCombined() {
        return combined;
    }

    public void setCombined(int combined) {
        this.combined = combined;
    }
}
