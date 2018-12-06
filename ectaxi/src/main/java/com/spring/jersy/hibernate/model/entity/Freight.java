package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * tab_freight
 * 运价信息表
 * Created by Administrator on 2016/10/1.
 */
@Entity
@Table(name = "tab_freight")
public class Freight implements Serializable {
    private int id;
    private String regional;//	varchar(20)			执行区域
    private String description;//		varchar(20)			运价类型描述
    private String validitime;//		datatime			有效期起始时间
    private double startmileage;//		double(11)			运营起步里程数
    private double fuelsurcharge;//燃油附加费
    private double parking;//停车计费
    private String diurnalstartfare;//夜间运营起始时间
    private double diurnalstar;//夜间运营结束时间
    private double nightstar;//昼间起步价
    private String diurnalendfare;//夜间起步价
    private double diurnalprice;//昼间单价
    private double nightprice;//夜间单价
    private double singlepremium;//单程加价公里
    private double diurnalsingle;//昼间单程单价
    private double nightsingle;//夜间单程单价
    private double freightswitch;//运价切换速度
    private int islowspeedwait;//是否低速等待
    private int state;//运价状态
    private String token;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "regionals", length = 20)
    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    @Column(name = "descriptions", length = 20)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "validitime", length = 20)
    public String getValiditime() {
        return validitime;
    }

    public void setValiditime(String validitime) {
        this.validitime = validitime;
    }

    @Column(name = "startmileage", length = 20)
    public double getStartmileage() {
        return startmileage;
    }

    public void setStartmileage(double startmileage) {
        this.startmileage = startmileage;
    }

    @Column(name = "fuelsurcharge", length = 20)
    public double getFuelsurcharge() {
        return fuelsurcharge;
    }

    public void setFuelsurcharge(double fuelsurcharge) {
        this.fuelsurcharge = fuelsurcharge;
    }

    @Column(name = "parking", length = 20)
    public double getParking() {
        return parking;
    }

    public void setParking(double parking) {
        this.parking = parking;
    }

    @Column(name = "diurnalstartfare", length = 20)
    public String getDiurnalstartfare() {
        return diurnalstartfare;
    }

    public void setDiurnalstartfare(String diurnalstartfare) {
        this.diurnalstartfare = diurnalstartfare;
    }

    @Column(name = "diurnalstar", length = 20)
    public double getDiurnalstar() {
        return diurnalstar;
    }

    public void setDiurnalstar(double diurnalstar) {
        this.diurnalstar = diurnalstar;
    }

    @Column(name = "nightstar", length = 20)
    public double getNightstar() {
        return nightstar;
    }

    public void setNightstar(double nightstar) {
        this.nightstar = nightstar;
    }

    @Column(name = "diurnalendfare", length = 20)
    public String getDiurnalendfare() {
        return diurnalendfare;
    }

    public void setDiurnalendfare(String diurnalendfare) {
        this.diurnalendfare = diurnalendfare;
    }

    @Column(name = "diurnalprice", length = 20)
    public double getDiurnalprice() {
        return diurnalprice;
    }

    public void setDiurnalprice(double diurnalprice) {
        this.diurnalprice = diurnalprice;
    }

    @Column(name = "nightprice", length = 20)
    public double getNightprice() {
        return nightprice;
    }

    public void setNightprice(double nightprice) {
        this.nightprice = nightprice;
    }

    @Column(name = "singlepremium", length = 20)
    public double getSinglepremium() {
        return singlepremium;
    }

    public void setSinglepremium(double singlepremium) {
        this.singlepremium = singlepremium;
    }

    @Column(name = "diurnalsingle", length = 20)
    public double getDiurnalsingle() {
        return diurnalsingle;
    }

    public void setDiurnalsingle(double diurnalsingle) {
        this.diurnalsingle = diurnalsingle;
    }

    @Column(name = "nightsingle", length = 20)
    public double getNightsingle() {
        return nightsingle;
    }

    public void setNightsingle(double nightsingle) {
        this.nightsingle = nightsingle;
    }

    @Column(name = "freightswitch", length = 20)
    public double getFreightswitch() {
        return freightswitch;
    }

    public void setFreightswitch(double freightswitch) {
        this.freightswitch = freightswitch;
    }

    @Column(name = "islowspeedwait", length = 2)
    public int getIslowspeedwait() {
        return islowspeedwait;
    }

    public void setIslowspeedwait(int islowspeedwait) {
        this.islowspeedwait = islowspeedwait;
    }

    @Column(name = "state", length = 2)
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Transient
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
