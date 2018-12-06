package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 54.	tab_driver_ser_statis服务评价统计信息表
 * Created by Administrator on 2016/10/6.
 */
@Entity
@Table(name = "tab_driver_ser_statis")
public class DriverSerStatis implements Serializable {
    //    private int id;
    private String account;//	varchar(20)			驾驶员姓名
    private String kabnum;//	varchar(20)			车牌号
    private int evaluationnum;//	int(11)			评价次数
    private int starnum_5;//	int(11)			5星次数
    private int starnum_4;//	int(11)			4星次数
    private int starnum_3;//	int(11)			3星次数
    private int starnum_2;//	int(11)			2星次数
    private int starnum_1;//	int(11)			1星次数
    private int nostarnum;//	int(11)			未评价次数
    private int clientid;
    private String msid;
    private String drivername;
    private String company;

    @Id
    @Column(name = "account", unique = true, nullable = false, length = 20)
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Column(name = "kabnum", length = 20)
    public String getKabnum() {
        return kabnum;
    }

    public void setKabnum(String kabnum) {
        this.kabnum = kabnum;
    }

    @Column(name = "evaluationnum", length = 20)
    public int getEvaluationnum() {
        return evaluationnum;
    }

    public void setEvaluationnum(int evaluationnum) {
        this.evaluationnum = evaluationnum;
    }

    @Column(name = "starnum_5", length = 20)
    public int getStarnum_5() {
        return starnum_5;
    }

    public void setStarnum_5(int starnum_5) {
        this.starnum_5 = starnum_5;
    }

    @Column(name = "starnum_4", length = 20)
    public int getStarnum_4() {
        return starnum_4;
    }

    public void setStarnum_4(int starnum_4) {
        this.starnum_4 = starnum_4;
    }

    @Column(name = "starnum_3", length = 20)
    public int getStarnum_3() {
        return starnum_3;
    }

    public void setStarnum_3(int starnum_3) {
        this.starnum_3 = starnum_3;
    }

    @Column(name = "starnum_2", length = 20)
    public int getStarnum_2() {
        return starnum_2;
    }

    public void setStarnum_2(int starnum_2) {
        this.starnum_2 = starnum_2;
    }

    @Column(name = "starnum_1", length = 20)
    public int getStarnum_1() {
        return starnum_1;
    }

    public void setStarnum_1(int starnum_1) {
        this.starnum_1 = starnum_1;
    }

    @Column(name = "nostarnum", length = 20)
    public int getNostarnum() {
        return nostarnum;
    }

    public void setNostarnum(int nostarnum) {
        this.nostarnum = nostarnum;
    }

    @Column(name = "clientid", length = 20)

    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    @Column(name = "msid", length = 20)
    public String getMsid() {
        return msid;
    }

    public void setMsid(String msid) {
        this.msid = msid;
    }

    @Column(name = "drivername", length = 20)
    public String getDrivername() {
        return drivername;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername;
    }

    @Transient
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
