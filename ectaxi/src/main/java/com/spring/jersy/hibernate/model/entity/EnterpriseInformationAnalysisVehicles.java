package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 82.tab_ enterprise_information_analysis_vehicles企业信息分析--车辆总数
 * Created by Administrator on 2016/10/6.
 */
@Entity
@Table(name = "tab_enterprise_information_analysis_vehicles")
public class EnterpriseInformationAnalysisVehicles implements Serializable {
    private int id;
    private String annual;//	varchar(11)			年份
    private int car200;//	int(11)			0-200辆
    private int car500;//	int(11)			201-500辆
    private int car1000;//	int(11)			501-1000辆
    private int car2000;//	int(11)			1001-2000辆
    private int car5000;//	int(11)			2001-5000辆
    private int car5001;//	int(11)			5000以上
    private int cartotal;//	int(11)			合计

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

    @Column(name = "car200", length = 20)
    public int getCar200() {
        return car200;
    }

    public void setCar200(int car200) {
        this.car200 = car200;
    }

    @Column(name = "car500", length = 20)
    public int getCar500() {
        return car500;
    }

    public void setCar500(int car500) {
        this.car500 = car500;
    }

    @Column(name = "car1000", length = 20)
    public int getCar1000() {
        return car1000;
    }

    public void setCar1000(int car1000) {
        this.car1000 = car1000;
    }

    @Column(name = "car2000", length = 20)
    public int getCar2000() {
        return car2000;
    }

    public void setCar2000(int car2000) {
        this.car2000 = car2000;
    }

    @Column(name = "car5000", length = 20)
    public int getCar5000() {
        return car5000;
    }

    public void setCar5000(int car5000) {
        this.car5000 = car5000;
    }

    @Column(name = "car5001", length = 20)
    public int getCar5001() {
        return car5001;
    }

    public void setCar5001(int car5001) {
        this.car5001 = car5001;
    }

    @Column(name = "cartotal", length = 20)
    public int getCartotal() {
        return cartotal;
    }

    public void setCartotal(int cartotal) {
        this.cartotal = cartotal;
    }
}
