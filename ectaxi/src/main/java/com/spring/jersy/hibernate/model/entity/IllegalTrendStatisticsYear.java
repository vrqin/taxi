package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 172.tab_illegal_trend_statistics_year违章趋势统计-年度
 * <p>
 * Created by Administrator on 2016/10/7.
 */
@Entity
@Table(name = "tab_illegal_trend_statistics_year")
public class IllegalTrendStatisticsYear implements Serializable {
    private int id;
    private String annual;//	varchar(11)			年份
    private int scrapcar;//	int(11)			报废车辆
    private int notcheckcar;//	int(11)			未年检车辆
    private int withoutcar;//	int(11)			未年审车辆
    private int deckcar;//	int(11)			套牌车辆
    private int blackcar;//	int(11)			黑的
    private int other;//	int(11)			其它
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

    @Column(name = "scrapcar", length = 20)
    public int getScrapcar() {
        return scrapcar;
    }

    public void setScrapcar(int scrapcar) {
        this.scrapcar = scrapcar;
    }

    @Column(name = "notcheckcar", length = 20)
    public int getNotcheckcar() {
        return notcheckcar;
    }

    public void setNotcheckcar(int notcheckcar) {
        this.notcheckcar = notcheckcar;
    }

    @Column(name = "withoutcar", length = 20)
    public int getWithoutcar() {
        return withoutcar;
    }

    public void setWithoutcar(int withoutcar) {
        this.withoutcar = withoutcar;
    }

    @Column(name = "deckcar", length = 20)
    public int getDeckcar() {
        return deckcar;
    }

    public void setDeckcar(int deckcar) {
        this.deckcar = deckcar;
    }

    @Column(name = "blackcar", length = 20)
    public int getBlackcar() {
        return blackcar;
    }

    public void setBlackcar(int blackcar) {
        this.blackcar = blackcar;
    }

    @Column(name = "other", length = 20)
    public int getOther() {
        return other;
    }

    public void setOther(int other) {
        this.other = other;
    }

    @Column(name = "combined", length = 20)
    public int getCombined() {
        return combined;
    }

    public void setCombined(int combined) {
        this.combined = combined;
    }
}
