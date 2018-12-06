package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 89.tab_ car_information_analysis_validittime车辆信息分析---使用年限
 * Created by Administrator on 2016/10/6.
 */
@Entity
@Table(name = "tab_car_information_analysis_validittime")
public class CarInformationAnalysisValidittime implements Serializable {
    private int id;
    private String annual;//	varchar(11)			年份
    private int year1;//	int(11)			1年
    private int year2;//	int(11)			2年
    private int year3;//	int(11)			3年
    private int year4;//	int(11)			4年
    private int year5;//	int(11)			5年
    private int year6;//	int(11)			6年
    private int year7;//	int(11)			7年
    private int year8;//	int(11)			8年
    private int unknown;//	int(11)			未知
    private int total;//	int(11)			合计

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

    @Column(name = "year1", length = 20)
    public int getYear1() {
        return year1;
    }

    public void setYear1(int year1) {
        this.year1 = year1;
    }

    @Column(name = "year2", length = 20)
    public int getYear2() {
        return year2;
    }

    public void setYear2(int year2) {
        this.year2 = year2;
    }

    @Column(name = "year3", length = 20)
    public int getYear3() {
        return year3;
    }

    public void setYear3(int year3) {
        this.year3 = year3;
    }

    @Column(name = "year4", length = 20)
    public int getYear4() {
        return year4;
    }

    public void setYear4(int year4) {
        this.year4 = year4;
    }

    @Column(name = "year5", length = 20)
    public int getYear5() {
        return year5;
    }

    public void setYear5(int year5) {
        this.year5 = year5;
    }

    @Column(name = "year6", length = 20)
    public int getYear6() {
        return year6;
    }

    public void setYear6(int year6) {
        this.year6 = year6;
    }

    @Column(name = "year7", length = 20)
    public int getYear7() {
        return year7;
    }

    public void setYear7(int year7) {
        this.year7 = year7;
    }

    @Column(name = "year8", length = 20)
    public int getYear8() {
        return year8;
    }

    public void setYear8(int year8) {
        this.year8 = year8;
    }

    @Column(name = "unknown", length = 20)
    public int getUnknown() {
        return unknown;
    }

    public void setUnknown(int unknown) {
        this.unknown = unknown;
    }

    @Column(name = "total", length = 20)
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
