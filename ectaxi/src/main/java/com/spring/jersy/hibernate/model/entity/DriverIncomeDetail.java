package com.spring.jersy.hibernate.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * tab_driver_income_detail
 * 司机收入明细
 * Created by Administrator on 2016/9/30.
 */
@Entity
@Table(name = "tab_driver_income_detail")
public class DriverIncomeDetail implements Serializable {
    //    private int id;
    private String name;//	varchar(20)			司机姓名
    private double amount;//	double(20)			收入金额
    private String phone;//	varchar(20)			司机手机号
    private String kabnum;//	varchar(20)			车牌号
    private int successnum;//	int(11)			完成接单次数
    private String date;
    private int clientid;

    //    @Id
    //    @GeneratedValue(strategy = GenerationType.AUTO)
    //    @Column(name = "id", unique = true, nullable = false, length = 11)
    //    public int getId() {
    //        return id;
    //    }
    //
    //    public void setId(int id) {
    //        this.id = id;
    //    }
    @Id
    @Column(name = "name", unique = true, nullable = false, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "amount", length = 20)
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Column(name = "phone", length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "kabnum", length = 20)
    public String getKabnum() {
        return kabnum;
    }

    public void setKabnum(String kabnum) {
        this.kabnum = kabnum;
    }

    @Column(name = "successnum", length = 20)
    public int getSuccessnum() {
        return successnum;
    }

    public void setSuccessnum(int successnum) {
        this.successnum = successnum;
    }

    @Column(name = "date", length = 20)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Column(name = "clientid", length = 20)
    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }
}
