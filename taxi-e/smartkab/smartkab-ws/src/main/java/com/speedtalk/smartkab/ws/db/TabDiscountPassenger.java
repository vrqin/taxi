package com.speedtalk.smartkab.ws.db;

import java.sql.Timestamp;

/**
 * TabDiscountPassenger entity. @author MyEclipse Persistence Tools
 */
public class TabDiscountPassenger implements java.io.Serializable {
    // Fields
    private Integer id;
    private Timestamp endtime;
    private Integer isreceive;
    private Integer isuse;
    private String opruser;
    private Long discid;

    // Constructors

    /**
     * default constructor
     */
    public TabDiscountPassenger() {
    }

    /**
     * full constructor
     */
    public TabDiscountPassenger(Timestamp endtime, Integer isreceive, Integer isuse, String opruser, Long discid) {
        this.endtime = endtime;
        this.isreceive = isreceive;
        this.isuse = isuse;
        this.opruser = opruser;
        this.discid = discid;
    }

    // Property accessors
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getEndtime() {
        return this.endtime;
    }

    public void setEndtime(Timestamp endtime) {
        this.endtime = endtime;
    }

    public Integer getIsreceive() {
        return this.isreceive;
    }

    public void setIsreceive(Integer isreceive) {
        this.isreceive = isreceive;
    }

    public Integer getIsuse() {
        return this.isuse;
    }

    public void setIsuse(Integer isuse) {
        this.isuse = isuse;
    }

    public String getOpruser() {
        return this.opruser;
    }

    public void setOpruser(String opruser) {
        this.opruser = opruser;
    }

    public Long getDiscid() {
        return this.discid;
    }

    public void setDiscid(Long discid) {
        this.discid = discid;
    }
}