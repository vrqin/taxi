package com.spring.jersy.hibernate.model.entity;


import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * tab_discount_coupon
 * Created by sky on 15-8-19
 * <p>
 * 优惠券单
 */
@Entity
@Table(name = "tab_discount_passenger")
public class DiscountPassenger implements Serializable {
    private static final long serialVersionUID = -131312312312321L;

    private Integer id; //id
    private Integer discid; //打车卷id
    private String opruser;//乘客id
    private Integer isreceive;//是否领取 0未领取 1已领取
    private Date endtime;//结束时间
    private Integer isuse;//是否使用 0未使用 1已使用 2失效
    private String token;


    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "discid", length = 20)
    public Integer getDiscid() {
        return discid;
    }

    public void setDiscid(Integer discid) {
        this.discid = discid;
    }

    @Column(name = "opruser", length = 50)
    public String getOpruser() {
        return opruser;
    }

    public void setOpruser(String opruser) {
        this.opruser = opruser;
    }

    @Column(name = "isreceive", length = 4)
    public Integer getIsreceive() {
        return isreceive;
    }

    public void setIsreceive(Integer isreceive) {
        this.isreceive = isreceive;
    }

    @Column(name = "isuse", length = 4)
    public Integer getIsuse() {
        return isuse;
    }

    public void setIsuse(Integer isuse) {
        this.isuse = isuse;
    }


    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "endtime", length = 50)
    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }


    @Transient
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
