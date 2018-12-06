package com.spring.jersy.hibernate.model.entity;

/**
 * Created by Administrator on 2016/8/9.
 */

import javax.persistence.*;
import java.io.Serializable;

/**
 * 电召单司机和乘客轨迹
 */
@Entity
@Table(name = "tab_send_records")
public class SendRecords implements Serializable {
    private static final long serialVersionUID = -131312312312321L;
    private int id;
    private String ordernum;  //电召单号
    private Driver driver;//司机账号
    private Double lg;//下发订单时司机的经度
    private Double lt;//下发订单时司机的纬度
    private Byte iscarry;//下发订单时司机的状态：0：空载；1：载客

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "ordernum", length = 19)
    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }

    @ManyToOne(optional = true)
    @JoinColumn(name = "driver", referencedColumnName = "msid")
    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Column(name = "lg", length = 20)
    public Double getLg() {
        return lg;
    }

    public void setLg(Double lg) {
        this.lg = lg;
    }

    @Column(name = "lt", length = 20)
    public Double getLt() {
        return lt;
    }

    public void setLt(Double lt) {
        this.lt = lt;
    }

    @Column(name = "iscarry", length = 4)
    public Byte getIscarry() {
        return iscarry;
    }

    public void setIscarry(Byte iscarry) {
        this.iscarry = iscarry;
    }

    @Override
    public String toString() {
        return "SendRecords{" + "id=" + id + ", ordernum='" + ordernum + '\'' + ", driver='" + driver + '\'' + ", lg=" + lg + ", lt=" + lt + ", iscarry=" + iscarry + '}';
    }
}
