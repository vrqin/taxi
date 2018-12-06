package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/9/11.
 */
@Entity
@Table(name = "tab_driver_vio_deltails")
public class DriverVioDeltails implements Serializable {

    private Integer id;
    private String name;//驾驶员姓名
    private String kabnum;//车牌号
    private Integer type;//违规类型
    private Date viotime;//违规时间
    private String detailed;//详细

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name", length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "kabnum", length = 20)
    public String getKabnum() {
        return kabnum;
    }

    public void setKabnum(String kabnum) {
        this.kabnum = kabnum;
    }

    @Column(name = "type", length = 20)
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "viotime", length = 50)
    public Date getViotime() {
        return viotime;
    }

    public void setViotime(Date viotime) {
        this.viotime = viotime;
    }

    @Column(name = "detailed", length = 20)
    public String getDetailed() {
        return detailed;
    }

    public void setDetailed(String detailed) {
        this.detailed = detailed;
    }
}
