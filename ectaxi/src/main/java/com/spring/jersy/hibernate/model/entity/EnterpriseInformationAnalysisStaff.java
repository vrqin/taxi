package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 83.tab_enterprise_information_analysis_staff企业信息分析--人员规模
 * Created by Administrator on 2016/10/6.
 */
@Entity
@Table(name = "tab_enterprise_information_analysis_staff")
public class EnterpriseInformationAnalysisStaff implements Serializable {
    private int id;
    private String annual;//	varchar(11)			年份
    private int peop200;//	int(11)			0-200人
    private int peop500;//	int(11)			201-500人
    private int peop1000;//	int(11)			501-1000人
    private int peop2000;//	int(11)			1001-2000人
    private int peop5000;//	int(11)			2001-5000人
    private int peop5001;//	int(11)			5000人以上
    private int peoptotal;//	int(11)			合计

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

    @Column(name = "peop200", length = 20)
    public int getPeop200() {
        return peop200;
    }

    public void setPeop200(int peop200) {
        this.peop200 = peop200;
    }

    @Column(name = "peop500", length = 20)
    public int getPeop500() {
        return peop500;
    }

    public void setPeop500(int peop500) {
        this.peop500 = peop500;
    }

    @Column(name = "peop1000", length = 20)
    public int getPeop1000() {
        return peop1000;
    }

    public void setPeop1000(int peop1000) {
        this.peop1000 = peop1000;
    }

    @Column(name = "peop2000", length = 20)
    public int getPeop2000() {
        return peop2000;
    }

    public void setPeop2000(int peop2000) {
        this.peop2000 = peop2000;
    }

    @Column(name = "peop5000", length = 20)
    public int getPeop5000() {
        return peop5000;
    }

    public void setPeop5000(int peop5000) {
        this.peop5000 = peop5000;
    }

    @Column(name = "peop5001", length = 20)
    public int getPeop5001() {
        return peop5001;
    }

    public void setPeop5001(int peop5001) {
        this.peop5001 = peop5001;
    }

    @Column(name = "peoptotal", length = 20)
    public int getPeoptotal() {
        return peoptotal;
    }

    public void setPeoptotal(int peoptotal) {
        this.peoptotal = peoptotal;
    }
}
