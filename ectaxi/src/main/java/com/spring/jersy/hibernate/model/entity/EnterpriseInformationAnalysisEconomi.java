package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * tab_enterprise_information_analysis_economi
 * 81.	tab_enterprise_information_analysis_economi 企业信息分析---经济性质
 * Created by Administrator on 2016/10/6.
 */
@Entity
@Table(name = "tab_enterprise_information_analysis_economi")
public class EnterpriseInformationAnalysisEconomi implements Serializable {
    private int id;
    private String annual;//	varchar(11)			年份
    private int stateowned;//	int(11)			国有全资
    private int collective;//	int(11)			集体全资
    private int sharecooperation;//	int(11)			股份合作
    private int pool;//	int(11)			联营
    private int coltd;//	int(11)			有限责任公司
    private int shareltd;//	int(11)			股份有限公司
    private int privation;//	int(11)			私有
    private int other;//	int(11)			其他
    private int cooperation;//	int(11)			合作

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

    @Column(name = "stateowned", length = 20)
    public int getStateowned() {
        return stateowned;
    }

    public void setStateowned(int stateowned) {
        this.stateowned = stateowned;
    }

    @Column(name = "collective", length = 20)
    public int getCollective() {
        return collective;
    }

    public void setCollective(int collective) {
        this.collective = collective;
    }

    @Column(name = "sharecooperation", length = 20)
    public int getSharecooperation() {
        return sharecooperation;
    }

    public void setSharecooperation(int sharecooperation) {
        this.sharecooperation = sharecooperation;
    }

    @Column(name = "pool", length = 20)
    public int getPool() {
        return pool;
    }

    public void setPool(int pool) {
        this.pool = pool;
    }

    @Column(name = "coltd", length = 20)
    public int getColtd() {
        return coltd;
    }

    public void setColtd(int coltd) {
        this.coltd = coltd;
    }

    @Column(name = "shareltd", length = 20)
    public int getShareltd() {
        return shareltd;
    }

    public void setShareltd(int shareltd) {
        this.shareltd = shareltd;
    }

    @Column(name = "privation", length = 20)
    public int getPrivation() {
        return privation;
    }

    public void setPrivation(int privation) {
        this.privation = privation;
    }

    @Column(name = "other", length = 20)
    public int getOther() {
        return other;
    }

    public void setOther(int other) {
        this.other = other;
    }

    @Column(name = "cooperation", length = 20)
    public int getCooperation() {
        return cooperation;
    }

    public void setCooperation(int cooperation) {
        this.cooperation = cooperation;
    }
}
