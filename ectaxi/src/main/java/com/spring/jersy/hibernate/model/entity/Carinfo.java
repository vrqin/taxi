package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 车辆管理
 * Created by Administrator on 2016/9/29.
 */
@Entity
@Table(name = "tab_carinfo")
public class Carinfo implements Serializable {

    private int id;
    private String kabnum;  //车牌号码
    private String company;  //所属公司
    private int clientid;//所属公司id
    private String unit;  //所属单位
    private String terminalid;  //终端编号
    private String simcard;  //SIM卡号
    private Date installtime;  //安装日期
    private String transportid;  //运输证号
    private Date transporttime;  //运输证有效期
    private int schedule;  //排班

    private String vehicleid;//    行驶证
    private Double mileage;//  里程
    private String models; //    车型
    private Double displacement;//  排量
    private Date yearcareful;//    年审
    private String type;     //    类型
    private String carPic;   //车辆图片
    private String vehPic;   //行驶证图片
    private int carcount;
    private String devIdno;   //视频设备号
    private Set<Driver> driverHashSet = new HashSet<Driver>();   //车辆对应的司机

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "kabnum", length = 20)
    public String getKabnum() {
        return kabnum;
    }

    public void setKabnum(String kabnum) {
        this.kabnum = kabnum;
    }

    @Column(name = "company", length = 50)
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Column(name = "unit", length = 50)
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Column(name = "terminalid", length = 20)
    public String getTerminalid() {
        return terminalid;
    }

    public void setTerminalid(String terminalid) {
        this.terminalid = terminalid;
    }

    @Column(name = "simcard", length = 20)
    public String getSimcard() {
        return simcard;
    }

    public void setSimcard(String simcard) {
        this.simcard = simcard;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "installtime", length = 50)
    public Date getInstalltime() {
        return installtime;
    }

    public void setInstalltime(Date installtime) {
        this.installtime = installtime;
    }

    @Column(name = "transportid", length = 20)
    public String getTransportid() {
        return transportid;
    }

    public void setTransportid(String transportid) {
        this.transportid = transportid;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "transporttime", length = 50)
    public Date getTransporttime() {
        return transporttime;
    }

    public void setTransporttime(Date transporttime) {
        this.transporttime = transporttime;
    }

    @Column(name = "schedule", length = 4)
    public int getSchedule() {
        return schedule;
    }

    public void setSchedule(int schedule) {
        this.schedule = schedule;
    }

    @Column(name = "vehicleid", length = 20)
    public String getVehicleid() {
        return vehicleid;
    }

    public void setVehicleid(String vehicleid) {
        this.vehicleid = vehicleid;
    }

    @Column(name = "mileage", length = 20)
    public Double getMileage() {
        return mileage;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
    }

    @Column(name = "models", length = 20)
    public String getModels() {
        return models;
    }

    public void setModels(String models) {
        this.models = models;
    }

    @Column(name = "displacement", length = 20)
    public Double getDisplacement() {
        return displacement;
    }

    public void setDisplacement(Double displacement) {
        this.displacement = displacement;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "yearcareful", length = 50)
    public Date getYearcareful() {
        return yearcareful;
    }

    public void setYearcareful(Date yearcareful) {
        this.yearcareful = yearcareful;
    }

    @Column(name = "type", length = 20)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "carPic", length = 255)
    public String getCarPic() {
        return carPic;
    }

    public void setCarPic(String carPic) {
        this.carPic = carPic;
    }

    @Column(name = "clientid", length = 20)
    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    @Column(name = "devIdno", length = 20)
    public String getDevIdno() {
        return devIdno;
    }

    public void setDevIdno(String devIdno) {
        this.devIdno = devIdno;
    }

    //
    //    @ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE},fetch = FetchType.EAGER)
    //    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    //    @JoinTable(
    ////      设置中间表名
    //            name="tab_carinfo_driver",
    ////      指定当前对象的外键,本表在中间表的外键名称
    //            joinColumns={@JoinColumn(name="id",referencedColumnName="id")},
    ////      指定关联对象的外键,另一个表在中间表的外键名称。
    //            inverseJoinColumns={@JoinColumn(name="driverid",referencedColumnName="id")}
    //    )

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER, mappedBy = "carinfo")
    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    public Set<Driver> getDriverHashSet() {
        return driverHashSet;
    }

    public void setDriverHashSet(Set<Driver> driverHashSet) {
        this.driverHashSet = driverHashSet;
    }


    @Transient
    public int getCarcount() {
        return carcount;
    }

    public void setCarcount(int carcount) {
        this.carcount = carcount;
    }

    @Column(name = "vehPic", length = 255)
    public String getVehPic() {
        return vehPic;
    }

    public void setVehPic(String vehPic) {
        this.vehPic = vehPic;
    }

    @Override
    public String toString() {
        return "Carinfo{" + "id=" + id + ", kabnum='" + kabnum + '\'' + ", company='" + company + '\'' + ", clientid=" + clientid + ", unit='" + unit + '\'' + ", terminalid='" + terminalid + '\'' + ", simcard='" + simcard + '\'' + ", installtime=" + installtime + ", transportid='" + transportid + '\'' + ", transporttime=" + transporttime + ", schedule=" + schedule + ", vehicleid='" + vehicleid + '\'' + ", mileage=" + mileage + ", models='" + models + '\'' + ", displacement='" + displacement + '\'' + ", yearcareful=" + yearcareful + ", type='" + type + '\'' + ", carPic='" + carPic + '\'' + ", vehPic='" + vehPic + '\'' + ", carcount=" + carcount + ", driverHashSet=" + driverHashSet + '}';
    }
}
