package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 消息通知历史
 * 系统发消息给指定司机
 * Created by Administrator on 2016/9/5.
 */
@Entity
@Table(name = "tab_notifier_history")
public class NotifierPlusHistory implements Serializable {
    private Integer id;
    private Integer notifierid;//消息id
    private Integer dirverid;//司机id
    private Integer status;    //状态  0:未发送  1:已发送 2:无效
    private Date creattime; //发布时间
    private Integer clientid;
    private String drivername;
    private String phone;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "sendtime", length = 50)
    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    @Column(name = "status", length = 4, columnDefinition = "INT default 0")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column(name = "notifierid", length = 20)
    public Integer getNotifierid() {
        return notifierid;
    }

    public void setNotifierid(Integer notifierid) {
        this.notifierid = notifierid;
    }

    @Column(name = "driverid", length = 20)
    public Integer getDirverid() {
        return dirverid;
    }

    public void setDirverid(Integer dirverid) {
        this.dirverid = dirverid;
    }

    @Column(name = "clientid", length = 20)
    public Integer getClientid() {
        return clientid;
    }

    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }

    @Transient
    public String getDrivername() {
        return drivername;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername;
    }

    @Transient
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
