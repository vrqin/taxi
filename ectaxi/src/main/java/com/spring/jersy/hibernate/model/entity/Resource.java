package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Administrator on 2016/12/13.
 */
@Entity
@Table(name = "tab_resource")
public class Resource implements Serializable, Comparable<Resource> {
    private int id;                                     //id,自增
    private String powerName;                           //资源名称
    private String powerUrl;                            //资源地址
    private Date registerTime;
    private String powerRemark;
    private Integer pid;                                //父资源id
    private Integer ppid;                                //属于那个系统
    private Integer type;                               //资源类型
    private String iconCls;                             //界面图标样式
    private String powerNameStr;                       //资源名称(数据库不存在该字段)
    private Set<Role> tbRoles = new HashSet<Role>();     //该资源可能有多个角色
    private Integer resourceNum;            //资源排序

    private String token;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "powerName", length = 40)
    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }

    @Column(name = "powerUrl", length = 255)
    public String getPowerUrl() {
        return powerUrl;
    }

    public void setPowerUrl(String powerUrl) {
        this.powerUrl = powerUrl;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "registerTime", length = 19)
    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    @Column(name = "powerRemark", length = 255)
    public String getPowerRemark() {
        return powerRemark;
    }

    public void setPowerRemark(String powerRemark) {
        this.powerRemark = powerRemark;
    }

    @Column(name = "pid")
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Column(name = "ppid")
    public Integer getPpid() {
        return ppid;
    }

    public void setPpid(Integer ppid) {
        this.ppid = ppid;
    }

    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Column(name = "iconCls")
    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    @Transient
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Column(name = "resourceNum", columnDefinition = "INT default 0")
    public Integer getResourceNum() {
        return resourceNum;
    }

    public void setResourceNum(Integer resourceNum) {
        this.resourceNum = resourceNum;
    }
    //    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST},mappedBy = "tbResources")
    //    public Set<Role> getTbRoles() {
    //        return tbRoles;
    //    }
    //
    //    public void setTbRoles(Set<Role> tbRoles) {
    //        this.tbRoles = tbRoles;
    //    }


    @Override
    public String toString() {
        return "Resource{" + "id=" + id + ", powerName='" + powerName + '\'' + ", powerUrl='" + powerUrl + '\'' + ", registerTime=" + registerTime + ", powerRemark='" + powerRemark + '\'' + ", pid=" + pid + ", ppid=" + ppid + ", type=" + type + ", iconCls='" + iconCls + '\'' + ", powerNameStr='" + powerNameStr + '\'' + ", tbRoles=" + tbRoles + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Resource resource = (Resource) o;

        if (id != resource.id)
            return false;
        if (powerName != null ? !powerName.equals(resource.powerName) : resource.powerName != null)
            return false;
        if (powerUrl != null ? !powerUrl.equals(resource.powerUrl) : resource.powerUrl != null)
            return false;
        if (registerTime != null ? !registerTime.equals(resource.registerTime) : resource.registerTime != null)
            return false;
        if (powerRemark != null ? !powerRemark.equals(resource.powerRemark) : resource.powerRemark != null)
            return false;
        if (pid != null ? !pid.equals(resource.pid) : resource.pid != null)
            return false;
        if (ppid != null ? !ppid.equals(resource.ppid) : resource.ppid != null)
            return false;
        if (type != null ? !type.equals(resource.type) : resource.type != null)
            return false;
        if (iconCls != null ? !iconCls.equals(resource.iconCls) : resource.iconCls != null)
            return false;
        if (powerNameStr != null ? !powerNameStr.equals(resource.powerNameStr) : resource.powerNameStr != null)
            return false;
        if (tbRoles != null ? !tbRoles.equals(resource.tbRoles) : resource.tbRoles != null)
            return false;
        if (resourceNum != null ? !resourceNum.equals(resource.resourceNum) : resource.resourceNum != null)
            return false;
        return token != null ? token.equals(resource.token) : resource.token == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (powerName != null ? powerName.hashCode() : 0);
        result = 31 * result + (powerUrl != null ? powerUrl.hashCode() : 0);
        result = 31 * result + (registerTime != null ? registerTime.hashCode() : 0);
        result = 31 * result + (powerRemark != null ? powerRemark.hashCode() : 0);
        result = 31 * result + (pid != null ? pid.hashCode() : 0);
        result = 31 * result + (ppid != null ? ppid.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (iconCls != null ? iconCls.hashCode() : 0);
        result = 31 * result + (powerNameStr != null ? powerNameStr.hashCode() : 0);
        result = 31 * result + (tbRoles != null ? tbRoles.hashCode() : 0);
        result = 31 * result + (resourceNum != null ? resourceNum.hashCode() : 0);
        result = 31 * result + (token != null ? token.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Resource o) {
        return o.getResourceNum().compareTo(this.getResourceNum());
    }
}
