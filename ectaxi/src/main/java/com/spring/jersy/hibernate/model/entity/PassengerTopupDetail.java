package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 174.tab_passenger_topup_detail乘客充值明细
 * Created by Administrator on 2016/10/7.
 */
@Entity
@Table(name = "tab_passenger_topup_detail")
public class PassengerTopupDetail implements Serializable {
    private int id;
    private String phone;//	varchar(20)			手机号码
    private String name;//	varchar(20)			乘客姓名
    private double money;//	double(20)			充值金额
    private Date topuptime;//	datetime			充值时间
    private int stute;//	int(4)			支付状态
    private int type;//	int(4)			充值方式

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "phone", length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "name", length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "money", length = 20)
    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "topuptime", length = 50)
    public Date getTopuptime() {
        return topuptime;
    }

    public void setTopuptime(Date topuptime) {
        this.topuptime = topuptime;
    }

    @Column(name = "stute", length = 20)
    public int getStute() {
        return stute;
    }

    public void setStute(int stute) {
        this.stute = stute;
    }

    @Column(name = "type", length = 4)
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
