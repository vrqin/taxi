package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 93.tab_driver_information_analysis_creditrate
 * 驾驶员信息分析---信誉等级
 * Created by Administrator on 2016/10/6.
 */
@Entity
@Table(name = "tab_driver_information_analysis_creditrate")
public class DriverInformationAnalysisCreditrate implements Serializable {
    private int id;
    private String annual;//	varchar(11)			年份
    private int good;//	int(11)			优良（AAA）
    private int qualified;//	int(11)			合格（AA）
    private int basic;//	int(11)			基本合格（A）
    private int unqualified;//	int(11)			不合格（B）
    private int inspection;//	int(11)			无
    private int cooperation;//	int(11)			合计

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

    @Column(name = "good", length = 20)
    public int getGood() {
        return good;
    }

    public void setGood(int good) {
        this.good = good;
    }

    @Column(name = "qualified", length = 20)
    public int getQualified() {
        return qualified;
    }

    public void setQualified(int qualified) {
        this.qualified = qualified;
    }

    @Column(name = "basic", length = 20)
    public int getBasic() {
        return basic;
    }

    public void setBasic(int basic) {
        this.basic = basic;
    }

    @Column(name = "unqualified", length = 20)
    public int getUnqualified() {
        return unqualified;
    }

    public void setUnqualified(int unqualified) {
        this.unqualified = unqualified;
    }

    @Column(name = "inspection", length = 20)
    public int getInspection() {
        return inspection;
    }

    public void setInspection(int inspection) {
        this.inspection = inspection;
    }

    @Column(name = "cooperation", length = 20)
    public int getCooperation() {
        return cooperation;
    }

    public void setCooperation(int cooperation) {
        this.cooperation = cooperation;
    }
}
