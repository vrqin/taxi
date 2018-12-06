package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 电召单司机和乘客轨迹
 */
@Entity
@Table(name = "tab_pos_of_order_track")
public class Postrack implements Serializable {
    private static final long serialVersionUID = -131312312312321L;

    private int id;
    private String orderid; //电召单号
    private String oper; //操作者
    private int opertype;//操作者类型：0：乘客；1：司机
    private String kabnum;//车牌号
    private Double lg;
    private Double lt;
    private Date gpstime;//gps时间
    private Date time;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 20)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "orderid", length = 19)
    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    @Column(name = "oper", length = 20)
    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    @Column(name = "opertype", length = 1)
    public int getOpertype() {
        return opertype;
    }

    public void setOpertype(int opertype) {
        this.opertype = opertype;
    }

    @Column(name = "kabnum", length = 20)
    public String getKabnum() {
        return kabnum;
    }

    public void setKabnum(String kabnum) {
        this.kabnum = kabnum;
    }


    @Column(name = "lg", length = 10)
    public Double getLg() {
        return lg;
    }

    public void setLg(Double lg) {
        this.lg = lg;
    }

    @Column(name = "lt", length = 10)

    public Double getLt() {
        return lt;
    }

    public void setLt(Double lt) {
        this.lt = lt;
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

    @Transactional
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
