package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 92.tab_driver_information_analysis_beendrive驾驶员信息分析---驾龄
 * Created by Administrator on 2016/10/6.
 */
@Entity
@Table(name = "tab_driver_information_analysis_beendrive")
public class DriverInformationAnalysisBeendrive implements Serializable {
    private int id;
    private String annual;//	varchar(11)			年份
    private int year6;//	int(11)			0~6年
    private int year17;//int(11)			7~17年
    private int year28;//	int(11)			18~28年
    private int year39;//	int(11)			29~39年
    private int year40;//	int(11)			40年以上
    private int unknown;//	int(11)			未知
    private int total;//int(11)			合计

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

    @Column(name = "year6", length = 20)
    public int getYear6() {
        return year6;
    }

    public void setYear6(int year6) {
        this.year6 = year6;
    }

    @Column(name = "year17", length = 20)
    public int getYear17() {
        return year17;
    }

    public void setYear17(int year17) {
        this.year17 = year17;
    }

    @Column(name = "year28", length = 20)
    public int getYear28() {
        return year28;
    }

    public void setYear28(int year28) {
        this.year28 = year28;
    }

    @Column(name = "year39", length = 20)
    public int getYear39() {
        return year39;
    }

    public void setYear39(int year39) {
        this.year39 = year39;
    }

    @Column(name = "year40", length = 20)
    public int getYear40() {
        return year40;
    }

    public void setYear40(int year40) {
        this.year40 = year40;
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
