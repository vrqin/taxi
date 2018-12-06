package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 实时统计数据
 * Created by Administrator on 2016/8/10.
 */
@Entity
@Table(name = "tab_order_snapshot")
public class OrderSnapshot implements Serializable {

    private static final long serialVersionUID = -131312312312321L;
    private int id;
    private int online; //在线司机数
    private int waithandle;//等待处理数
    private int handing;//处理中数量
    private Date time;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "online", length = 11)
    public int getOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
    }

    @Column(name = "waithandle", length = 11)
    public int getWaithandle() {
        return waithandle;
    }

    public void setWaithandle(int waithandle) {
        this.waithandle = waithandle;
    }

    @Column(name = "handling", length = 11)
    public int getHanding() {
        return handing;
    }

    public void setHanding(int handing) {
        this.handing = handing;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "time", length = 50)
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "OrderSnapshot{" + "id=" + id + ", online=" + online + ", waithandle=" + waithandle + ", handing=" + handing + ", time=" + time + '}';
    }
}
