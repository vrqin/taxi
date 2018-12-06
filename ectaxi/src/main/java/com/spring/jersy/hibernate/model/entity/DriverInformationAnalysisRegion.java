package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 90.tab_driver_information_analysis_region驾驶员信息分析---地区
 * Created by Administrator on 2016/10/6.
 */
@Entity
@Table(name = "tab_driver_information_analysis_region")
public class DriverInformationAnalysisRegion implements Serializable {
    private int id;
    private String annual;//	varchar(11)			年份
    private String cities;//	varchar(11)			地市
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

    @Column(name = "cities", length = 20)
    public String getCities() {
        return cities;
    }

    public void setCities(String cities) {
        this.cities = cities;
    }

    @Column(name = "total", length = 20)
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
