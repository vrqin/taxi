package com.spring.jersy.hibernate.publics.bean;

import java.util.ArrayList;
import java.util.List;

public class TreeBean {
    private int id;
    private String text;
    private String state;
    private boolean checked;
    private int pid;
    private List<TreeBean> children;
    private String iconCls;//节点图标
    private String msid;

    public TreeBean() {
        this.children = new ArrayList<TreeBean>();
    }

    public TreeBean(int id, String text) {
        this.id = id;
        this.text = text;
        this.children = new ArrayList<TreeBean>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<TreeBean> getChildren() {
        return children;
    }

    public void setChildren(List<TreeBean> children) {
        this.children = children;
    }

    public boolean getChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getMsid() {
        return msid;
    }

    public void setMsid(String msid) {
        this.msid = msid;
    }
}
