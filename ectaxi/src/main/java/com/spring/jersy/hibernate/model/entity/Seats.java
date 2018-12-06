package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 坐席信息列表
 * Created by Administrator on 2016/9/5.
 */
@Entity
@Table(name = "tab_seats")
public class Seats implements Serializable {

    private Integer id;
    private String account;//帐号
    private String name;//坐席人员姓名
    private String seatsnum;//坐席号
    private String extensionnum;//分机号
    private int clientid; //单位id
    private String unit;//公司名称
    private Integer sex;//性别 0：男；1：女
    private String password;//密码
    private String opruser; //用户账号
    private int roleid;//所属权限id
    private int assign;//是否指定派单


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "account", length = 20)
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Column(name = "name", length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "seatsnum", length = 20)
    public String getSeatsnum() {
        return seatsnum;
    }

    public void setSeatsnum(String seatsnum) {
        this.seatsnum = seatsnum;
    }

    @Column(name = "extensionnum", length = 20)
    public String getExtensionnum() {
        return extensionnum;
    }

    public void setExtensionnum(String extensionnum) {
        this.extensionnum = extensionnum;
    }

    @Column(name = "clientid", length = 20)
    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }


    @Column(name = "sex", length = 20)
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Column(name = "password", length = 20)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "opruser", length = 20)
    public String getOpruser() {
        return opruser;
    }

    public void setOpruser(String opruser) {
        this.opruser = opruser;
    }

    @Column(name = "roleid", length = 20, columnDefinition = "INT default 0")
    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    @Transient
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Column(name = "assign", length = 4, columnDefinition = "INT default 0")
    public int getAssign() {
        return assign;
    }

    public void setAssign(int assign) {
        this.assign = assign;
    }

    @Override
    public String toString() {
        return "Seats{" + "id=" + id + ", account='" + account + '\'' + ", name='" + name + '\'' + ", seatsnum='" + seatsnum + '\'' + ", extensionnum='" + extensionnum + '\'' + ", clientid=" + clientid + ", unit='" + unit + '\'' + ", sex=" + sex + ", password='" + password + '\'' + ", opruser='" + opruser + '\'' + ", roleid=" + roleid + '}';
    }
}
