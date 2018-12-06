package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 84.tab_enterprise_information_analysis_funds企业信息分析--资金规模
 * Created by Administrator on 2016/10/6.
 */
@Entity
@Table(name = "tab_enterprise_information_analysis_funds")
public class EnterpriseInformationAnalysisFunds implements Serializable {
    private int id;
    private String annual;//	varchar(11)			年份
    private double wan100;//	double(11)			0-100万
    private double wan500;//	double(11)			101-500万
    private double wan1000;//	double(11)			501-1000万
    private double wan2000;//	double(11)			1001-2000万
    private double wan5000;//	double(11)			2001-5000万
    private double wan10000;//	double(11)			5001-10000万
    private double wan15000;//	double(11)			10001-15000万
    private double wan20000;//	double(11)			15001-20000万
    private double wan20001;//	double(11)			20000万以上
    private double wantotal;//	double(20)			合作

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

    @Column(name = "wan100", length = 20)
    public double getWan100() {
        return wan100;
    }

    public void setWan100(double wan100) {
        this.wan100 = wan100;
    }

    @Column(name = "wan500", length = 20)
    public double getWan500() {
        return wan500;
    }

    public void setWan500(double wan500) {
        this.wan500 = wan500;
    }

    @Column(name = "wan1000", length = 20)
    public double getWan1000() {
        return wan1000;
    }

    public void setWan1000(double wan1000) {
        this.wan1000 = wan1000;
    }

    @Column(name = "wan2000", length = 20)
    public double getWan2000() {
        return wan2000;
    }

    public void setWan2000(double wan2000) {
        this.wan2000 = wan2000;
    }

    @Column(name = "wan5000", length = 20)
    public double getWan5000() {
        return wan5000;
    }

    public void setWan5000(double wan5000) {
        this.wan5000 = wan5000;
    }

    @Column(name = "wan10000", length = 20)
    public double getWan10000() {
        return wan10000;
    }

    public void setWan10000(double wan10000) {
        this.wan10000 = wan10000;
    }

    @Column(name = "wan15000", length = 20)
    public double getWan15000() {
        return wan15000;
    }

    public void setWan15000(double wan15000) {
        this.wan15000 = wan15000;
    }

    @Column(name = "wan20000", length = 20)
    public double getWan20000() {
        return wan20000;
    }

    public void setWan20000(double wan20000) {
        this.wan20000 = wan20000;
    }

    @Column(name = "wan20001", length = 20)
    public double getWan20001() {
        return wan20001;
    }

    public void setWan20001(double wan20001) {
        this.wan20001 = wan20001;
    }

    @Column(name = "wantotal", length = 20)
    public double getWantotal() {
        return wantotal;
    }

    public void setWantotal(double wantotal) {
        this.wantotal = wantotal;
    }
}
