package com.spring.jersy.hibernate.publics.bean;

/**
 * Created by Administrator on 2016/10/20.
 */
public class PostrackBean {
    private String oper;
    private String kabnum;
    private int trackcount;
    private String name;
    private String phone;
    private String company;
    private Double lg;
    private Double lt;
    private String gpstime;//gps时间

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public String getKabnum() {
        return kabnum;
    }

    public void setKabnum(String kabnum) {
        this.kabnum = kabnum;
    }

    public int getTrackcount() {
        return trackcount;
    }

    public void setTrackcount(int trackcount) {
        this.trackcount = trackcount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getLg() {
        return lg;
    }

    public void setLg(Double lg) {
        this.lg = lg;
    }

    public Double getLt() {
        return lt;
    }

    public void setLt(Double lt) {
        this.lt = lt;
    }

    public String getGpstime() {
        return gpstime;
    }

    public void setGpstime(String gpstime) {
        this.gpstime = gpstime;
    }
}
