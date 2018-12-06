package com.spring.jersy.hibernate.publics.bean;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/12/14.
 */
public class ResourceBean {
    private int id;                                     //id,自增
    private String powerName;                           //资源名称
    private String powerUrl;                            //资源地址
    private Date registerTime;
    private String powerRemark;
    private Integer pid;                                //父资源id
    private Integer ppid;                                //属于那个系统
    private Integer type;                               //资源类型
    private String iconCls;                             //界面图标样式
    private String PiconCls;
    private List<ResourceBean> children = null;
    private String state;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }

    public String getPowerUrl() {
        return powerUrl;
    }

    public void setPowerUrl(String powerUrl) {
        this.powerUrl = powerUrl;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public String getPowerRemark() {
        return powerRemark;
    }

    public void setPowerRemark(String powerRemark) {
        this.powerRemark = powerRemark;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getPpid() {
        return ppid;
    }

    public void setPpid(Integer ppid) {
        this.ppid = ppid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getPiconCls() {
        return PiconCls;
    }

    public void setPiconCls(String piconCls) {
        PiconCls = piconCls;
    }

    public List<ResourceBean> getChildren() {
        return children;
    }

    public void setChildren(List<ResourceBean> children) {
        this.children = children;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
