package com.spring.jersy.hibernate.publics.bean;

/**
 * 乘客统计2
 * Created by Administrator on 2016/11/15.
 */
public class PasserCallBussReport extends CallBussReport {
    private String opruser;  //坐席帐号

    private String name;//姓名

    public String getOpruser() {
        return opruser;
    }

    public void setOpruser(String opruser) {
        this.opruser = opruser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}