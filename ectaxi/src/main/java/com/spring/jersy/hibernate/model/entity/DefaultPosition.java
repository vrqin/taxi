package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 默认经纬度
 * Created by Administrator on 2016/7/6.
 */
@Entity
@Table(name = "tab_default_position")
public class DefaultPosition implements Serializable {
    private int id;
    private int ssid;
    private Double deflg;//默认经度
    private Double deflt;//默认纬度
    private int layer;//图层
    private Date gpstime;//上传定位的时间
    private int userId;//用户id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "ssid", length = 11)
    public int getSsid() {
        return ssid;
    }

    public void setSsid(int ssid) {
        this.ssid = ssid;
    }

    @Column(name = "deflg", length = 20)
    public Double getDeflg() {
        return deflg;
    }

    public void setDeflg(Double deflg) {
        this.deflg = deflg;
    }

    @Column(name = "deflt", length = 20)
    public Double getDeflt() {
        return deflt;
    }

    public void setDeflt(Double deflt) {
        this.deflt = deflt;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gpstime", length = 50)
    public Date getGpstime() {
        return gpstime;
    }

    public void setGpstime(Date gpstime) {
        this.gpstime = gpstime;
    }

    @Column(name = "layer", length = 4)
    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }


    @Column(name = "userid", length = 11)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
