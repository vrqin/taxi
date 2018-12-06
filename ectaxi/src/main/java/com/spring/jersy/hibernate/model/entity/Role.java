package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * tab_role
 * 角色信息表
 * Created by Administrator on 2016/9/30.
 */
@Entity
@Table(name = "tab_role")
public class Role implements Serializable {

    private Integer roleId;                                 //id,自增
    private String roleName;                                //角色名称
    private Date registerTime;                           //创建时间
    private String roleRemark;                           //备注
    private String name;                                    //角色名称((数据库不存在该字段))
    private String clientid;
    //    private Set<User> userHashSet = new HashSet<User>(); //该角色可能有多个用户
    private Set<Resource> tbResources = new HashSet<Resource>(); //该角色可能有很多资源


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "roleId", unique = true, nullable = false, length = 11)
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Column(name = "roleName", length = 20)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "registerTime", length = 50)
    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    @Column(name = "roleRemark", length = 20)
    public String getRoleRemark() {
        return roleRemark;
    }

    public void setRoleRemark(String roleRemark) {
        this.roleRemark = roleRemark;
    }

    @Column(name = "name", length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "clientid", length = 20, columnDefinition = "INT default 0")
    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid;
    }

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "tab_role_resource", joinColumns = {@JoinColumn(name = "role_id")}, inverseJoinColumns = {@JoinColumn(name = "resource_id")})
    public Set<Resource> getTbResources() {
        return tbResources;
    }

    public void setTbResources(Set<Resource> tbResources) {
        this.tbResources = tbResources;
    }
}
